package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.mapper.BookDtoMapper;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final BookDtoMapper bookDtoMapper;
    @PostMapping
    public BookDto createBook(@RequestBody @Valid BookDto bookDto) {
        Book book = bookDtoMapper.toBook(bookDto);
        Book createdBook = bookService.createBook(book);
        BookDto createdBookDto = bookDtoMapper.toBookDto(createdBook);
        log.info("Book created: {}", createdBookDto);
        return createdBookDto;
    }

    @GetMapping
    public List<Book> getAllBooks() {
       return bookService.findAllBooks();
    }
}
