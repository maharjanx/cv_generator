package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.entity.Country;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDtoConverter extends AbstractConverter<CountryDto, Country>{

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Country toEntity(CountryDto dto) {
        return super.toEntity(dto);
    }

    @Override
    public CountryDto toDto(Country entity) {
        return modelMapper.map(entity, CountryDto.class);
    }

    @Override
    public List<CountryDto> toDto(List<Country> entityList) {
        if(entityList.isEmpty())
            return null;
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
