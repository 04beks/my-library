package com.example.library.controller;

import com.example.library.dto.ReaderDto;
import com.example.library.entity.Reader;
import com.example.library.mapper.ReaderDtoMapper;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
@Slf4j
public class ReaderController {
    private final ReaderService readerService;
    private final ReaderDtoMapper readerDtoMapper;

    @PostMapping
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerDtoMapper.toReader(readerDto);
        Reader result = readerService.createReader(reader);
        ReaderDto readerDto1 = readerDtoMapper.toReaderDto(result);
        log.info("Created reader : {}", readerDto1);
        return readerDto1;
    }
}
