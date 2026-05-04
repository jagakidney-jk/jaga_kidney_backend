package com.jaga_kidney_backend.signup.controller;

import com.jaga_kidney_backend.signup.dto.SignupResponse;
import com.jaga_kidney_backend.signup.service.SignupService;
import com.jaga_kidney_backend.signup.dto.SignupRequest;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jagakidney/auth")
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public Response<SignupResponse> login(@RequestBody SignupRequest request) {
        return signupService.signup(request);
    }
}