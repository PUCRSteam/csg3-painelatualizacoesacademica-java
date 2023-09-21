package com.example.painelatualizacaoesacademicas.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NewsCreationException extends RuntimeException{
    private String message;
    public NewsCreationException(String message){
        super(message);
    }
}
