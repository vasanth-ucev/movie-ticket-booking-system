package com.example.movieticketbookingsystem.dto;

import java.time.LocalDate;

public record UserUpdationResponse(String username,
                                   String phoneNumber
                                    , LocalDate dateOfBirth) {
}
