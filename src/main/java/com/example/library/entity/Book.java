package com.example.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book")
/*
* **📕 Book**

•	id: Long

•	title: String — не пустое

•	author: String — не пустое

•	isbn: String — уникальное

•	available: Boolean — по умолчанию true*/
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "title")
    @NotBlank
    private String title;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    @Column(name = "isbn", unique = true)
    private String isbn;
    @Column(name = "book_availabe")
    private Boolean available = Boolean.TRUE;


}
