package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.AddressInformation;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasicInformationEntityDtoConvertor extends AbstractConverter<BasicInformationDto, BasicInformation> {


    @Override
    public BasicInformation toEntity(BasicInformationDto dto) {

        return BasicInformation.builder()
                .email(dto.getEmail())
                .background(dto.getBackground())
                .title(dto.getTitle())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .linkedInUrl(dto.getLinkedInUrl())
                .mobileNumber(dto.getMobileNumber())
                .fileInformation(dto.getFileInformation())
                .build();

    }


    @Override
    public BasicInformationDto toDto(BasicInformation entity) {
        return BasicInformationDto.builder()
                .email(entity.getEmail())
                .background(entity.getBackground())
                .title(entity.getTitle())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .linkedInUrl(entity.getLinkedInUrl())
                .mobileNumber(entity.getMobileNumber())
                .fileInformation(entity.getFileInformation())
                .build();
    }

    @Override
    public List<BasicInformationDto> toDto(List<BasicInformation> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
