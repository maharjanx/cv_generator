package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BasicInformationService {
    List<BasicInformationDto> getAllBasicInformation();

    BasicInformationDto saveBasicInformation(BasicInformationDto basicInformationDto, MultipartFile file) throws IOException;

    BasicInformationDto getBasicInformationById(Short id);

    BasicInformationDto updateBasicInfromationById(Short id, BasicInformationDto basicInformationDto, MultipartFile file);
    boolean deleteBasicInformationById(Short id);

}
