package com.example.agent_server.service;

import java.util.List;

import com.example.agent_server.entity.Agent;
import com.example.agent_server.models.AgentDTO;

public interface AgentService {

    AgentDTO saveAgent(Agent agent);

    List<AgentDTO> getAllAgent();

    AgentDTO getAgentByEmail(String email);


    
}
