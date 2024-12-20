package com.example.agent_server.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agent_code", unique = true, nullable = false)
    @NotBlank(message = "Agnet code is required")
    private String agentCode;

    @Column(name = "agent_name")
    @NotBlank(message = "Agent name is required")
    private String agentName;

    @Column(name = "agent_email" , unique = true, nullable = false)
    @Email(message = "Email formate is not valid")
    @NotBlank(message = "Agent email is required")
    private String email;

    @Builder.Default
    @OneToMany(targetEntity = InvestmentDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_fk", referencedColumnName ="agent_code" )
    private List<InvestmentDetails> investments = new ArrayList<>();
    
}
