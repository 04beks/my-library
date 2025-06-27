package com.example.library.service;

import com.example.library.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    Book findBookById(Long id);

    List<Book> findAllBooks();

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    List<Book> getAvailableBooks();
}
