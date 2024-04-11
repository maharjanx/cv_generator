package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.service.BasicInformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basic-information")
public class BasicInformationController extends BaseController {
    private final BasicInformationService basicInformationService;

    public BasicInformationController(BasicInformationService basicInformationService) {
        this.basicInformationService = basicInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@RequestBody @Valid BasicInformationDto basicInformationDto) {

        return  ResponseEntity.ok(getApiResponse(basicInformationService.saveBasicInformation(basicInformationDto), "Data saved successfully", true));
    }


    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return  ResponseEntity.ok(getApiResponse(basicInformationService.getAllBasicInformation(), "Data fetch successfully", true));
    }
}
