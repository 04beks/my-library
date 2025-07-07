package com.example.library.controller;

import com.example.library.entity.FileE;
import com.example.library.service.FileEService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
@Slf4j
@CrossOrigin("*")
public class FileController {
    private final FileEService fileEService;


   /* @PostMapping
    public FileE uploadFileF(@RequestParam("file") MultipartFile file) throws IOException {
        return fileEService.uploadFile(file);
    }*/

    @PostMapping
    public ResponseEntity<FileE> uploadFileF(@RequestParam("file") MultipartFile file) throws IOException {
         FileE fileE = fileEService.uploadFile(file);
         return new ResponseEntity<>(fileE, HttpStatus.OK);
    }
}
