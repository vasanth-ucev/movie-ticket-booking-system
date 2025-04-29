package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.Role;

import java.time.LocalDate;

public record UserRegistrationResponse(String username,
                                       String email,
                                       String phoneNumber,
                                       Role role,
                                       LocalDate DateOfBirth
                            ) {
}
