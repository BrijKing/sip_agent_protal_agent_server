package com.example.agent_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agent_server.entity.InvestmentDetails;
import java.util.List;


public interface InvestmentDetailsRepository extends JpaRepository<InvestmentDetails, Long> {

    List<InvestmentDetails> findByAGENTCODE(String aGENTCODE);
    
}
