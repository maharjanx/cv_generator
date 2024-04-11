package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectInformationEntityDtoConverter extends AbstractConverter<ProjectInformationDto, ProjectInformation>{
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectInformation toEntity(ProjectInformationDto dto){
        return modelMapper.map(dto, ProjectInformation.class);
    }

}
