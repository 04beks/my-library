package com.example.library.service.impl;

import com.example.library.dto.LibraryResponse;
import com.example.library.entity.Book;
import com.example.library.entity.BookLoan;
import com.example.library.repository.BookLoanRepository;
import com.example.library.service.BookLoanService;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {


    private final BookLoanRepository bookLoanRepository;
    private final BookService bookService;

    @Override
    public LibraryResponse save(BookLoan bookLoan) {

        Book book = bookService.findBookById(bookLoan.getBook().getId());
        LibraryResponse libraryResponse;
        if (book.getAvailable()) {
            book.setAvailable(false);
            bookService.updateBook(book.getId(), book);
            libraryResponse = LibraryResponse.builder()
                    .message("Successfully")
                    .status("200")
                    .content(bookLoanRepository.save(bookLoan)).build();
            return libraryResponse;
        } else {
            return LibraryResponse.builder()
                    .message("Book with id " + book.getId() + " is not available")
                    .status("410").build();
        }
    }

    @Override
    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepository.findById(id).orElseThrow(() -> new RuntimeException("BookLoan not found"));
    }

    @Override
    public List<BookLoan> getAllBookLoan() {
        return bookLoanRepository.findAllByReturnDateIsNull();

    }

    @Override
    public void deleteBookLoanById(Long id) {
        BookLoan bookLoan = getBookLoanById(id);
        bookLoanRepository.delete(bookLoan);
    }

    @Override
    public String returnBook(Long id, Long bookId) {
        BookLoan bookLoan = bookLoanRepository.findByReaderIdAndBookId(id, bookId);
        if (bookLoan != null) {
            bookLoan.setReturnDate(LocalDate.now());
            Book book = bookService.findBookById(bookLoan.getBook().getId());
            book.setAvailable(true);
            bookService.updateBook(book.getId(), book);
            bookLoanRepository.deleteById(bookLoan.getId());
            return "Successfully Returned";
        }
        return "BookLoan not found";
    }

}
