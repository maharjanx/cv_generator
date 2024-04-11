package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.EducationInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.repository.EducationInformationRepository;
import com.infodev.cvgenerator.user.service.EducationInformationService;
import org.springframework.stereotype.Service;

@Service
public class EducationInformationServiceImpl implements EducationInformationService {
    private final EducationInformationRepository educationInformationRepository;
    private final EducationInformationEntityDtoConverter educationInformationEntityDtoConverter;
    public EducationInformationServiceImpl(EducationInformationRepository educationInformationRepository, EducationInformationEntityDtoConverter educationInformationEntityDtoConverter) {
        this.educationInformationRepository = educationInformationRepository;
        this.educationInformationEntityDtoConverter = educationInformationEntityDtoConverter;
    }

    @Override
    public EducationInformation SaveEducationInformation(EducationInformationDto educationInformationDto) {
        EducationInformation entity = educationInformationEntityDtoConverter.toEntity(educationInformationDto);
        return educationInformationRepository.save(entity);
    }
}
