package com.infodev.cvgenerator.user.service;

import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.entity.AddressInformation;

import java.util.List;

public interface AddressInformationService {

    AddressInformation saveAddressInformation(AddressInformationRequestDto addressInformationRequestDto);

    List<AddressInformationRequestDto> getAllAddressInformation() ;

    AddressInformationRequestDto getAddressInformationById(Short id);

    void deleteAddressInformationById(Short id);
}
