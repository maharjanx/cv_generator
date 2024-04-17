package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.FileInformation;
import com.infodev.cvgenerator.user.repository.FileInformationRepository;
import com.infodev.cvgenerator.user.service.BasicInformationService;
import com.infodev.cvgenerator.user.service.FileInformationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileInformationServiceImpl implements FileInformationService {
    private final FileInformationRepository fileInformationRepository;
    private BasicInformationService basicInformationService;
    private final String FOLDER_PATH = "/home/anish/Documents/office/java/CROSS-BORDER/cv-generator/src/main/resources/static/images/";

    public FileInformationServiceImpl(FileInformationRepository fileInformationRepository) {
        this.fileInformationRepository = fileInformationRepository;
    }


    @Override
    public FileInformation saveFile(MultipartFile multipartFile) throws IOException {

        String filePath = FOLDER_PATH + multipartFile.getOriginalFilename();
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(filePath);
        multipartFile.transferTo(file);
    return FileInformation.builder()
                .filePath(filePath)
                .name(fileName)
                .type(multipartFile.getContentType())
                .build();
    }

}
