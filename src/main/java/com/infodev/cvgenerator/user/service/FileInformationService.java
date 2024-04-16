package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.FileInformation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileInformationService {

    public FileInformation saveFile(MultipartFile multipartFile) throws IOException;

}
