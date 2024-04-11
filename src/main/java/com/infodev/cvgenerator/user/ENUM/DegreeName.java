package com.infodev.cvgenerator.user.ENUM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DegreeName {
    SCHOOL("SCHOOL"),
    PLUS_2("PLUS_2"),
    BACHELORS("BACHELORS"),
    PHD("PHD");
    private final String key;

    DegreeName(String key) {
        this.key = key;
    }

    public static List<EnumDto> getDegreeName() {
        return Arrays.stream(DegreeName.values()).map(degreeName -> new EnumDto(degreeName.key)).collect(Collectors.toList());
    }


    }


