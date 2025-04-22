package com.example.movieticketbookingsystem.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Builder
public class ResponseStructure<T>{
    private int statusCode;
    private String message;
    private T data;
}
