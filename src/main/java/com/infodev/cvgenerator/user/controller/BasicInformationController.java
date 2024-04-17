package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.configuration.CustomMessageSource;
import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.service.BasicInformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/api/basic-information")
public class BasicInformationController extends BaseController {
    private final BasicInformationService basicInformationService;
    private final CustomMessageSource customMessageSource;

    public BasicInformationController(BasicInformationService basicInformationService, CustomMessageSource customMessageSource) {
        this.basicInformationService = basicInformationService;
        this.customMessageSource = customMessageSource;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@Valid @ModelAttribute  BasicInformationDto basicInformationDto, @RequestParam("file") MultipartFile file ){
        try {
            return  ResponseEntity.ok(getApiResponse(basicInformationService.saveBasicInformation(basicInformationDto, file), customMessageSource.get("crud.create"), true));

        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(getApiResponse(null, customMessageSource.get("error.create") + e.getMessage(), false ));
        }
    }
    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return  ResponseEntity.ok(getApiResponse(basicInformationService.getAllBasicInformation(), "Basic Information"+customMessageSource.get("crud.get.all") , true));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<APIResponse> findById(@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(basicInformationService.getBasicInformationById(id), "Basic Information with id: " + id + customMessageSource.get("crud.get"), true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateById(@PathVariable Short id, @Valid @ModelAttribute   BasicInformationDto basicInformationDto, @RequestParam(value = "file", required = false) MultipartFile file){
        try {
            return ResponseEntity.ok((getApiResponse(basicInformationService.updateBasicInfromationById(id, basicInformationDto, file), "Basic Information with id:" + id + customMessageSource.get("crud.update"), true)));

        }catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(getApiResponse(null, customMessageSource.get("error.upload") + e.getReason(), false));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete (@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(basicInformationService.deleteBasicInformationById(id), "Basic Information with id: " + id + customMessageSource.get("crud.delete"), true));
    }



}
