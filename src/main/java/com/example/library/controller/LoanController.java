package com.example.library.controller;

import com.example.library.dto.LoanRequestDto;
import com.example.library.entity.BookLoan;
import com.example.library.mapper.LoanRequestDtoMapper;
import com.example.library.service.BookLoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
@Slf4j
public class LoanController {
    private final BookLoanService bookLoanService;
    private final LoanRequestDtoMapper loanRequestDtoMapper;


    @PostMapping
    public BookLoan create (@RequestBody @Valid LoanRequestDto loanRequestDto) {
        BookLoan bookLoan = loanRequestDtoMapper.toBookLoan(loanRequestDto);
        BookLoan bookLoanSaved = bookLoanService.save(bookLoan);
        log.info("Create BookLoan");
        return bookLoanSaved;
    }





}
