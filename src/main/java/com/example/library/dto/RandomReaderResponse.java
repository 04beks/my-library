package com.example.library.dto;

import lombok.Data;

import java.util.List;

@Data
public class RandomReaderResponse {
    private List<ReaderUser> results;

}
