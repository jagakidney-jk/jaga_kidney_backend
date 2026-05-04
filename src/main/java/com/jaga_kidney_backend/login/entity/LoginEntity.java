package com.jaga_kidney_backend.login.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authentication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_seq")
    private Integer authSeq;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_seq")
    private Integer userSeq;

    @Column(name = "role_code")
    private String roleCode;
    
}