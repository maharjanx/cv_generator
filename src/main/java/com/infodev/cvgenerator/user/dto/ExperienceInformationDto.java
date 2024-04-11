package com.infodev.cvgenerator.user.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExperienceInformationDto {

    private Short id;

    private String companyName;
    private String companyAddress;
    private String companyContact;
    private Date fromDate;
    private Date toDate;
    private boolean toPresent;
    private Short basicInformationId;
}
