package com.example.movieticketbookingsystem.handler;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class CustomFieldError {
    String field;
    Object rejectedValue;
    String errorMessage;
}
