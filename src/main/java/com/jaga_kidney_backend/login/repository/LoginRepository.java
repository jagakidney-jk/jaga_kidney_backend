package com.jaga_kidney_backend.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaga_kidney_backend.login.entity.LoginEntity;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findByUsername(String username);
    boolean existsByUsername(String username);

    @Modifying
    @Query(value = "UPDATE authentication SET last_login = ?2 WHERE user_seq = ?1", nativeQuery = true)
    int updateStatusNative(Integer user_seq, String lastLogin);
}