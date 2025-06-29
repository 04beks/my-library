package com.example.library.service;

import com.example.library.dto.LibraryResponse;
import com.example.library.entity.BookLoan;

import java.util.List;


public interface BookLoanService {
    LibraryResponse save(BookLoan bookLoan);

    BookLoan getBookLoanById(Long id);

    List<BookLoan> getAllBookLoan();

    void deleteBookLoanById(Long id);
}
