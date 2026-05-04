package com.jaga_kidney_backend.signup.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String first_name;
    private String last_name;
    private String mob_no;
    private String role_code;
    private String address;
    private String gender;
    private String created_by;
    private String created_on;
    
    private String username;
    private String password;
    
}