package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull
        String username,
        @NotNull
        @Email(message = "Email should be validate")
        String email,
        @NotNull
        String password,
        @NotNull(message = "user role is required")
        Role role,
        @NotNull
        @Pattern(regexp = "^[6-9]\\d{10}$", message = "Phone number must be exactly 10 digits and start with 6-9")
        String phoneNumber,
        @NotNull
        LocalDate dateOfBirth
) {
}
