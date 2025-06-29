package com.example.library.controller;

import com.example.library.dto.LibraryResponse;
import com.example.library.dto.LoanRequestDto;
import com.example.library.entity.BookLoan;
import com.example.library.mapper.LoanRequestDtoMapper;
import com.example.library.service.BookLoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
@Slf4j
@CrossOrigin("*")
public class LoanController {
    private final BookLoanService bookLoanService;
    private final LoanRequestDtoMapper loanRequestDtoMapper;


    @GetMapping
    public List<BookLoan> getLoans() {
        return bookLoanService.getAllBookLoan();
    }

    @PostMapping
    public LibraryResponse create(@RequestBody @Valid LoanRequestDto loanRequestDto) {
        BookLoan bookLoan = loanRequestDtoMapper.toBookLoan(loanRequestDto);
        return bookLoanService.save(bookLoan);
    }

    @PutMapping
    public LibraryResponse update(@RequestBody @Valid LoanRequestDto loanRequestDto) {
        BookLoan bookLoan = loanRequestDtoMapper.toBookLoan(loanRequestDto);
        return bookLoanService.save(bookLoan);
    }


    @PostMapping("/return")
    public String returnBook(@RequestParam Long readerId, @RequestParam Long bookId) {

        return bookLoanService.returnBook(readerId, bookId);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookLoanService.deleteBookLoanById(id);
    }


}
