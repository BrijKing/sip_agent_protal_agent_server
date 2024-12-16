package com.example.agent_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.agent_server.entity.InvestmentDetails;
import com.example.agent_server.models.InvestmentDetailsDTO;
import com.example.agent_server.service.DBFService;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/agent/dbf")
public class DBFController {

    @Autowired
    DBFService dbfService;

    @PostMapping("/read")
    public ResponseEntity<List<InvestmentDetailsDTO>> readDBFFile(@RequestParam("file") MultipartFile file) throws Exception {
        File tempFile = File.createTempFile("uploaded", ".dbf");
        file.transferTo(tempFile);

        List<InvestmentDetailsDTO> records = dbfService.readDBF(tempFile.getAbsolutePath());

        tempFile.delete();

        return ResponseEntity.ok(records);
    }
    
    
}
