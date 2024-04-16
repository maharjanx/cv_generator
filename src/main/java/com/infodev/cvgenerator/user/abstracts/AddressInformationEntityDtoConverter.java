package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.dto.IdNameDto;
import com.infodev.cvgenerator.user.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressInformationEntityDtoConverter extends AbstractConverter<AddressInformationRequestDto, AddressInformation>{

    @Override
    public AddressInformation toEntity(AddressInformationRequestDto dto) {
        return AddressInformation.builder()
                .id(dto.getId())
                .addressType(dto.getAddressType())
                .country(getCountry(dto.getCountryId()))
                .district(getDistrict(dto.getDistrictId()))
                .localLevel(getLocallevel(dto.getLocallevelId()))
                .province(getProvince(dto.getProvinceId()))
                .basicInformation(getBasicInformation(dto.getBasicInformationId()))
                .build();
    }

    @Override
    public AddressInformationRequestDto toDto(AddressInformation entity){
        return AddressInformationRequestDto.builder()
                .id(entity.getId())
                .basicInformationId(getIdName(entity.getBasicInformation()).getId())
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
      public IdNameDto getIdName(BasicInformation entity){
        return IdNameDto.builder().id(entity.getId()).build();
    }


    public Country getCountry(Short id){
        return Country.builder().id(id).build();
    }
    public District getDistrict(Short id){
        return District.builder().id(id).build();
    }
    public Province getProvince(Short id){
        return Province.builder().id(id).build();
    }

    public LocalLevel getLocallevel(Short id){
        return LocalLevel.builder().id(id).build();
    }
    public BasicInformation getBasicInformation(Short id){
        return BasicInformation.builder().id(id).build();
    }

}


