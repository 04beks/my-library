package com.example.library.controller;

import com.example.library.entity.FileE;
import com.example.library.service.FileEService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileEService fileEService;

    public FileController(FileEService fileEService) {
        this.fileEService = fileEService;
    }

    @ApiOperation(
            value = "Upload a file",
            notes = "Uploads a file and returns its metadata."
    )
    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FileE> uploadFileF(
            @ApiParam(value = "File to upload", required = true)
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        FileE fileE = fileEService.uploadFile(file);
        return ResponseEntity.ok(fileE);
}
}