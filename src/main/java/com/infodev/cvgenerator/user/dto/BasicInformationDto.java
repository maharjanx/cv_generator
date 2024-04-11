package com.infodev.cvgenerator.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicInformationDto {
    private Short id;

    @NotEmpty(message = "First Name Is Required")
    @Max(message = "First name letters should not exceed more than 100", value = 100)
    @Min(message = "Minimum Letters of First Name is 2", value = 2)
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Last Name Is Required")
    @Max(message = "Last name letters should not exceed more than 100", value = 100)
    @Min(message = "Minimum Letters of Last Name is 2", value = 2)
    private String lastName;

    @NotEmpty(message = "Background Is Required")
    private String background;

    @NotEmpty(message = "Title Is Required")
    @Max(message = "Title letters should not exceed more than 100", value = 100)
    @Min(message = "Minimum Letters of Title is 2", value = 2)
    private String title;

    @NotEmpty(message = "Mobile Number Is Required")
    @Max(message = "Mobile Numbers should not exceed more than 10", value = 10)
    @Min(message = "Minimum numbers is 10", value = 10)
    private String mobileNumber;

    @Email(message = "Invalid Email Address")
    @NotNull(message = "Email must not be null")
    @NotEmpty(message = "Email must not be empty")
    @Max(message = "email letters should not exceed more than 100", value = 100)
    private String email;

    @NotNull(message = "LinkedIn URL must not be null")
    @Max(message = "url letters should not exceed more than 100", value = 100)
    private String linkedInUrl;

    @NotEmpty(message = "Profile image must not be empty")
    @Pattern(regexp = "^https?://.+\\.(?:jpg|jpeg|png)$", message = "Invalid profile image URL format")
    private String profileImage;
}
