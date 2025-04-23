package com.example.movieticketbookingsystem.handler;

import com.example.movieticketbookingsystem.Exception.EmailAlreadyExistException;
import com.example.movieticketbookingsystem.utility.ErrorStructure;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.StructureResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler<T> {
    @Autowired
    private StructureResponseBuilder structureResponseBuilder;
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<T>> handleEmailAlreadyExistException(EmailAlreadyExistException ex){
        return structureResponseBuilder.error(HttpStatus.BAD_REQUEST,ex.getMessage(),null);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<T>> handleHttpMessageExeption(HttpMessageNotReadableException ex){
        return structureResponseBuilder.error(HttpStatus.BAD_REQUEST,"invalid user role",null);
    }
}
