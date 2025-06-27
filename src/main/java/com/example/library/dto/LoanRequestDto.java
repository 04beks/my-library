package com.example.library.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class LoanRequestDto {

    private Long id;
    private Long bookID;
    private Long readerID;

    private LocalDate loanDate;
    private LocalDate returnDate;
}
