package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "joke")
public class Joke {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String type;
    private String setup;
    private String punchline;
}

