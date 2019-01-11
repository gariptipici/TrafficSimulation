package com.luxoft.trafficsimulation.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.events.Incident;

public abstract class Vehicle {

	private Double tankSize;
	private Double consumptionPer5Sec;
	private Double currentFuelQuantity;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Vehicle(Double tankSize, Double consumptionPer5Sec) {
		this.setConsumptionPer5Sec(consumptionPer5Sec);
		this.setTankSize(tankSize);
		this.setCurrentFuelQuantity(tankSize);
	}

	public void alert() {
		Alert alert = new Alert(this, this);
		applicationEventPublisher.publishEvent(alert);
	}

	public void incident() {
		Incident incident = new Incident(this, this);
		applicationEventPublisher.publishEvent(incident);
	}

	public void refuel() {
		setCurrentFuelQuantity(getTankSize());

	}

	public void consume() {
		setCurrentFuelQuantity(getCurrentFuelQuantity() - getConsumptionPer5Sec());
	}

	public Double getTankSize() {
		return tankSize;
	}

	public void setTankSize(Double tankSize) {
		this.tankSize = tankSize;
	}

	public Double getConsumptionPer5Sec() {
		return consumptionPer5Sec;
	}

	public void setConsumptionPer5Sec(Double consumptionPer5Sec) {
		this.consumptionPer5Sec = consumptionPer5Sec;
	}

	public Double getCurrentFuelQuantity() {
		return currentFuelQuantity;
	}

	public void setCurrentFuelQuantity(Double currentFuelQuantity) {
		this.currentFuelQuantity = currentFuelQuantity;
	}

}
