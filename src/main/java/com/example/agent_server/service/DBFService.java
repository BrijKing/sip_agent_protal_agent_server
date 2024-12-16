package com.example.agent_server.service;

import java.util.List;
import java.util.Map;

import com.example.agent_server.custom_exception.UnableToReadDBFFile;
import com.example.agent_server.entity.InvestmentDetails;
import com.example.agent_server.models.InvestmentDetailsDTO;

public interface DBFService {
    
    public List<InvestmentDetailsDTO> readDBF(String filePath) throws UnableToReadDBFFile;
}
