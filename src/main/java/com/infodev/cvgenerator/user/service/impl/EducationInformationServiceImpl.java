package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.EducationInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.repository.EducationInformationRepository;
import com.infodev.cvgenerator.user.service.EducationInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EducationInformationServiceImpl implements EducationInformationService {
    private final EducationInformationRepository educationInformationRepository;
    private final EducationInformationEntityDtoConverter educationInformationEntityDtoConverter;

    public EducationInformationServiceImpl(EducationInformationRepository educationInformationRepository, EducationInformationEntityDtoConverter educationInformationEntityDtoConverter) {
        this.educationInformationRepository = educationInformationRepository;
        this.educationInformationEntityDtoConverter = educationInformationEntityDtoConverter;
    }

    @Override
    public EducationInformationDto SaveEducationInformation(EducationInformationDto educationInformationDto) {
        return educationInformationEntityDtoConverter.toDto((educationInformationRepository
                .save(educationInformationEntityDtoConverter.toEntity(educationInformationDto))));
    }


    @Override
    public List<EducationInformationDto> getAllEducationInformation() {
        List<EducationInformation> entityList = educationInformationRepository.findAll();
        return educationInformationEntityDtoConverter.toDto(entityList);
    }

    @Override
    public EducationInformationDto getEducationInformationById(Short id) {

        return educationInformationEntityDtoConverter.toDto(educationInformationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Education Information not found with id: " + id
        )));
    }

    @Override
    public EducationInformationDto updateEducationInformationIById(Short id, EducationInformationDto educationInformationDto) {
        EducationInformation educationInformation = educationInformationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Education Information not found with id: " + id));
        BeanUtils.copyProperties(educationInformationDto, educationInformation);
        EducationInformation updatedEducationInformation = educationInformationRepository.save(educationInformation);
        return educationInformationEntityDtoConverter.toDto(updatedEducationInformation);
    }

    @Override
    public boolean deleteEducationInformationById(Short id) {

        EducationInformation educationInformation = educationInformationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Education Information not found with id: " + id));
        educationInformationRepository.delete(educationInformation);
        return true;
    }

    @Override
    public List<EducationInformationDto> getEduInfosByBasicInfoId(Short basicInfoId) {
        return educationInformationEntityDtoConverter.toDto(educationInformationRepository.findEducationInformationsByBasicInformationId(basicInfoId));
    }
}
