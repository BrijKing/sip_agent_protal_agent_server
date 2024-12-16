package com.example.agent_server.serviceImpl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agent_server.custom_exception.AgentNotFoundException;
import com.example.agent_server.custom_exception.UnableToReadDBFFile;
import com.example.agent_server.entity.Agent;
import com.example.agent_server.entity.InvestmentDetails;
import com.example.agent_server.models.InvestmentDetailsDTO;
import com.example.agent_server.repository.AgentRepository;
import com.example.agent_server.repository.InvestmentDetailsRepository;
import com.example.agent_server.service.DBFService;
import com.linuxense.javadbf.DBFReader;


@Service
public class DBFServiceImpl implements DBFService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvestmentDetailsRepository investmentDetailsRepository;


    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<InvestmentDetailsDTO> readDBF(String filePath) throws UnableToReadDBFFile {
        List<Map<String, Object>> records = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            DBFReader reader = new DBFReader(fis);

            int filedCount = reader.getFieldCount();
            List<String> fieldNames = new ArrayList<>();
            List<InvestmentDetailsDTO> ListOfInvestmentDetailsDTO = new ArrayList<>();
            List<InvestmentDetails> ListOfInvestmentDetails = new ArrayList<>();


            for(int i = 0; i < filedCount; i++){
                fieldNames.add(reader.getField(i).getName());

            }

            Object[] rowObjects;
            while ((rowObjects = reader.nextRecord()) != null){
                Map<String, Object> record = new HashMap<>();

                for(int i = 0; i< rowObjects.length; i++){
                    record.put(fieldNames.get(i), rowObjects[i]);
                }

                records.add(record);

            }
            

            for (Map<String, Object> record : records){
               

                InvestmentDetailsDTO investmentDetailsDTO = modelMapper.map(record, InvestmentDetailsDTO.class);
                InvestmentDetails investmentDetails = modelMapper.map(investmentDetailsDTO, InvestmentDetails.class);

                ListOfInvestmentDetailsDTO.add(investmentDetailsDTO);
                ListOfInvestmentDetails.add(investmentDetails);
            }

            for(InvestmentDetails investmentDetails : ListOfInvestmentDetails){

                String agent_code = investmentDetails.getAGENTCODE();

                Agent agent = agentRepository.findByAgentCode(agent_code).orElseThrow(() -> new AgentNotFoundException("Agent not found with agent code : " + agent_code));

                List<InvestmentDetails> li = new ArrayList<>();

                li.add(investmentDetails);

                agent.setInvestments(li);

                agentRepository.save(agent);


            }
            return ListOfInvestmentDetailsDTO;
        } catch (Exception e) {
            throw new UnableToReadDBFFile(e.getMessage());
            
        }
    }
    
}
