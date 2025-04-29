package com.example.movieticketbookingsystem.utility;

import lombok.*;

@Data
@Builder

public class ErrorStructure<T> {
    private int errorCode;
    private String message;
    private T error;
}
