package com.example.agent_server.serviceImpl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent_server.entity.Agent;
import com.example.agent_server.models.AgentDTO;
import com.example.agent_server.repository.AgentRepository;
import com.example.agent_server.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public AgentDTO saveAgent(Agent agent) {
        
        Agent savedAgent = agentRepository.save(agent);

        return AgentDTO.builder()
        .agentCode(savedAgent.getAgentCode())
        .agentName(savedAgent.getAgentName())
        .email(savedAgent.getEmail())
        .build();
    }

    @Override
    public List<AgentDTO> getAllAgent() {
        
        List<Agent> agents = agentRepository.findAll();

        return agents.stream().map(agent -> 
                                    AgentDTO.builder()
                                    .agentCode(agent.getAgentCode())
                                    .agentName(agent.getAgentName())
                                    .email(agent.getEmail())
                                    .build())
                                    .toList();   
    }

    @Override
    public AgentDTO getAgentByEmail(String email) {
        
        Agent agent = agentRepository.findByEmail(email).get();

        return AgentDTO.builder()
        .agentCode(agent.getAgentCode())
        .agentName(agent.getAgentName())
        .email(agent.getEmail())
        .build();






        
    }
    
}
