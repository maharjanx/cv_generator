package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.ProvinceDtoConverter;
import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.dto.ProvinceDto;
import com.infodev.cvgenerator.user.entity.Province;
import com.infodev.cvgenerator.user.repository.ProvinceRepository;
import com.infodev.cvgenerator.user.service.ProvinceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;
    private final ProvinceDtoConverter provinceDtoConverter;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ProvinceDtoConverter provinceDtoConverter) {
        this.provinceRepository = provinceRepository;
        this.provinceDtoConverter = provinceDtoConverter;
    }


    @Override
    public List<ProvinceDto> getAllProvinces() {
        return provinceDtoConverter.toDto(provinceRepository.findAll());
    }

    public ProvinceDto convertTODto(Province province){
        ProvinceDto provinceDto = new ProvinceDto();
        BeanUtils.copyProperties(province, provinceDto);
        if (province.getCountry() !=null){
            provinceDto.setCountryId(province.getCountry().getId());
        }
        return provinceDto;
    }


}
