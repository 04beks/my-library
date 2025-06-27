package com.example.library.service;

import com.example.library.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author createAuthor(Author author);

    void deleteAuthor(Long id);
}
