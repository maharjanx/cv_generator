package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.ENUM.DegreeName;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.dto.IdNameDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.entity.Province;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EducationInformationEntityDtoConverter extends AbstractConverter<EducationInformationDto, EducationInformation> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EducationInformation toEntity(EducationInformationDto dto) {
        return EducationInformation.builder()
                .basicInformation(getBasicInformation(dto.getBasicInformationId()))
                .degreeName(dto.getDegreeName())
                .educationDescription(dto.getEducationDescription())
                .institutionName(dto.getInstitutionName())
                .institutionAddress(dto.getInstitutionAddress())
                .institutionContact(dto.getInstitutionContact())
                .fromDate(dto.getFromDate())
                .toDate(dto.getToDate())
                .toPresent(dto.isToPresent())
                .build();
    }

    @Override
    public EducationInformationDto toDto(EducationInformation entity){
        return EducationInformationDto.builder()
                .basicInformationId(getIdName(entity.getBasicInformation()).getId())
                .degreeName(entity.getDegreeName())
                .educationDescription(entity.getEducationDescription())
                .institutionName(entity.getInstitutionName())
                .institutionAddress(entity.getInstitutionAddress())
                .institutionContact(entity.getInstitutionContact())
                .fromDate(entity.getFromDate())
                .toDate(entity.getToDate())
                .toPresent(entity.isToPresent())
                .build();
    }

    @Override
    public List<EducationInformationDto> toDto(List<EducationInformation> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }


    private Converter<String, DegreeName> degreeNameConverter() {
        return mappingContext -> DegreeName.valueOf(mappingContext.getSource());
    }


    public BasicInformation getBasicInformation(Short id){
        return BasicInformation.builder().id(id).build();
    }
    public IdNameDto getIdName(BasicInformation entity){
        return IdNameDto.builder().id(entity.getId()).build();
    }
}
