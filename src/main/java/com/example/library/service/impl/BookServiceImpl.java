package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

   @Override
   public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book updateBook(Long id, Book book) {
        Book bookFound = findBookById(id);
        bookFound.setTitle(book.getTitle());
        bookFound.setAuthor(book.getAuthor());
        bookFound.setIsbn(book.getIsbn());
        return bookRepository.save(bookFound);
    }

    @Override
    public void deleteBook(Long id) {
        Book bookFound = findBookById(id);
        bookRepository.delete(bookFound);
    }

}
