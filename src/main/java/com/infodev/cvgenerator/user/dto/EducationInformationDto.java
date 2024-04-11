package com.infodev.cvgenerator.user.dto;

import com.infodev.cvgenerator.user.ENUM.DegreeName;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EducationInformationDto {

    private short id;

    @NotBlank(message = "Institution name must not be empty")
    @Max(message = "Values must not exceed 200", value = 200)
    private String institutionName;

    @Max(message = "Values must not exceed 200", value = 200)
    @NotBlank(message = "Institution address must not be empty")
    private String institutionAddress;

    @NotBlank(message = "Institution contact must not be empty")
    @Max(message = "Values must not exceed 10", value = 10)
    private String institutionContact;

    @NotNull(message = "From date must not be null")
    private Date fromDate;

    private Date toDate;

    private boolean toPresent;

    @NotNull(message = "Degree name must not be null")
    private DegreeName degreeName;

    @NotBlank(message = "Education description must not be empty")
    @Max(message = "Values must not exceed 100", value = 100)
    private String educationDescription;

    @NotNull(message = "Basic information ID must not be null")
    private Short basicInformationId;
}
