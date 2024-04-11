package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.ProjectInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import com.infodev.cvgenerator.user.repository.ProjectInformationRepository;
import com.infodev.cvgenerator.user.service.ProjectInformationService;
import org.springframework.stereotype.Service;

@Service
public class ProjectInformationServiceImpl implements ProjectInformationService {
    private final ProjectInformationRepository projectInformationRepository;
    private final ProjectInformationEntityDtoConverter projectInformationEntityDtoConverter;

    public ProjectInformationServiceImpl(ProjectInformationRepository projectInformationRepository, ProjectInformationEntityDtoConverter projectInformationEntityDtoConverter) {
        this.projectInformationRepository = projectInformationRepository;
        this.projectInformationEntityDtoConverter = projectInformationEntityDtoConverter;
    }

    @Override
    public ProjectInformation saveProjectInformation(ProjectInformationDto projectInformationDto) {
        ProjectInformation entity =projectInformationEntityDtoConverter.toEntity(projectInformationDto);
        return projectInformationRepository.save(entity);
    }
}
