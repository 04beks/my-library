package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.mapper.BookDtoMapper;
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
    public Book createBook(@RequestBody @Valid BookDto bookDto) {
        Book book = bookDtoMapper.toBook(bookDto);
        Book createdBook = bookService.createBook(book);
        log.info("Book created: {}", createdBook);
        return createdBook;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody @Valid BookDto bookDto) {
        Book book = bookDtoMapper.toBook(bookDto);
        book.setId(id);
        Book updateBook = bookService.updateBook(id, book);
        log.info("Book updated: {}", updateBook);
        return updateBook;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/available")
    public List<Book> getAvailable() {
        return bookService.getAvailableBooks();
    }
}
