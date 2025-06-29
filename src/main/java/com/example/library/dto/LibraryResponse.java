package com.example.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibraryResponse {
    String message;
    String status;
    Object content;
}
