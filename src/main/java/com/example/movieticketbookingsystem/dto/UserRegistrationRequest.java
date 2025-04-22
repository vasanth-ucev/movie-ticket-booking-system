package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.Role;

import java.time.LocalDate;

public record UserRegistrationRequest(
        String username,
        String email,
        String password,
        Role role,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
