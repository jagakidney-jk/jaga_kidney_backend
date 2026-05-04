package com.jaga_kidney_backend.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaga_kidney_backend.login.entity.LoginEntity;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}