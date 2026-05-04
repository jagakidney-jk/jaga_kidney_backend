package com.jaga_kidney_backend.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaga_kidney_backend.signup.entity.SignupEntity;

@Repository
public interface SignupRepository extends JpaRepository<SignupEntity, Integer> {
    
}
