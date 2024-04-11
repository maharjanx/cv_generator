package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasicInformationEntityDtoConvertor extends AbstractConverter<BasicInformationDto, BasicInformation> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BasicInformation toEntity(BasicInformationDto dto) {
        BasicInformationDto basicInformationDto = BasicInformationDto
                .builder()
                .email(dto.getEmail())
                .build();
        return modelMapper.map(dto, BasicInformation.class);
    }

    @Override
    public BasicInformationDto toDto(BasicInformation entity) {
        return modelMapper.map(entity, BasicInformationDto.class);
    }

    @Override
    public List<BasicInformationDto> toDto(List<BasicInformation> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
