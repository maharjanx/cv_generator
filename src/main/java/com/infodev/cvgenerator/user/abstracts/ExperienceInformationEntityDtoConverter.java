package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.dto.IdNameDto;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExperienceInformationEntityDtoConverter extends AbstractConverter<ExperienceInformationDto, ExperienceInformation>{

    @Autowired
    private ProjectInformationEntityDtoConverter projectInformationEntityDtoConverter;


    @Override
    public ExperienceInformation toEntity(ExperienceInformationDto dto){
        return ExperienceInformation.builder()
                .basicInformation(getBasicInformation(dto.getBasicInformationId()))
                .companyName(dto.getCompanyName())
                .companyAddress(dto.getCompanyAddress())
                .companyContact(dto.getCompanyContact())
                .fromDate(dto.getFromDate())
                .toDate(dto.getToDate())
                .toPresent(dto.isToPresent())
                .build();
    }
    @Override
    public ExperienceInformationDto toDto(ExperienceInformation entity){
        List<ProjectInformationDto> projectInformationDtos = null;
        if (entity.getProjectInformations() !=null){
            projectInformationDtos = projectInformationEntityDtoConverter.toDto(entity.getProjectInformations().stream().toList());
        }
        return  ExperienceInformationDto.builder()
                .basicInformationId(getIdName(entity.getBasicInformation()).getId())
                .companyName(entity.getCompanyName())
                .companyAddress(entity.getCompanyAddress())
                .companyContact(entity.getCompanyContact())
                .fromDate(entity.getFromDate())
                .toDate(entity.getToDate())
                .toPresent(entity.isToPresent())
                .projectInformations(projectInformationDtos)
                .build();
    }


    @Override
    public List<ExperienceInformationDto> toDto(List<ExperienceInformation> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }


    public BasicInformation getBasicInformation(Short id){
        return BasicInformation.builder().id(id).build();
    }
    public IdNameDto getIdName(BasicInformation entity){
        return IdNameDto.builder().id(entity.getId()).build();
    }

//    public Date getDate(Date date){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//
//            String s = sdf.format(date);
//            Date d = sdf.parse(s);
//            return d;
//        } catch (ParseException e) {
//            return null;
//        }
//    }
}
