package com.infodev.cvgenerator.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.infodev.cvgenerator.user.entity.FileInformation;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicInformationDto {

    @NotEmpty(message = "First Name Is Required")
    @Size(message = "Minimum and maximum letters of firstname is 2 and 100 respectively", min = 2, max = 100)
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Last Name Is Required")
    @Size(message = "Minimum and maximum letters of Last Name is 2 and 100 respectively", min = 2, max = 100)
    private String lastName;

    @NotEmpty(message = "Background Is Required")
    private String background;

    @NotEmpty(message = "Title Is Required")
    @Size(message = "Minimum and maximum value for title is 2 and 100 respectively", min = 2, max = 100)
    private String title;

    @NotEmpty(message = "Mobile Number Is Required")
    @Size(message = "Minimum and maximum numbers mobileNumber is 10 and 10 respectively", min = 10, max = 10)
    private String mobileNumber;

    @Email(message = "Invalid Email Address")
    @NotNull(message = "Email must not be null")
    @NotEmpty(message = "Email must not be empty")
    @Size(message = "Maximum value of email 100 ", max = 100)
    private String email;

    @NotNull(message = "LinkedIn URL must not be null")
    @Size(message = "Maximum value of url is 200 ", max = 200)
    private String linkedInUrl;


    private FileInformation fileInformation;
}
