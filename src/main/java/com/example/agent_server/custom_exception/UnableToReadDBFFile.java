package com.example.agent_server.custom_exception;

public class UnableToReadDBFFile extends Exception {
    
    public UnableToReadDBFFile(String message){
        super(message);
    }
}
