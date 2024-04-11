package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.service.EducationInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education-information")
public class EducationInformationController {
    private final EducationInformationService educationInformationService;


    public EducationInformationController(EducationInformationService educationInformationService) {
        this.educationInformationService = educationInformationService;
    }

    @PostMapping
    public ResponseEntity<EducationInformation> create(@RequestBody @Validated EducationInformationDto educationInformationDto) {
        try {
            EducationInformation educationInformation = educationInformationService.SaveEducationInformation(educationInformationDto);
            return new ResponseEntity<>(educationInformation, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = "Failed To Create Education Information: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}