package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.BasicInformationEntityDtoConvertor;
import com.infodev.cvgenerator.user.dto.BasicInformationDto;
import com.infodev.cvgenerator.user.entity.BasicInformation;
import com.infodev.cvgenerator.user.entity.FileInformation;
import com.infodev.cvgenerator.user.repository.BasicInformationRepository;
import com.infodev.cvgenerator.user.service.BasicInformationService;
import com.infodev.cvgenerator.user.service.FileInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class BasicInformationServiceImpl implements BasicInformationService {
    private final BasicInformationRepository basicInformationRepository;
    @Autowired
    private FileInformationService fileInformationService;
    private final BasicInformationEntityDtoConvertor basicInformationEntityDtoConvertor;


    public BasicInformationServiceImpl(BasicInformationRepository basicInformationRepository, BasicInformationEntityDtoConvertor basicInformationEntityDtoConvertor) {
        this.basicInformationRepository = basicInformationRepository;
        this.basicInformationEntityDtoConvertor = basicInformationEntityDtoConvertor;
    }

    @Override
    public List<BasicInformationDto> getAllBasicInformation() {
        List<BasicInformation> entityList = basicInformationRepository.findAll();
        return basicInformationEntityDtoConvertor.toDto(entityList);
    }

    @Override
    public BasicInformationDto getBasicInformationById(Short id) {
        return basicInformationEntityDtoConvertor
                .toDto(basicInformationRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Basic Information not found with id: " + id)));
    }

    @Override
    public BasicInformationDto updateBasicInfromationById(Short id, BasicInformationDto basicInformationDto, MultipartFile multipartFile) {
       BasicInformation basicInformation = basicInformationRepository.findById(id)
                       .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Basic Information not found with id: " + id));

       if(multipartFile != null){
           try {
               FileInformation fileInformation = fileInformationService.saveFile(multipartFile);
               basicInformationDto.setFileInformation(fileInformation);
           }catch (IOException e){
               throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed to upload file: " + e.getMessage());
           }
       }
        BeanUtils.copyProperties(basicInformationDto, basicInformation);
        BasicInformation updatedBasicInformation = basicInformationRepository.save(basicInformation);
        return basicInformationEntityDtoConvertor.toDto(updatedBasicInformation);

    }

    //

    @Override
    public BasicInformationDto saveBasicInformation(BasicInformationDto basicInformationDto, MultipartFile file) throws IOException {
        BasicInformation basicInformation = basicInformationEntityDtoConvertor.toEntity(basicInformationDto);
        FileInformation fileInformation = fileInformationService.saveFile(file);
        basicInformation.setFileInformation(fileInformation);
        BasicInformation savedBasicInformation = basicInformationRepository.save(basicInformation);

        return basicInformationEntityDtoConvertor.toDto(savedBasicInformation);
    }


    @Override
    public boolean deleteBasicInformationById(Short id) {
        BasicInformation entity = basicInformationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Basic Information not found with id:" + id));
        basicInformationRepository.delete(entity);
        return true;
    }

}
