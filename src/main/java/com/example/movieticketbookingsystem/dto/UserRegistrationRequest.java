package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull
        String username,
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        Role role,
        @NotNull
        String phoneNumber,
        @NotNull
        LocalDate dateOfBirth
) {
}
