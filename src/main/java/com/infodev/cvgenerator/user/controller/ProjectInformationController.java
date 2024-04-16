package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.service.ProjectInformationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project-information")
public class ProjectInformationController extends BaseController {
    private final ProjectInformationService projectInformationService;


    public ProjectInformationController(ProjectInformationService projectInformationService) {
        this.projectInformationService = projectInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> save(@Valid @RequestBody ProjectInformationDto projectInformationDto) {
        return ResponseEntity.ok(getApiResponse(projectInformationService.saveProjectInformation(projectInformationDto), "Project Information Saved Successfully...", true));

    }

    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return ResponseEntity.ok(getApiResponse(projectInformationService.getAllProjectInformation(), "List of project Information fetched Successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable Short id) {
        return ResponseEntity.ok(getApiResponse(projectInformationService.getProjectInformationById(id),
                "Project Information fetched with id:" + id,
                true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateById(@PathVariable Short id,@Valid @RequestBody ProjectInformationDto projectInformationDto) {
        return ResponseEntity.ok(getApiResponse(projectInformationService.updateProjectInformationById(id, projectInformationDto),
                "Updated Project Information with id: " + id,
                true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteById(@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(projectInformationService.deleteProjectInformationById(id), "Project Information Deleted!!!", true));
    }

    @GetMapping("/by-exp-id/{expInfoId}")
    public ResponseEntity<APIResponse> getProjectInfoByExpInfoId(@PathVariable("expInfoId") Short expInfoId){
        return ResponseEntity.ok(getApiResponse(projectInformationService.getProjectInfoByExpInfoId(expInfoId), "Project Information fetched with experience info id:" + expInfoId, true));
    }

    @GetMapping("/by-basic-info-id/{basicInfoId}")
    public ResponseEntity<APIResponse> getProjectInfoByBasicInfoId(@PathVariable("basicInfoId") Short basicInfoId){
        return ResponseEntity.ok(getApiResponse(projectInformationService.getProjectInfosByBasicInfoId(basicInfoId),"fetched through basic info id: " + basicInfoId, true));
    }
}
