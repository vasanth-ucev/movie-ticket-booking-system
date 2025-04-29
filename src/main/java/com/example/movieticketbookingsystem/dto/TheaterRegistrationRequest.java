package com.example.movieticketbookingsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record TheaterRegistrationRequest(@NotNull
                                         String name,
                                         @NotNull
                                         String address,
                                         @NotNull
                                         String city,
                                         @NotNull
                                         String landmark) {
}
