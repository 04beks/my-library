package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/*
* **🔗 BookLoan (таблица связи)**

•	id: Long

•	book: Book (OneToOne)

•	reader: Reader (ManyToOne)

•	loanDate: LocalDate

•	returnDate: LocalDate (nullable)*/
@Entity
@Data
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    private LocalDate loanDate;
    private LocalDate returnDate;

}
