package com.example.library.service.impl;

import com.example.library.entity.FileE;
import com.example.library.repository.FileERepository;
import com.example.library.service.FileEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class FileEServiceImpl implements FileEService {
    private final String uploadDir = "uploads";
    private final FileERepository fileERepository;

    @Autowired
    public FileEServiceImpl(FileERepository fileERepository) {
        this.fileERepository = fileERepository;
        try{
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileE uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDir, fileName);
        Files.createDirectories(path.getParent());
        file.transferTo(path);

        FileE fileE = new FileE();
        fileE.setFileName(fileName);
        fileE.setFilePath(path.toString());
        fileE.setFileType(file.getContentType());
        fileE.setUploadDateTime(LocalDateTime.now());
        return fileERepository.save(fileE);

    }


    @Override
    public Optional<FileE> findFileById(Long id) {
        return fileERepository.findById(id);
    }


    @Override
    public void deleteFile(Long id) throws IOException {
        Optional<FileE> fileE = fileERepository.findById(id);
        if(fileE.isPresent()) {
            Path path = Paths.get(uploadDir, fileE.get().getFilePath());
            Files.delete(path);
            fileERepository.deleteById(id);
        }
    }




}
