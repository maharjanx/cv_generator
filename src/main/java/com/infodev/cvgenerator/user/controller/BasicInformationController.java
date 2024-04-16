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
            return  ResponseEntity.ok(getApiResponse(basicInformationService.saveBasicInformation(basicInformationDto, file), customMessageSource.get("crud.save"), true));

        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(getApiResponse(null, "Failed to save basic  information" + e.getMessage(), false ));
        }
    }
    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return  ResponseEntity.ok(getApiResponse(basicInformationService.getAllBasicInformation(), customMessageSource.getNepali("crud.save")  , true));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<APIResponse> findById(@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(basicInformationService.getBasicInformationById(id), "Basic Information with id: " + id + "fetched successfully", true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateById(@PathVariable Short id, @Valid @ModelAttribute   BasicInformationDto basicInformationDto, @RequestParam(value = "file", required = false) MultipartFile file){
        try {
            return ResponseEntity.ok((getApiResponse(basicInformationService.updateBasicInfromationById(id, basicInformationDto, file), "Basic Information with id:" + id + "updated Successfully!!!", true)));

        }catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(getApiResponse(null, e.getReason(), false));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete (@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(basicInformationService.deleteBasicInformationById(id), "Basic Information Deleted!!! id: " + id, true));
    }



}
