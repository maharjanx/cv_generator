package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.entity.Country;
import com.infodev.cvgenerator.user.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CountryService {


    List<CountryDto> getAllcountries();
    CountryDto getCountryById(Short id);
}
