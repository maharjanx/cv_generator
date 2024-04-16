package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.ProjectInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import com.infodev.cvgenerator.user.repository.ProjectInformationRepository;
import com.infodev.cvgenerator.user.service.ProjectInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProjectInformationServiceImpl implements ProjectInformationService {
    private final ProjectInformationRepository projectInformationRepository;
    private final ProjectInformationEntityDtoConverter projectInformationEntityDtoConverter;

    public ProjectInformationServiceImpl(ProjectInformationRepository projectInformationRepository, ProjectInformationEntityDtoConverter projectInformationEntityDtoConverter) {
        this.projectInformationRepository = projectInformationRepository;
        this.projectInformationEntityDtoConverter = projectInformationEntityDtoConverter;
    }


    @Override
    public ProjectInformationDto saveProjectInformation(ProjectInformationDto projectInformationDto) {
        return projectInformationEntityDtoConverter.toDto(projectInformationRepository.
                save(projectInformationEntityDtoConverter.toEntity(projectInformationDto)));
    }

    @Override
    public List<ProjectInformationDto> getAllProjectInformation() {
        List<ProjectInformation> entityList = projectInformationRepository.findAll();
        return projectInformationEntityDtoConverter.toDto(entityList);
    }

    @Override
    public ProjectInformationDto getProjectInformationById(Short id) {
        return projectInformationEntityDtoConverter
                .toDto(projectInformationRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Information not found with id: " + id)));
    }

    @Override
    public ProjectInformationDto updateProjectInformationById(Short id, ProjectInformationDto projectInformationDto) {
        ProjectInformation entity = projectInformationRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Information not found with id: " + id));
        BeanUtils.copyProperties(projectInformationDto, entity);
        ProjectInformation updatedProjectInformation = projectInformationRepository.save(entity);
        return projectInformationEntityDtoConverter.toDto(updatedProjectInformation);
    }

    @Override
    public boolean deleteProjectInformationById(Short id) {

        ProjectInformation projectInformation = projectInformationRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Information not found with id:" + id));
        projectInformationRepository.delete(projectInformation);
        return true;
    }

    @Override
    public List<ProjectInformationDto> getProjectInfoByExpInfoId(Short expInfoId) {
        return projectInformationEntityDtoConverter
                .toDto(projectInformationRepository
                        .findProjectInformationsByExperienceInformationId(expInfoId));
    }

    @Override
    public List<ProjectInformationDto> getProjectInfosByBasicInfoId(Short basicInfoid) {
        return projectInformationEntityDtoConverter.toDto(projectInformationRepository.findByExperienceInformation_BasicInformation_Id(basicInfoid));
    }
}
