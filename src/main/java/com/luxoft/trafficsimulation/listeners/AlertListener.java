package com.luxoft.trafficsimulation.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.system.SimulationSystem;
import com.luxoft.trafficsimulation.vehicles.*;

@Component
public class AlertListener implements ApplicationListener<Alert> {
	

	
	
    @Override
    public void onApplicationEvent(Alert alert) {
    	Vehicle vehicle = alert.getVehicle();
    	
    	if(vehicle instanceof Car) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Car).forEach(v -> v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03));
    	}else if(vehicle instanceof Bus) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Bus).forEach(v -> v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03));
    	}else if(vehicle instanceof Truck) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Truck).forEach(v -> v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03));
    	} else {
    		
    	}
    	System.out.println("Alert sent: " + vehicle.toString());
        
    }
}
