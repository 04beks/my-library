package com.example.library.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "book-service",
        url = "https://vigilant-youthfulness-production.up.railway.app"
)
public interface BookClient {
    @GetMapping(
            "/api/bexsex")
    String getBook();
}
