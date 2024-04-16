package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;

import java.util.List;

public interface EducationInformationService {
    EducationInformationDto SaveEducationInformation(EducationInformationDto educationInformationDto);
    List<EducationInformationDto> getAllEducationInformation();
    EducationInformationDto getEducationInformationById(Short id);

    EducationInformationDto updateEducationInformationIById(Short id, EducationInformationDto educationInformationDto);

    boolean deleteEducationInformationById(Short id);
    List<EducationInformationDto> getEduInfosByBasicInfoId(Short basicInfoId);
}
