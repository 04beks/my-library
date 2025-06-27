package com.example.library.controller;

import com.example.library.dto.LoanRequestDto;
import com.example.library.entity.BookLoan;
import com.example.library.mapper.LoanRequestDtoMapper;
import com.example.library.service.BookLoanService;
import com.example.library.service.impl.BookLoanServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
@Slf4j
public class LoanController {
    private final BookLoanService bookLoanService;
    private final LoanRequestDtoMapper loanRequestDtoMapper;


    @PostMapping
    public BookLoan create (@RequestBody BookLoan bookLoan) {
        log.info("Create BookLoan");
        return bookLoanService.save(bookLoan);
    }



}
