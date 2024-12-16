package com.example.agent_server.advicer;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.internal.objenesis.ObjenesisException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.agent_server.custom_exception.AgentNotFoundException;
import com.example.agent_server.custom_exception.UnableToReadDBFFile;

@RestControllerAdvice
public class ExceptionAdvicer {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<Object, Object>> GenericExcepion(Exception e){


        Map<Object, Object> response = new HashMap<>();

        response.put("error", e.getMessage());
        
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
    }

    @ExceptionHandler(UnableToReadDBFFile.class)
    public ResponseEntity<Map<Object, Object>> unableToReadDBFFile(UnableToReadDBFFile e){

        Map<Object, Object> res = new HashMap<>();

        res.put("error", e.getMessage());
        
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AgentNotFoundException.class)
    public ResponseEntity<Map<Object, Object>> AgentNotFound(AgentNotFoundException e){

        Map<Object, Object> res = new HashMap<>();

        res.put("error", e.getMessage());
        
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);



    }
    
}
