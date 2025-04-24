package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Long createdAt, updatedAt;
}
