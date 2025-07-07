package com.example.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="files")
@Data
public class FileE {
    @Id
    private Long id;
    private String fileName;
    private String  filePath;
    private String fileType;
    private String fileSize;


    private LocalDateTime uploadDateTime;

}
