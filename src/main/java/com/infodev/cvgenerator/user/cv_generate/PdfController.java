package com.infodev.cvgenerator.user.cv_generate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class PdfController {
    private final CvGenerateService cvGenerateService;
    private final Logger logger = LoggerFactory.getLogger(PdfController.class);

    public PdfController(CvGenerateService cvGenerateService) {
        this.cvGenerateService = cvGenerateService;
    }

    @GetMapping("/generate/{id}/{template}")
    public ResponseEntity<ByteArrayResource> generatePdf(@PathVariable Short id, @PathVariable("template") String template) throws IOException {
        String html = cvGenerateService.getAllInformation(id,template);

        logger.debug("Html content received from CvGenerateService:{}",html);
        //Generating Pdf from html
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
//        renderer.set
        renderer.createPDF(outputStream);

        //preparing response
        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=my_cv.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);


    }
}
