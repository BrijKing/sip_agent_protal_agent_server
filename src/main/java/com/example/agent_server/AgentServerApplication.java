package com.example.agent_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AgentServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentServerApplication.class, args);
	}

	@GetMapping("/agent")
	public String hello(){
		return "Hello from agent service";
	}

}
