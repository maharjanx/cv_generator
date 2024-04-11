package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.APIResponse;
import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.entity.AddressInformation;
import com.infodev.cvgenerator.user.service.AddressInformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address-information")
public class AddressInformationController {
    private final AddressInformationService addressInformationService;

    public AddressInformationController(AddressInformationService addressInformationService) {
        this.addressInformationService = addressInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@RequestBody @Valid AddressInformationRequestDto addressInformationRequestDto){
        AddressInformation entity = addressInformationService.saveAddressInformation(addressInformationRequestDto);
        return ResponseEntity.ok(APIResponse.builder().data(entity).message("Address Information Saved Successfully").success(true).build());
    }

    @GetMapping
    public ResponseEntity<List<AddressInformationRequestDto>> find(){
        List<AddressInformationRequestDto> addressInformationRequestDto = addressInformationService.getAllAddressInformation();
        return new ResponseEntity<>(addressInformationRequestDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressInformationRequestDto> findById(@PathVariable Short id){
        AddressInformationRequestDto addressInformationRequestDto = addressInformationService.getAddressInformationById(id);
        return new ResponseEntity<>(addressInformationRequestDto, HttpStatus.OK);

    }




}



