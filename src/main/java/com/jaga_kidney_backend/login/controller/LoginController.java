package com.jaga_kidney_backend.login.controller;

import com.jaga_kidney_backend.login.dto.LoginRequest;
import com.jaga_kidney_backend.login.dto.LoginResponse;
import com.jaga_kidney_backend.login.service.LoginService;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jagakidney/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Response<LoginResponse> login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}