package com.jaga_kidney_backend.controller;

import com.jaga_kidney_backend.dto.AuthResponse;
import com.jaga_kidney_backend.dto.LoginRequest;
import com.jaga_kidney_backend.dto.RegisterRequest;
import com.jaga_kidney_backend.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{

  private final AuthService authService;

  public AuthController(AuthService authService)
  {
    this.authService = authService;
  }

  // LOGIN
  @PostMapping("/login")
  public AuthResponse login(
      @RequestBody LoginRequest request)
  {
    return authService.login(request);
  }

  // REGISTER (ADMIN ONLY)
//  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/register")
  public AuthResponse register(
      @RequestBody RegisterRequest request)
  {
    return authService.register(request);
  }

  // LOGOUT
  @PostMapping("/logout")
  public String logout(
      @RequestHeader("Authorization") String token)
  {

    String jwt = token.substring(7);

    String username =
        authService.getUsernameFromToken(jwt);

    authService.logout(username);

    return "Logged out successfully";
  }

}