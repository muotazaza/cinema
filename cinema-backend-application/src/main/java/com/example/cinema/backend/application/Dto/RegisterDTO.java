package com.example.cinema.backend.application.Dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String Username;
    private String password;
    private String email;

    private Long roleId;
}
