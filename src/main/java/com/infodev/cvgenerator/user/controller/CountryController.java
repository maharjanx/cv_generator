package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.entity.Country;
import com.infodev.cvgenerator.user.service.CountryService;
import com.infodev.cvgenerator.user.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController( CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public ResponseEntity<List<CountryDto>> find(){
        List<CountryDto> countries = countryService.getAllcountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
