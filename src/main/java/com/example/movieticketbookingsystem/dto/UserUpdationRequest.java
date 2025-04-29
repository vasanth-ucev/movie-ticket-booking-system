package com.example.movieticketbookingsystem.dto;

import java.time.LocalDate;

public record UserUpdationRequest(String username,
                                  String phoneNumber,
                                  LocalDate dateOfBirth
  ) {

}
