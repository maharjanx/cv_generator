package com.infodev.cvgenerator.user.dto;

import com.infodev.cvgenerator.user.ENUM.ProjectStatus;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectInformationDto {
    private Short id;
    private String projectName;
    private String projectRole;
    private String projectDescription;
    private String projectUrl;
    private ProjectStatus projectStatus;
    private Short experienceInformationId;
}
