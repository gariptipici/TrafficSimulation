package com.luxoft.trafficsimulation.events;

import org.springframework.context.ApplicationEvent;

import com.luxoft.trafficsimulation.vehicles.Vehicle;

public class Alert extends ApplicationEvent {

	private static final long serialVersionUID = 5266473808632973437L;
	
	private Vehicle vehicle;
 
    public Alert(Object source, Vehicle vehicle) {
        super(source);
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
