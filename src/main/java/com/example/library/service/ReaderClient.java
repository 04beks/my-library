package com.example.library.service;

import com.example.library.dto.RandomReaderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "reader-service",
        url = "https://randomuser.me"
)
public interface ReaderClient {
    @GetMapping("/api/")
    RandomReaderResponse getRandomReader();




}
