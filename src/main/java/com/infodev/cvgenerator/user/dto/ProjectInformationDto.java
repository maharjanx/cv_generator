package com.infodev.cvgenerator.user.dto;

import com.infodev.cvgenerator.user.ENUM.ProjectStatus;
import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectInformationDto {

    @NotNull(message = "Project Name must not be empty")
    @Size(message = "Project name must not exceed 100", max = 100)
    private String projectName;
    @NotNull(message = "Project Role must not be empty")
    @Size(message = "Project Role must not exceed more than 50", max = 50)
    private String projectRole;

    @NotNull(message = "Project Description must not be empty")
    private String projectDescription;

    @Size(message = "URL must not exceed 200", max = 200)
    private String projectUrl;

    @NotNull(message = "Project status must not be empty")
    private ProjectStatus projectStatus;

    @NotNull(message = "experience information id must not be empty")
    private Short experienceInformationId;
}
