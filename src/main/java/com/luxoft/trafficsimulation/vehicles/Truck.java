package com.luxoft.trafficsimulation.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.events.Incident;

@Component("Truck")
@Scope("prototype")
public class Truck extends Vehicle {

	public Truck(Integer ID, Double tankSize, Double consumptionPer5Sec) {
		super(ID, tankSize, consumptionPer5Sec);
	}
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void alert() {
		Alert alert = new Alert(this, this);
		applicationEventPublisher.publishEvent(alert);
	}

	public void incident() {
		Incident incident = new Incident(this, this);
		applicationEventPublisher.publishEvent(incident);
	}




	
	

}
