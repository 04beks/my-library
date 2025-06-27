package com.example.library.mapper;

import com.example.library.dto.BookDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDtoMapper {

    private final AuthorService authorService;


    public BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setIsbn(book.getIsbn());
        return bookDto;
    }

    public Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        if (bookDto.getAuthorId() != null) {
            Author author1 = authorService.findById(bookDto.getAuthorId());
            book.setAuthor(author1);
        }
        return book;
    }


}
