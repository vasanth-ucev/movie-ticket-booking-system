package com.example.movieticketbookingsystem.Exception;

public class TheaterNotExitsException extends  RuntimeException{
    private  String message;

    public TheaterNotExitsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
