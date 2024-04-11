package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.dto.IdNameDto;
import com.infodev.cvgenerator.user.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressInformationEntityDtoConverter extends AbstractConverter<AddressInformationRequestDto, AddressInformation>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AddressInformation toEntity(AddressInformationRequestDto dto) {
        return modelMapper.map(dto, AddressInformation.class);
    }

    @Override
    public AddressInformationRequestDto toDto(AddressInformation entity){
        return AddressInformationRequestDto.builder()
                .id(entity.getId())
                .addressType(entity.getAddressType())
                .country(getIdName(entity.getCountry()))
                .district(getIdName(entity.getDistrict()))
                .localLevel(getIdName(entity.getLocalLevel()))
                .province(getIdName(entity.getProvince()))
                .build();
    }
    
    public List<AddressInformationRequestDto> toDto(List<AddressInformation> entityList){
        if (entityList.isEmpty()){
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public IdNameDto getIdName(Province entity){
        return IdNameDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

    public IdNameDto getIdName(Country entity){
        return IdNameDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

    public IdNameDto getIdName(District entity){
        return IdNameDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

    public IdNameDto getIdName(LocalLevel entity){
        return IdNameDto.builder().id(entity.getId()).name(entity.getName()).build();
    }

}


