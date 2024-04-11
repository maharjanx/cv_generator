package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.service.ExperienceInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/experience-information")
public class ExperienceInformationController {
    private final ExperienceInformationService experienceInformationService;

    public ExperienceInformationController(ExperienceInformationService experienceInformationService) {
        this.experienceInformationService = experienceInformationService;
    }

    @PostMapping
    public ResponseEntity<ExperienceInformation> create(@RequestBody ExperienceInformationDto experienceInformationDto){
        ExperienceInformation entity = experienceInformationService.saveExperienceInformation(experienceInformationDto);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }
}
