package com.example.agent_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent_server.entity.Agent;
import com.example.agent_server.models.AgentDTO;
import com.example.agent_server.service.AgentService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    AgentService agentService;
    

    @PostMapping("/saveAgent")
    public ResponseEntity<Map<String, Object>> saveAgent(@RequestBody AgentDTO agentDTO) {


        AgentDTO saveAgent = agentService.saveAgent(Agent.builder()
        .agentCode(agentDTO.getAgentCode())
        .agentName(agentDTO.getAgentName())
        .email(agentDTO.getEmail())
        .build());
        
        
        Map<String, Object> response = new HashMap<>();

        response.put("Agent", saveAgent);
        response.put("message", "agent saved successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    
}
