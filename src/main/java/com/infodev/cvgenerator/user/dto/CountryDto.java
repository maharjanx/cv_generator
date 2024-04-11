package com.infodev.cvgenerator.user.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Short id;
    private String name;
    private String code;
    private String countryAlias;
}
