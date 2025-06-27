package com.example.library.service;

import com.example.library.entity.Reader;

import java.util.List;

public interface ReaderService {
    Reader createReader(Reader reader);

    Reader getRearById(Long id);

    List<Reader> getAllReaders();

    Reader updateReader(Long id, Reader reader);

    void deleteReader(Long id);
}
