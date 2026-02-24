package com.jaga_kidney_backend.dto;

import com.jaga_kidney_backend.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest
{

  private String username;

  private String password;

  private Role role;

}