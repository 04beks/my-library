package com.example.library.service.impl;

import com.example.library.entity.BookLoan;
import com.example.library.repository.BookLoanRepository;
import com.example.library.service.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {


    private final BookLoanRepository bookLoanRepository;

    @Override
    public BookLoan save(BookLoan bookLoan) {
        return bookLoanRepository.save(bookLoan);
    }

    @Override
    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepository.findById(id).orElseThrow(()-> new RuntimeException("BookLoan not found"));
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
