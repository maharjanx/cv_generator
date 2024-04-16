package com.infodev.cvgenerator.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.infodev.cvgenerator.user.entity.ProjectInformation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExperienceInformationDto {

    @NotBlank(message = "Company Name Must not be empty")
    @Size(message = "Values must not exceed 200", max = 200)
    private String companyName;

    @NotBlank(message = "Company Address must not be empty")
    @Size(message = "Values must not exceed 200", max = 200)
    private String companyAddress;

    @NotBlank(message = "company Contact number must not be empty")
    @Size(message = "Values must not exceed 10", max = 10)
    private String companyContact;

    @NotNull(message = "from date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private boolean toPresent;

    @NotNull(message = "Basic Information must not be null")
    private Short basicInformationId;

    private List<ProjectInformationDto> projectInformations;

//    private String fDate;
//    private String tdate;
}
