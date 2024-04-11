package com.infodev.cvgenerator.user.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DistrictDto {
    private Short id;
    private String name;
    private String nameNepali;
    private String code;
    private Short provinceId;

}
