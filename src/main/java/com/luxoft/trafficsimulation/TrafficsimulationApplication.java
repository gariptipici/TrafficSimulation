package com.luxoft.trafficsimulation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luxoft.trafficsimulation.system.SimulationSystem;

@SpringBootApplication
public class TrafficsimulationApplication {
	
	@Autowired
	SimulationSystem simulationSystem;
	
	private static SimulationSystem ssimulationSystem;
	
	@PostConstruct
    public void init() {
        ssimulationSystem = simulationSystem;
    }

	public static void main(String[] args) {
		SpringApplication.run(TrafficsimulationApplication.class, args);
		
		ssimulationSystem.start();
	}

}

