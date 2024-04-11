package com.infodev.cvgenerator.user.ENUM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProjectStatus {
    LIVE("LIVE"),
    UAT("UAT"),
    DEVELOPMENT("DEVELOPMENT");

    private final String key;
    ProjectStatus(String key){ this.key = key; }


    //TODO dropdown list api
    public static List<EnumDto> getProjectStatusList(){
        return Arrays.stream(ProjectStatus.values()).map(projectStatus -> new EnumDto(projectStatus.key)).collect(Collectors.toList());
    }
}
