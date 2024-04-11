package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.DistrictDto;
import com.infodev.cvgenerator.user.entity.District;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictDtoConverter extends AbstractConverter<DistrictDto, District>{
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public District toEntity(DistrictDto dto){
        return super.toEntity(dto);
    }

    public DistrictDto toDto(District entity){
        return modelMapper.map(entity, DistrictDto.class);
    }

    public List<DistrictDto> toDto(List<District> entityList){
        if(entityList.isEmpty()){
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
