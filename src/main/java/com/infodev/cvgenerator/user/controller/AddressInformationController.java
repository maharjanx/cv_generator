package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
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
public class AddressInformationController extends BaseController {
    private final AddressInformationService addressInformationService;

    public AddressInformationController(AddressInformationService addressInformationService) {
        this.addressInformationService = addressInformationService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@RequestBody @Valid AddressInformationRequestDto addressInformationRequestDto) {


       return  ResponseEntity.ok(getApiResponse(addressInformationService.saveAddressInformation(addressInformationRequestDto), "Address Information saved successfully", true));
    }

    @GetMapping
    public ResponseEntity<APIResponse> find() {

        List<AddressInformationRequestDto> dtoList = addressInformationService.getAllAddressInformation();
       return ResponseEntity.ok(getApiResponse(dtoList, "List of Address information fetched successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressInformationRequestDto> findById(@PathVariable Short id) {
        AddressInformationRequestDto addressInformationRequestDto = addressInformationService.getAddressInformationById(id);
        return new ResponseEntity<>(addressInformationRequestDto, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<APIResponse>
    update( @Valid @RequestBody  AddressInformationRequestDto addressInformationRequestDto) {
        AddressInformationRequestDto dto = addressInformationService.updateAddressInformationById(addressInformationRequestDto);
        return ResponseEntity.ok(APIResponse.builder().data(dto).message("Address Information Updated!!").success(true).build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<APIResponse> delete(@PathVariable Short id){

        return ResponseEntity.ok(getApiResponse(addressInformationService.deleteAddressInformationById(id), "Address Information deleted !!!", true));
    }

    @GetMapping("/by-basic-info-id/{bashiInfoId}")
    public ResponseEntity<APIResponse> getByBasicInfoId(@PathVariable("bashiInfoId") Short bashiInfoId){
        return ResponseEntity.ok(getApiResponse(addressInformationService.getAddInfoByBasicInfoId(bashiInfoId),"fetched Successfully", true));
    }

}



