package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.generic.BaseController;
import com.infodev.cvgenerator.user.ENUM.AddressType;
import com.infodev.cvgenerator.user.ENUM.DegreeName;
import com.infodev.cvgenerator.user.ENUM.ProjectStatus;
import com.infodev.cvgenerator.user.dto.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get-enum")
public class EnumController extends BaseController {
    @GetMapping("/address-type")
    public ResponseEntity<APIResponse> getAddressTypeList(){
        return ResponseEntity.ok(APIResponse.builder().data(AddressType.getAddressTypeList()).message("Enum AddressType List Fetch Successfully").success(true).build());
    }

    @GetMapping("/degree-name")
    public ResponseEntity<APIResponse> getDegreeNameList(){
        return  ResponseEntity.ok(APIResponse.builder().data(DegreeName.getDegreeName()).message("Enum Degree List fetch successfully").success(true).build());
    }

    @GetMapping("/project-status")
    public ResponseEntity<APIResponse> getProjectStatusList(){
        return ResponseEntity.ok(APIResponse.builder().data(ProjectStatus.getProjectStatusList()).message("Enum Project List fetch successfully").success(true).build());
    }

}
