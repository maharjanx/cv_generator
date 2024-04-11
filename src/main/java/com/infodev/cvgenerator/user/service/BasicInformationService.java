package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;

import java.util.List;

public interface BasicInformationService {
    List<BasicInformationDto> getAllBasicInformation();
    BasicInformation getBasicInformationById(Short id);

    BasicInformationDto saveBasicInformation(BasicInformationDto basicInformationDto);
    void deleteBasicInformationById(Short id);

}
