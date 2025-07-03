package com.example.library.dto;

import lombok.Data;

@Data
public class ReaderUser {
    private Name name;
    private String email;
    private String phone;
    private Login login;
    private Location location;
    private Picture picture;
}
