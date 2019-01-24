package com.luxoft.trafficsimulation.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.system.SimulationSystem;
import com.luxoft.trafficsimulation.vehicles.*;
import static com.luxoft.trafficsimulation.constants.Constants.Status;


@Component
public class AlertListener implements ApplicationListener<Alert> {
	

	
	
    @Override
    public void onApplicationEvent(Alert alert) {
    	Vehicle vehicle = alert.getVehicle();
    	
    	if(vehicle instanceof Car && !Status.ALERT.equals(vehicle.getStatus())) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Car).forEach(
    				v -> {
    					v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03); 
    					v.setStatus(Status.ALERT);
    					}
    				);
    	}else if(vehicle instanceof Bus && !Status.ALERT.equals(vehicle.getStatus())) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Bus).forEach(
    				v -> {
    					v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03); 
    					v.setStatus(Status.ALERT);
    					}
    				);
    	}else if(vehicle instanceof Truck && !Status.ALERT.equals(vehicle.getStatus())) {
    		SimulationSystem.vehicles.stream().filter(c -> c instanceof Truck).forEach(
    				v -> {
    					v.setCurrentFuelQuantity(vehicle.getTankSize() * 0.03); 
    					v.setStatus(Status.ALERT);
    					}
    				);
    	} else {
    		
    	}
    	System.out.println("Alert sent: " + vehicle);
        
    }
}
