package com.example.movieticketbookingsystem.Exception;

public class EmailNotExistException extends RuntimeException{
    private String message;

    public EmailNotExistException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
