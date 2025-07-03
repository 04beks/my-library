package com.example.library.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ReaderDto {
    private Long id;
    private String fullName;
    private String email;
}
