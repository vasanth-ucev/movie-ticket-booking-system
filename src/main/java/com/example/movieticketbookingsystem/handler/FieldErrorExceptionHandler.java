package com.example.movieticketbookingsystem.handler;

import com.example.movieticketbookingsystem.utility.ErrorStructure;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import lombok.Builder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
         List<ObjectError> objectErrors=ex.getAllErrors();
         List<CustomFieldError> listCustomFieldErrors=new ArrayList<>();
         for(ObjectError objectError:objectErrors){
             FieldError fieldError=(FieldError)objectError;
             CustomFieldError customFieldError= CustomFieldError.builder()
                     .field(fieldError.getField())
                     .rejectedValue(fieldError.getRejectedValue())
                     .errorMessage(fieldError.getDefaultMessage())
                     .build();
             listCustomFieldErrors.add(customFieldError);
         }
        ErrorStructure<List<CustomFieldError>> errorResponse = ErrorStructure.<List<CustomFieldError>>builder()
                .message("can not be null")
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .error(listCustomFieldErrors)
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
