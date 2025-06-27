package com.example.library.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Long authorId;
    private String isbn;
    private Boolean available;

}
