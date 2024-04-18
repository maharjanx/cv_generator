package com.infodev.cvgenerator.user.cv_generate;

import com.infodev.cvgenerator.generic.BaseController;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/generate/{id}/{template}")
    public ResponseEntity<String> generate(@PathVariable("id") Short id, @PathVariable("template") String template) {

        try {
            return ResponseEntity.ok(cvGenerateService.getAllInformation(id, template));
        }catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Not found");
        }
    }

}
