package com.example.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="author")
public class Author {
    @Id
    private Long id;
    @Column(name="full_name_author")
    private String fullName;

}
