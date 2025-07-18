package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Object> findByTitle(String title);

    List<Book> findByAvailableTrue();
}
