package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.entity.BookLoan;
import com.example.library.exception.BookNotAvailableException;
import com.example.library.repository.BookLoanRepository;
import com.example.library.service.BookLoanService;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {


    private final BookLoanRepository bookLoanRepository;
    private final BookService bookService;

    @Override
    public BookLoan save(BookLoan bookLoan) {
        Book book = bookService.findBookById(bookLoan.getBook().getId());
        if(!book.getAvailable()){
            return null;
        }
        return bookLoanRepository.save(bookLoan);
    }

    @Override
    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepository.findById(id).orElseThrow(() -> new RuntimeException("BookLoan not found"));
    }
    @Override
    public List<BookLoan> getAllBookLoan() {
        return bookLoanRepository.findAll();

    }

    @Override
    public void deleteBookLoanById(Long id) {
        BookLoan bookLoan = getBookLoanById(id);
        bookLoanRepository.delete(bookLoan);
    }

}
