package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.configuration.CustomMessageSource;
import com.infodev.cvgenerator.user.abstracts.AddressInformationEntityDtoConverter;
import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.entity.AddressInformation;
import com.infodev.cvgenerator.user.repository.AddressInformationRepository;
import com.infodev.cvgenerator.user.service.AddressInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AddressInformationServiceImpl implements AddressInformationService {

    private final CustomMessageSource customMessageSource;
    private final AddressInformationRepository addressInformationRepository;
    private final AddressInformationEntityDtoConverter addressInformationEntityDtoConverter;

    public AddressInformationServiceImpl(CustomMessageSource customMessageSource, AddressInformationRepository addressInformationRepository, AddressInformationEntityDtoConverter addressInformationEntityDtoConverter) {
        this.customMessageSource = customMessageSource;
        this.addressInformationRepository = addressInformationRepository;
        this.addressInformationEntityDtoConverter = addressInformationEntityDtoConverter;
    }

    @Override
    public AddressInformationRequestDto saveAddressInformation(AddressInformationRequestDto addressInformationRequestDto) {
        AddressInformation entity = addressInformationEntityDtoConverter.toEntity(addressInformationRequestDto);
        addressInformationRepository.save(entity);
        return addressInformationEntityDtoConverter.toDto(entity);
    }

    @Override
    public List<AddressInformationRequestDto> getAllAddressInformation() {
        List<AddressInformation> entityList = addressInformationRepository.findAll();
        return addressInformationEntityDtoConverter.toDto(entityList);
    }


    @Override
    public AddressInformationRequestDto getAddressInformationById(Short id) {
        return addressInformationEntityDtoConverter.toDto(addressInformationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address Information not found with id: " + id)));
    }

    @Override
    public AddressInformationRequestDto updateAddressInformationById(AddressInformationRequestDto addressInformationRequestDto) {
        AddressInformation entity = addressInformationEntityDtoConverter.toEntity(addressInformationRequestDto);
        return addressInformationEntityDtoConverter.toDto(addressInformationRepository.save(entity));
    }


    @Override
    public boolean deleteAddressInformationById(Short id) {

        addressInformationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address Information not found with id: " + id));
        addressInformationRepository.deleteById(id);
        return true;


    }

    @Override
    public List<AddressInformationRequestDto> getAddInfoByBasicInfoId(Short basicInfoId) {
        return addressInformationEntityDtoConverter
                .toDto(addressInformationRepository
                        .findAddressInformationsByBasicInformationId(basicInfoId));
    }
}
