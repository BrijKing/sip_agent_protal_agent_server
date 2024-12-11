package com.example.agent_server.advicer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvicer {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<Object, Object>> GenericExcepion(Exception e){


        Map<Object, Object> response = new HashMap<>();

        response.put("error", e.getMessage());
        
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
    }
    
}
