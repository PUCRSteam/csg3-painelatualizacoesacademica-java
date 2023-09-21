package com.example.painelatualizacaoesacademicas.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AcademicEventNotFoundException extends RuntimeException{
    private String message;
    public AcademicEventNotFoundException(String message){
        super(message);
    }
}