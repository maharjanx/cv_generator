package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.ExperienceInformationDto;
import com.infodev.cvgenerator.user.dto.ProjectInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.entity.ProjectInformation;

import java.util.List;

public interface ProjectInformationService {
    ProjectInformationDto saveProjectInformation(ProjectInformationDto projectInformationDto);
    List<ProjectInformationDto> getAllProjectInformation ();
    ProjectInformationDto getProjectInformationById(Short id);

    ProjectInformationDto updateProjectInformationById(Short id, ProjectInformationDto projectInformationDto);

    boolean deleteProjectInformationById (Short id);
    List<ProjectInformationDto> getProjectInfoByExpInfoId(Short expInfoId);
    List<ProjectInformationDto> getProjectInfosByBasicInfoId(Short basicInfoid);





}
