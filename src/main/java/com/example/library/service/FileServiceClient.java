package com.example.library.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        name = "file-service",
        url = "http://localhost:8080/api/files/"
)
public interface FileServiceClient {
    @PostMapping("/upload")
    String save(@RequestParam("file") MultipartFile file);

    @GetMapping("/download/{filename:.+}")
    ResponseEntity<Resource> download(@PathVariable String filename);
}
