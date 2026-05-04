package com.jaga_kidney_backend.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupResponse {
    private String token;
}