package com.example.movieticketbookingsystem.dto;

import jakarta.validation.constraints.NotNull;

public record TheaterUpdateRequest(

        String name,
        String address,
        String city,
        String landmark
) {
}
