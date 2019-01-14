package com.luxoft.trafficsimulation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luxoft.trafficsimulation.system.SimulationSystem;

@SpringBootApplication
public class TrafficsimulationApplication {
	

	
	


	public static void main(String[] args) {
		SpringApplication.run(TrafficsimulationApplication.class, args);
		
		SimulationSystem.start();
	}

}

