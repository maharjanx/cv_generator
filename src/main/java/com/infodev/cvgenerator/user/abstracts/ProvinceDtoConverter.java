package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.dto.ProvinceDto;
import com.infodev.cvgenerator.user.entity.Country;
import com.infodev.cvgenerator.user.entity.Province;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceDtoConverter extends AbstractConverter<ProvinceDto, Province> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Province toEntity(ProvinceDto dto) {
        return super.toEntity(dto);
    }

    @Override
    public ProvinceDto toDto(Province entity){
        return modelMapper.map(entity, ProvinceDto.class);
    }

    public List<ProvinceDto> toDto(List<Province> entityList) {
        if(entityList.isEmpty())
            return null;
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
