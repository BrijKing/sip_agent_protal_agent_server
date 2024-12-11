package com.example.agent_server.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgentDTO {

    @NotBlank(message = "Agnet code is required")
    private String agentCode;

    @NotBlank(message = "Agent name is required")
    private String agentName;

    @Email(message = "Email formate is not valid")
    @NotBlank(message = "Agent email is required")
    private String email;
    
}
