package com.infodev.cvgenerator.user.cv_generate;

import com.infodev.cvgenerator.user.dto.*;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvGenerateDto {
    private BasicInformationDto basicInformationDto;
    private AddressInformationRequestDto addressInformationRequestDto;
    private EducationInformationDto educationInformationDto;
    private ExperienceInformationDto experienceInformationDto;
    private ProjectInformationDto projectInformationDto;
}
