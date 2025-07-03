package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TextResponse {
    @JsonProperty("destination-text")
    private String destinationText;
}
