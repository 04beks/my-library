package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.mapper.BookDtoMapper;
import com.example.library.service.BookService;
import com.example.library.service.FileServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
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

    @Operation(summary = "скачать книгу", tags = "file-service")
    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> getBook(@PathVariable String filename) {
        ResponseEntity<Resource> resource = bookService.getBook(filename);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(resource.getHeaders().getContentType());
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(filename)
                .build());

        return new ResponseEntity<>(resource.getBody(), headers, HttpStatus.OK);
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
