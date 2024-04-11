package com.infodev.cvgenerator.user.service.impl;

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

    private final AddressInformationRepository addressInformationRepository;
    private final AddressInformationEntityDtoConverter addressInformationEntityDtoConverter;
    public AddressInformationServiceImpl(AddressInformationRepository addressInformationRepository, AddressInformationEntityDtoConverter addressInformationEntityDtoConverter) {
        this.addressInformationRepository = addressInformationRepository;
        this.addressInformationEntityDtoConverter = addressInformationEntityDtoConverter;
    }

    @Override
    public AddressInformation saveAddressInformation(AddressInformationRequestDto addressInformationRequestDto) {
        AddressInformation entity = addressInformationEntityDtoConverter.toEntity(addressInformationRequestDto);
        return addressInformationRepository.save(entity);
    }

    @Override
    public List<AddressInformationRequestDto> getAllAddressInformation() {
        List<AddressInformation> entityList = addressInformationRepository.findAll();
        return addressInformationEntityDtoConverter.toDto(entityList);
    }


    @Override
    public AddressInformationRequestDto getAddressInformationById(Short id) {
        return addressInformationEntityDtoConverter.toDto(addressInformationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address Information not found with id: " + id)));
    }



    @Override
    public void deleteAddressInformationById(Short id) {

    }
}
