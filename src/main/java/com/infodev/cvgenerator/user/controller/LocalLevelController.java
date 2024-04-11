package com.infodev.cvgenerator.user.controller;

import com.infodev.cvgenerator.user.dto.LocalLevelDto;
import com.infodev.cvgenerator.user.service.LocalLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/local-level")
public class LocalLevelController {
    private final LocalLevelService localLevelService;

    public LocalLevelController(LocalLevelService localLevelService) {
        this.localLevelService = localLevelService;
    }

    @GetMapping
    public ResponseEntity<List<LocalLevelDto>> find(){
        List<LocalLevelDto> localLevelDtos = localLevelService.getAllLocalLevels();
        return new ResponseEntity<>(localLevelDtos, HttpStatus.OK);
    }
}
