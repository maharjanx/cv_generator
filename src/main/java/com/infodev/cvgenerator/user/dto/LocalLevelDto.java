package com.infodev.cvgenerator.user.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data

public class LocalLevelDto {
    private Short id;

    private String name;

    private String nameNepali;

    private int totalWardCount;

    private String code;
    private Short districtId;
}
