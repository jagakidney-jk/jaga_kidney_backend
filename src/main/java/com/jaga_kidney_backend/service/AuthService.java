package com.jaga_kidney_backend.service;

import com.jaga_kidney_backend.dto.AuthResponse;
import com.jaga_kidney_backend.dto.LoginRequest;
import com.jaga_kidney_backend.dto.RegisterRequest;
import com.jaga_kidney_backend.entity.User;
import com.jaga_kidney_backend.repository.UserRepository;
import com.jaga_kidney_backend.security.JwtUtil;
import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{

  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository,
      JwtUtil jwtUtil,
      PasswordEncoder passwordEncoder)
  {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
    this.passwordEncoder = passwordEncoder;
  }

  // LOGIN
  public AuthResponse login(LoginRequest request)
  {

    User user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() ->
            new RuntimeException("User not found"));

    if (!passwordEncoder.matches(
        request.getPassword(),
        user.getPasswordHash()))
    {
      throw new RuntimeException("Invalid password");
    }

    String accessToken =
        jwtUtil.generateAccessToken(
            user.getUsername(),
            user.getRole().name());

    String refreshToken =
        jwtUtil.generateRefreshToken(user.getUsername());

    return AuthResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .username(user.getUsername())
        .role(user.getRole().name())
        .build();
  }

  // REGISTER (ADMIN ONLY)
  public AuthResponse register(RegisterRequest request)
  {

    if (userRepository.findByUsername(request.getUsername()).isPresent())
    {
      throw new RuntimeException("Username already exists");
    }

    User user = new User();

    user.setUsername(request.getUsername());

    user.setPasswordHash(
        passwordEncoder.encode(request.getPassword()));

    user.setRole(request.getRole());

    user.setStatus("ACTIVE");

    user.setCreatedAt(LocalDateTime.now());

    user.setUpdatedAt(LocalDateTime.now());

    userRepository.save(user);

    String accessToken =
        jwtUtil.generateAccessToken(
            user.getUsername(),
            user.getRole().name());

    String refreshToken =
        jwtUtil.generateRefreshToken(user.getUsername());

    return AuthResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .username(user.getUsername())
        .role(user.getRole().name())
        .build();
  }

  // LOGOUT (Stateless JWT)
  public void logout(String username)
  {
    // Stateless JWT logout
    // Actual invalidation requires token blacklist (Redis recommended)

    System.out.println("User logged out: " + username);
  }

  public String getUsernameFromToken(String token)
  {
    return jwtUtil.extractUsername(token);
  }
}