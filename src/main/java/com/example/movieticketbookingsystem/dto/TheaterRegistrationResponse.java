package com.example.movieticketbookingsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record TheaterRegistrationResponse(
                                          String name,
                                          String address,
                                          String city,
                                          String landmark,
                                          Long createAt,
                                          Long updateAt) {
}
