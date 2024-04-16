package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.service.ExperienceInformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience-information")
public class ExperienceInformationController extends BaseController {
    private final ExperienceInformationService experienceInformationService;

    public ExperienceInformationController(ExperienceInformationService experienceInformationService) {
        this.experienceInformationService = experienceInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@Valid @RequestBody ExperienceInformationDto experienceInformationDto) {
        return ResponseEntity.ok(getApiResponse(experienceInformationService.saveExperienceInformation(experienceInformationDto), "Experience Information Saved Successfully", true));

    }
    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return ResponseEntity.ok(getApiResponse(experienceInformationService.getAllExperienceInformation(),
                "List of Experience Information fetch successfully",
                true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(experienceInformationService.getExperienceInformationById(id), "Experience Information fetched with id:" + id, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateById(@PathVariable Short id, @Valid @RequestBody ExperienceInformationDto experienceInformationDto){
        return ResponseEntity.ok(getApiResponse(experienceInformationService.updateExperienceInformationById(id, experienceInformationDto),
                "Experience Information Updated Successfully!!!",
                true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteById(@PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(experienceInformationService.deleteExperienceInformationById(id), "Experience Information deleted !!!", true));
    }
    @GetMapping("/by-basic-info-id/{basicInfoId}")
    public ResponseEntity<APIResponse> getByBasicInfoId(@PathVariable("basicInfoId") Short basicInfoId){
        return ResponseEntity.ok(getApiResponse(experienceInformationService.getExpInfosByBasicInfoId(basicInfoId),"experience Info with basic id fetch successfully", true));
    }
}
