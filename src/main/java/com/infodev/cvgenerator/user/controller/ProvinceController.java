package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.ProvinceDto;
import com.infodev.cvgenerator.user.entity.Province;
import com.infodev.cvgenerator.user.service.ProvinceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public ResponseEntity<List<ProvinceDto>> find(){
        List<ProvinceDto> provinceDtos = provinceService.getAllProvinces();
        return new ResponseEntity<>(provinceDtos, HttpStatus.OK);
    }
}
