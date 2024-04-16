package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;

import java.util.List;

public interface ExperienceInformationService {
    ExperienceInformationDto saveExperienceInformation(ExperienceInformationDto experienceInformationDto);
    List<ExperienceInformationDto> getAllExperienceInformation ();
    ExperienceInformationDto getExperienceInformationById(Short id);

    ExperienceInformationDto updateExperienceInformationById(Short id, ExperienceInformationDto experienceInformationDto);

    boolean deleteExperienceInformationById (Short id);

    List<ExperienceInformationDto> getExpInfosByBasicInfoId(Short basicInfoId);

}
