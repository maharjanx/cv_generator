package com.infodev.cvgenerator.user.abstracts;


import com.infodev.cvgenerator.user.dto.IdNameDto;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectInformationEntityDtoConverter extends AbstractConverter<ProjectInformationDto, ProjectInformation> {


    @Override
    public ProjectInformation toEntity(ProjectInformationDto dto) {
        return ProjectInformation.builder()
                .projectName(dto.getProjectName())
                .projectDescription(dto.getProjectDescription())
                .projectRole(dto.getProjectRole())
                .projectStatus(dto.getProjectStatus())
                .projectUrl(dto.getProjectUrl())
                .experienceInformation(getExperienceInformation(dto.getExperienceInformationId()))
                .build();
    }

    @Override
    public ProjectInformationDto toDto(ProjectInformation entity) {

        return ProjectInformationDto.builder()
                .projectName(entity.getProjectName())
                .projectDescription(entity.getProjectDescription())
                .projectRole(entity.getProjectRole())
                .projectStatus(entity.getProjectStatus())
                .projectUrl(entity.getProjectUrl())
                .experienceInformationId(getIdName(entity.getExperienceInformation()).getId())
                .build();
    }

    @Override
    public List<ProjectInformationDto> toDto(List<ProjectInformation> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }


    public ExperienceInformation getExperienceInformation(Short id) {
        return ExperienceInformation.builder().id(id).build();
    }

    public IdNameDto getIdName(ExperienceInformation entity) {
        return IdNameDto.builder().id(entity.getId()).build();
    }
}



