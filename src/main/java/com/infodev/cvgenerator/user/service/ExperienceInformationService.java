package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.EducationInformationDto;
import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.EducationInformation;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;

public interface ExperienceInformationService {
    ExperienceInformation saveExperienceInformation(ExperienceInformationDto experienceInformationDto);

}
