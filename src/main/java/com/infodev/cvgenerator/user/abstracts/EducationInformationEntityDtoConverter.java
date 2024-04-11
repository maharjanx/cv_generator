package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.ENUM.DegreeName;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationInformationEntityDtoConverter extends AbstractConverter<EducationInformationDto, EducationInformation> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EducationInformation toEntity(EducationInformationDto dto) {
//        modelMapper.addConverter(degreeNameConverter());
        return modelMapper.map(dto, EducationInformation.class);
    }


    private Converter<String, DegreeName> degreeNameConverter() {
        return mappingContext -> DegreeName.valueOf(mappingContext.getSource());
    }
}
