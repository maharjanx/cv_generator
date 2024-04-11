package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;

public interface EducationInformationService {
    EducationInformation SaveEducationInformation(EducationInformationDto educationInformationDto);
}
