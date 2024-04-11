package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.BasicInformationEntityDtoConvertor;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.repository.BasicInformationRepository;
import com.infodev.cvgenerator.user.service.BasicInformationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInformationServiceImpl implements BasicInformationService {
    private final BasicInformationRepository basicInformationRepository;
    private final BasicInformationEntityDtoConvertor basicInformationEntityDtoConvertor;

    public BasicInformationServiceImpl(BasicInformationRepository basicInformationRepository, BasicInformationEntityDtoConvertor basicInformationEntityDtoConvertor) {
        this.basicInformationRepository = basicInformationRepository;
        this.basicInformationEntityDtoConvertor = basicInformationEntityDtoConvertor;
    }

    @Override
    public List<BasicInformationDto> getAllBasicInformation() {
        List<BasicInformation> entityList = basicInformationRepository.findAll();
        return basicInformationEntityDtoConvertor.toDto(entityList);
    }

    @Override
    public BasicInformation getBasicInformationById(Short id) {
        return null;
    }

    @Override
    public BasicInformationDto saveBasicInformation(BasicInformationDto basicInformationDto) {
        return basicInformationEntityDtoConvertor.toDto(basicInformationRepository.save(basicInformationEntityDtoConvertor.toEntity(basicInformationDto)));
    }

    @Override
    public void deleteBasicInformationById(Short id) {

    }
}
