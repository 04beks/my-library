package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.service.BookClient;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BookClientService {
    private final BookClient bookClient;
    private final BookService bookService;

    public void bookClient() {
        String bookDto = bookClient.getBook();
        Book book = new Book();
        book.setTitle(bookDto);
        bookService.createBook(book);
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void scheduleBookName() {
        bookClient();
    }
}
