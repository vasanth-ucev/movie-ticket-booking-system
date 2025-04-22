package com.example.movieticketbookingsystem.Exception;

public class EmailAlreadyExistException extends RuntimeException{
    private String message;

    public EmailAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
