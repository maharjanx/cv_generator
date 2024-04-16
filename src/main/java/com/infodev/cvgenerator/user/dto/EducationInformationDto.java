package com.infodev.cvgenerator.user.dto;

import com.infodev.cvgenerator.user.ENUM.DegreeName;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EducationInformationDto {


    @NotBlank(message = "Institution name must not be empty")
    @Size(message = "Values must not exceed 200", max = 200, min = 3)
    private String institutionName;

    @Size(message = "Maximum value for Institution address is 200  ", max = 200)
    @NotBlank(message = "Institution address must not be empty")
    private String institutionAddress;

    @NotBlank(message = "Institution contact must not be empty")
    @Size(message = "Values must not exceed 10", max = 10)
    private String institutionContact;

    @NotNull(message = "From date must not be null")
    private Date fromDate;

    private Date toDate;

    private boolean toPresent;

    @NotNull(message = "Degree name must not be null")
    private DegreeName degreeName;

    @NotBlank(message = "Education description must not be empty")
    @Size(message = "Values must not exceed 100", max = 100)
    private String educationDescription;

    @NotNull(message = "Basic information ID must not be null")
    private Short basicInformationId;
}
