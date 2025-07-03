package com.example.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
/*
* **🧑‍🎓 Reader**

•	id: Long

•	fullName: String — не пустое

•	email: String — уникальное, валидный email*/

@Entity
@Data
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private Long id;

    @NotBlank
    @Column(name = "reader_name")
    private String fullName;

    @Email
    @Column(name = "reader_email")
    private String email;




}
