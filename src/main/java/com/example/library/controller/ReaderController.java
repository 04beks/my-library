package com.example.library.controller;

import com.example.library.dto.ReaderDto;
import com.example.library.entity.Reader;
import com.example.library.mapper.ReaderDtoMapper;
import com.example.library.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ReaderController {
    private final ReaderService readerService;
    private final ReaderDtoMapper readerDtoMapper;

    @PostMapping
    public Reader createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerDtoMapper.toReader(readerDto);
        return readerService.createReader(reader);
    }


    @GetMapping
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @PutMapping
    public Reader updateReader(@RequestBody ReaderDto readerDto, @PathVariable Long id) {
        Reader reader = readerDtoMapper.toReader(readerDto);
        reader.setId(id);
        return readerService.updateReader(id,reader);

    }

    @DeleteMapping("{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}
