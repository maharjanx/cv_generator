package com.infodev.cvgenerator.user.cv_generate;

import com.infodev.cvgenerator.generic.BaseController;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv")
public class CVGenerateController extends BaseController {


    private final CvGenerateService cvGenerateService;

    public CVGenerateController(CvGenerateService cvGenerateService) {
        this.cvGenerateService = cvGenerateService;
    }

    @GetMapping("/generate/{id}")
    public ResponseEntity<String> generate(@PathVariable Short id) {
        return ResponseEntity.ok(cvGenerateService.getAllInformation(id));
    }
}
