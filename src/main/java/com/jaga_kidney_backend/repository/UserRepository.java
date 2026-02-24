package com.jaga_kidney_backend.repository;

import com.jaga_kidney_backend.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
  Optional<User> findByUsername(String username);
}
