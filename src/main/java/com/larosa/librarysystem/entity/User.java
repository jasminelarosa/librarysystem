package com.larosa.librarysystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String mobileNumber;

    private String userType;

    private Boolean confirmed = false;
}