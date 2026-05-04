package com.jaga_kidney_backend.signup.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Integer userSeq;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mob_no")
    private String mobNo;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "address", columnDefinition = "LONGTEXT")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "status")
    private String status;
    
}