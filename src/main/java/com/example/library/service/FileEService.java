package com.example.library.service;

import com.example.library.entity.FileE;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface FileEService {
    FileE uploadFile(MultipartFile file) throws IOException;

    Optional<FileE> findFileById(Long id);

    void deleteFile(Long id) throws IOException;
}
