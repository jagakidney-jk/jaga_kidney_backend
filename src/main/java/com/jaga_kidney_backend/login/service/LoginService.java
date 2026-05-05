package com.jaga_kidney_backend.login.service;

import com.jaga_kidney_backend.login.dto.LoginRequest;
import com.jaga_kidney_backend.login.dto.LoginResponse;
import com.jaga_kidney_backend.login.entity.LoginEntity;
import com.jaga_kidney_backend.login.repository.LoginRepository;
import com.jaga_kidney_backend.security.Jwt;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {

    private final LoginRepository loginRepository;
    private final Jwt jwt;

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    public Response<LoginResponse> login(LoginRequest request) {

        LoginEntity user = loginRepository.findByUsername(request.getUsername()).orElse(null);
    
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            log.error("Invalid login attempt for user: {}", request.getUsername());
            return Response.error(401);
        }

        String token = jwt.generateToken(user.getUsername(), user.getAuthSeq(), user.getRoleCode());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        loginRepository.updateStatusNative(user.getUserSeq(), LocalDateTime.now().format(formatter));

        return Response.success(new LoginResponse(token));
    }
}