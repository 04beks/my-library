package com.example.library.mapper;

import com.example.library.dto.LoanRequestDto;
import com.example.library.entity.BookLoan;
import com.example.library.service.BookService;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@RequiredArgsConstructor
public class LoanRequestDtoMapper {
    private final BookService bookService;
    private final ReaderService readerService;

    public LoanRequestDto toLoanRequestDto( BookLoan bookLoan) {
        LoanRequestDto loanRequestDto1 = new LoanRequestDto();
        loanRequestDto1.setId(bookLoan.getId());
        loanRequestDto1.setBookID(bookLoan.getBook().getId());
        loanRequestDto1.setReaderID(bookLoan.getReader().getId());
        loanRequestDto1.setLoanDate(bookLoan.getLoanDate());
        loanRequestDto1.setReturnDate(bookLoan.getReturnDate());
        return loanRequestDto1;
    }


    public BookLoan toBookLoan( LoanRequestDto loanRequestDto) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setId(loanRequestDto.getId());
        bookLoan.setBook(bookService.findBookById(loanRequestDto.getBookID()));
        bookLoan.setReader(readerService.getRearById(loanRequestDto.getReaderID()));
        bookLoan.setLoanDate(loanRequestDto.getLoanDate());
        bookLoan.setReturnDate(loanRequestDto.getReturnDate());
        return bookLoan;
    }
}
