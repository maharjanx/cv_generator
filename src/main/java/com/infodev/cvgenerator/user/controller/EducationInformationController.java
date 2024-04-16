package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.service.EducationInformationService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education-information")
public class EducationInformationController extends BaseController {
    private final EducationInformationService educationInformationService;


    public EducationInformationController(EducationInformationService educationInformationService) {
        this.educationInformationService = educationInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@Valid @RequestBody  EducationInformationDto educationInformationDto) {
        return ResponseEntity.ok(getApiResponse(educationInformationService.SaveEducationInformation(educationInformationDto), "Education Information Saved Successfully", true));
    }

    @GetMapping
    public ResponseEntity<APIResponse> find() {
        return ResponseEntity.ok((getApiResponse(educationInformationService.getAllEducationInformation(), "List of Education Information Fetched Successfully", true)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable Short id) {
        return ResponseEntity.ok(getApiResponse(educationInformationService.getEducationInformationById(id), "Education Information fetched successfully with id:" + id, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateById
            (@PathVariable Short id, @Valid @RequestBody EducationInformationDto educationInformationDto) {
        return ResponseEntity.ok(getApiResponse(educationInformationService
                        .updateEducationInformationIById(id, educationInformationDto),
                "Education Information updated successfully with id :" + id,
                true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> DeleteById( @PathVariable Short id){
        return ResponseEntity.ok(getApiResponse(educationInformationService.deleteEducationInformationById(id),
                "Education Information deleted!!!",
                true));
    }

    @GetMapping("by-basic-info-id/{basicInfoId}")
    public ResponseEntity<APIResponse> getByBasicInfoId(@PathVariable("basicInfoId") Short basicInfoId){
        return ResponseEntity.ok(getApiResponse(educationInformationService.getEduInfosByBasicInfoId(basicInfoId), "fetched successfully", true));
    }

}