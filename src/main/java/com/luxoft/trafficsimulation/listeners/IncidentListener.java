package com.luxoft.trafficsimulation.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.events.Incident;
import com.luxoft.trafficsimulation.vehicles.*;
import static com.luxoft.trafficsimulation.constants.Constants.Status;


@Component
public class IncidentListener implements ApplicationListener<Incident> {
    @Override
    public void onApplicationEvent(Incident incident) {
    	
    	Vehicle vehicle = (Vehicle) incident.getSource();
    	Vehicle otherVehicle = incident.getVehicle();
    	if(!Status.INCIDENT.equals(vehicle.getStatus())) {
    		vehicle.setStatus(Status.INCIDENT);
    		vehicle.setCurrentFuelQuantity(0.0);
    		otherVehicle.setCurrentFuelQuantity(0.0);
        	otherVehicle.setStatus(Status.INCIDENT);
        	System.out.println("Incident sent: v1 - " + vehicle);
        	System.out.println("Incident sent: v2 - " + otherVehicle);
    	}

    	
    	
    	
    	
    	

        
    }
}
