package com.infodev.cvgenerator.user.cv_generate;

import com.infodev.cvgenerator.user.dto.*;
import com.infodev.cvgenerator.user.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CvGenerateServiceImpl implements CvGenerateService{

    private final BasicInformationService basicInformationService;
    private final AddressInformationService addressInformationService;
    private final EducationInformationService educationInformationService;
    private final ExperienceInformationService experienceInformationService;
    private final ProjectInformationService projectInformationService;

    @Autowired
    TemplateEngine templateEngine;

    public CvGenerateServiceImpl(BasicInformationService basicInformationService, AddressInformationService addressInformationService, EducationInformationService educationInformationService, ExperienceInformationService experienceInformationService, ProjectInformationService projectInformationService) {
        this.basicInformationService = basicInformationService;
        this.addressInformationService = addressInformationService;
        this.educationInformationService = educationInformationService;
        this.experienceInformationService = experienceInformationService;
        this.projectInformationService = projectInformationService;
    }

    @Override
    public String getAllInformation(Short id, String template) {

        BasicInformationDto basicInformationDto = basicInformationService.getBasicInformationById(id);
        List<EducationInformationDto> educationInformationDto = educationInformationService.getEduInfosByBasicInfoId(id);
        List<AddressInformationRequestDto> addressInformationRequestDtos = addressInformationService.getAddInfoByBasicInfoId(id);
        List<ExperienceInformationDto> experienceInformationDtos = experienceInformationService.getExpInfosByBasicInfoId(id);
        List<ProjectInformationDto> projectInformationDtos = projectInformationService.getProjectInfosByBasicInfoId(id);
        ExperienceInformationDto ex = new ExperienceInformationDto();


        Context context = new Context();
        context.setVariable("basicInformationDto", basicInformationDto);
        context.setVariable("experiences", experienceInformationDtos);
        context.setVariable("addresses", addressInformationRequestDtos);
        context.setVariable("educations", educationInformationDto);
        context.setVariable("projects", projectInformationDtos);

        if (Objects.equals(template, "sample1")) {
            return templateEngine.process("sample1", context);
        }else if (Objects.equals(template,"sample2")){
            return templateEngine.process("sample2", context);
        }else return "template not found";

    }
}
