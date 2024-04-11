package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.DistrictDtoConverter;
import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.dto.DistrictDto;
import com.infodev.cvgenerator.user.entity.Country;
import com.infodev.cvgenerator.user.entity.District;
import com.infodev.cvgenerator.user.repository.DistrictRepository;
import com.infodev.cvgenerator.user.service.DistrictService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictDtoConverter districtDtoConverter;

    public DistrictServiceImpl(DistrictRepository districtRepository, DistrictDtoConverter districtDtoConverter) {
        this.districtRepository = districtRepository;
        this.districtDtoConverter = districtDtoConverter;
    }

    @Override
    public List<DistrictDto> getAllDistricts() {
        return districtDtoConverter.toDto(districtRepository.findAll());
    }

    public DistrictDto convertToDto(District district){
        DistrictDto districtDto = new DistrictDto();
        BeanUtils.copyProperties(district,districtDto);
        if(district.getProvince() !=null){
            districtDto.setProvinceId(district.getProvince().getId());
        }
        return districtDto;
    }
}
