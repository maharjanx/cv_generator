package com.infodev.cvgenerator.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.infodev.cvgenerator.user.ENUM.AddressType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressInformationRequestDto {
     private Short id;

    @NotNull(message = "Address type is required")
    private AddressType addressType;

    @NotNull(message = "Basic information ID is required")
    private Short basicInformationId;

    @NotNull(message = "Province ID is required")
    private Short provinceId;

    @NotNull(message = "Country ID is required")
    private Short countryId;

    @NotNull(message = "District ID is required")
    private Short districtId;

    @NotNull(message = "Locallevel ID is required")
    private Short locallevelId;

    private IdNameDto province;

    private IdNameDto country;

    private IdNameDto district;

    private IdNameDto localLevel;
}
