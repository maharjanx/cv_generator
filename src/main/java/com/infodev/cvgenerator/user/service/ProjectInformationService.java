package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.ProjectInformation;

public interface ProjectInformationService {
    ProjectInformation saveProjectInformation(ProjectInformationDto projectInformationDto);
}
