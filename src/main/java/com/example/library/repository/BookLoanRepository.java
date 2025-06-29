package com.example.library.repository;

import com.example.library.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

    List<BookLoan> findAllByReturnDateIsNull();

}
