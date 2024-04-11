package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.CountryDtoConverter;
import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.entity.Country;
import com.infodev.cvgenerator.user.repository.CountryRepository;
import com.infodev.cvgenerator.user.service.CountryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service // Annotate with @Service to mark it as a Spring-managed component
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryDtoConverter countryDtoConverter;

    public CountryServiceImpl(CountryRepository countryRepository, CountryDtoConverter countryDtoConverter) {
        this.countryRepository = countryRepository;
        this.countryDtoConverter = countryDtoConverter;
    }

    @Override
    public List<CountryDto> getAllcountries() {
        return countryDtoConverter.toDto(countryRepository.findAll());
    }

    @Override
    public CountryDto getCountryById(Short id) {
//        return countryDtoConverter.toDto(countryRepository.findById(id).orElse(null));
        return countryDtoConverter.toDto(countryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "country not fount with id: "+id)));
    }


}
