package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.ExperienceInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.repository.ExperienceInformationRepository;
import com.infodev.cvgenerator.user.service.ExperienceInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExperienceInformationServiceImpl implements ExperienceInformationService {
    private final ExperienceInformationRepository experienceInformationRepository;
    private final ExperienceInformationEntityDtoConverter experienceInformationEntityDtoConverter;

    public ExperienceInformationServiceImpl(ExperienceInformationRepository experienceInformationRepository, ExperienceInformationEntityDtoConverter experienceInformationEntityDtoConverter) {
        this.experienceInformationRepository = experienceInformationRepository;
        this.experienceInformationEntityDtoConverter = experienceInformationEntityDtoConverter;
    }


    @Override
    public ExperienceInformationDto saveExperienceInformation(ExperienceInformationDto experienceInformationDto) {
        return experienceInformationEntityDtoConverter.toDto(experienceInformationRepository
                .save(experienceInformationEntityDtoConverter.toEntity(experienceInformationDto)));
    }

    @Override
    public List<ExperienceInformationDto> getAllExperienceInformation() {
        List<ExperienceInformation> entityList = experienceInformationRepository.findAll();
        return experienceInformationEntityDtoConverter.toDto(entityList);
    }


    @Override
    public ExperienceInformationDto getExperienceInformationById(Short id) {
        return experienceInformationEntityDtoConverter.toDto(experienceInformationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Experience Information Not found with id: " + id
        )));
    }

    @Override
    public ExperienceInformationDto updateExperienceInformationById(Short id, ExperienceInformationDto experienceInformationDto) {
        ExperienceInformation entity = experienceInformationRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience Information not found with id: "  + id));
        BeanUtils.copyProperties(experienceInformationDto, entity);
        ExperienceInformation updatedExperienceInformation = experienceInformationRepository.save(entity);
        return experienceInformationEntityDtoConverter.toDto(updatedExperienceInformation);
    }

    @Override
    public boolean deleteExperienceInformationById(Short id) {
        ExperienceInformation entity = experienceInformationRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience Information not found with id: " + id));
        experienceInformationRepository.delete(entity);
        return true;
    }

    @Override
    public List<ExperienceInformationDto> getExpInfosByBasicInfoId(Short basicInfoId) {
        return experienceInformationEntityDtoConverter.toDto(experienceInformationRepository.findExperienceInformationsByBasicInformationId(basicInfoId));
    }


}
