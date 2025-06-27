package com.example.library.service;

import com.example.library.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookLoanService {
    BookLoan save(BookLoan bookLoan);

    BookLoan getBookLoanById(Long id);

    List<BookLoan> getAllBookLoan();

    void deleteBookLoanById(Long id);
}
