package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import com.infodev.cvgenerator.user.service.impl.ProjectInformationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-information")
public class ProjectInformationController {
    private final ProjectInformationServiceImpl projectInformationService;

    public ProjectInformationController(ProjectInformationServiceImpl projectInformationService) {
        this.projectInformationService = projectInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@RequestBody @Valid ProjectInformationDto projectInformationDto){
        ProjectInformation entity = projectInformationService.saveProjectInformation(projectInformationDto);
        return ResponseEntity.ok(APIResponse.builder().data(entity).message("Data save successfully").success(true).build());
    }
}
