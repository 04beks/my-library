package com.example.library.service;

import com.example.library.dto.TextResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "translatorClient", url = "https://ftapi.pythonanywhere.com")
public interface TranslatorClient {

    @GetMapping("/translate")
    TextResponse translate(@RequestParam String sl, @RequestParam String dl, @RequestParam String text);
}
