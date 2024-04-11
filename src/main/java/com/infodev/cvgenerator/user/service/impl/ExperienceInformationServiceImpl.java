package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.ExperienceInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.repository.ExperienceInformationRepository;
import com.infodev.cvgenerator.user.service.ExperienceInformationService;
import org.springframework.stereotype.Service;

@Service
public class ExperienceInformationServiceImpl implements ExperienceInformationService {
    private final ExperienceInformationRepository experienceInformationRepository;
    private final ExperienceInformationEntityDtoConverter experienceInformationEntityDtoConverter;

    public ExperienceInformationServiceImpl(ExperienceInformationRepository experienceInformationRepository, ExperienceInformationEntityDtoConverter experienceInformationEntityDtoConverter) {
        this.experienceInformationRepository = experienceInformationRepository;
        this.experienceInformationEntityDtoConverter = experienceInformationEntityDtoConverter;
    }

    @Override
    public ExperienceInformation saveExperienceInformation(ExperienceInformationDto experienceInformationDto) {
        ExperienceInformation entity = experienceInformationEntityDtoConverter.toEntity(experienceInformationDto);
        return experienceInformationRepository.save(entity);
    }
}
