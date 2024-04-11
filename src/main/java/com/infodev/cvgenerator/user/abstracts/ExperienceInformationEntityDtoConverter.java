package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceInformationEntityDtoConverter extends AbstractConverter<ExperienceInformationDto, ExperienceInformation>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ExperienceInformation toEntity(ExperienceInformationDto dto){
        return modelMapper.map(dto, ExperienceInformation.class);
    }
}
