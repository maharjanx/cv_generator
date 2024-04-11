package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.DistrictDto;
import com.infodev.cvgenerator.user.service.DistrictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/district")
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public ResponseEntity<List<DistrictDto>> find(){
        List<DistrictDto> districtDtos = districtService.getAllDistricts();
        return new  ResponseEntity<>(districtDtos, HttpStatus.OK);
    }
}
