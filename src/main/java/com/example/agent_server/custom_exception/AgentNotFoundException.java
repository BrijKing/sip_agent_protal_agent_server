package com.example.agent_server.custom_exception;

public class AgentNotFoundException extends Exception {

    public AgentNotFoundException(String message){
        super(message);
    }
    
}
