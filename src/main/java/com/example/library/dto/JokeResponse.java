package com.example.library.dto;

import lombok.Data;

@Data
public class JokeResponse {
    private Long id;
    private String type;
    private String setup;
    private String punchline;
}

