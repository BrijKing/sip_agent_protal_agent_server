package com.example.agent_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agent_server.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

    Optional<Agent> findByEmail(String email);    
}
