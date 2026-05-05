package com.jaga_kidney_backend.signup.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaga_kidney_backend.login.entity.LoginEntity;
import com.jaga_kidney_backend.login.repository.LoginRepository;
import com.jaga_kidney_backend.security.Jwt;
import com.jaga_kidney_backend.signup.dto.SignupRequest;
import com.jaga_kidney_backend.signup.dto.SignupResponse;
import com.jaga_kidney_backend.signup.entity.SignupEntity;
import com.jaga_kidney_backend.signup.repository.SignupRepository;
import com.jaga_kidney_backend.util.Response;
import com.jaga_kidney_backend.util.StatusCodes;

@Service
@Transactional
public class SignupService {

    @Autowired
    SignupRepository signupRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    Jwt jwt;

    public Response<SignupResponse> signup(SignupRequest request) {

        String username = request.getUsername().trim().toLowerCase();

        if(loginRepository.existsByUsername(username)) {
            return Response.error(StatusCodes.USERNAME_EXISTS);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        SignupEntity signupEntity = new SignupEntity();
        signupEntity.setFirstName(request.getFirst_name());
        signupEntity.setLastName(request.getLast_name());
        signupEntity.setMobNo(request.getMob_no());
        signupEntity.setRoleCode(request.getRole_code());
        signupEntity.setAddress(request.getAddress());
        signupEntity.setCreatedBy(request.getCreated_by());
        signupEntity.setCreatedOn(LocalDateTime.now().format(formatter));
        signupEntity.setGender(request.getGender());
        signupEntity.setStatus("Active");

        signupEntity = signupRepository.save(signupEntity);

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername(request.getUsername().trim().toLowerCase());
        loginEntity.setPassword(request.getPassword());
        loginEntity.setUserSeq(signupEntity.getUserSeq());
        loginEntity.setRoleCode(request.getRole_code());

        loginEntity = loginRepository.save(loginEntity);

        String token = jwt.generateToken(loginEntity.getUsername(), loginEntity.getAuthSeq(), loginEntity.getRoleCode());

        return Response.success(new SignupResponse(token));

    }
    
}
