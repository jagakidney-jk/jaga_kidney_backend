package com.jaga_kidney_backend.login.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}