package com.luxoft.trafficsimulation.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


import com.luxoft.trafficsimulation.events.Incident;
import com.luxoft.trafficsimulation.vehicles.*;

@Component
public class IncidentListener implements ApplicationListener<Incident> {
    @Override
    public void onApplicationEvent(Incident incident) {
    	Vehicle vehicle = (Vehicle) incident.getSource();
    	Vehicle otherVehicle = incident.getVehicle();
    	vehicle.setCurrentFuelQuantity(0.0);
    	otherVehicle.setCurrentFuelQuantity(0.0);


        
    }
}
