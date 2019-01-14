package com.luxoft.trafficsimulation.vehicles;



import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.events.Incident;
import com.luxoft.trafficsimulation.system.SimulationSystem;
import com.luxoft.trafficsimulation.system.SpringContext;

public abstract class Vehicle {
	

	
	private Integer ID;
	private Double tankSize;
	private Double consumptionPer5Sec;
	private Double currentFuelQuantity;

	

	public Vehicle(Integer ID, Double tankSize, Double consumptionPer5Sec) {
		this.ID = ID;
		this.setConsumptionPer5Sec(consumptionPer5Sec);
		this.setTankSize(tankSize);
		this.setCurrentFuelQuantity(tankSize);
	}
	
	public void response() {
		
		consume();
		if(SimulationSystem.getAlert())
			alert();
		if(SimulationSystem.getIncident())
			incident();
		
		
		
	}



	
	
	public void alert() {
		Alert alert = new Alert(this, this);
		SpringContext.getEventPublisher().publish(alert);
	}

	public void incident() {
		Incident incident = new Incident(this, SimulationSystem.getRandomVehicle());
		SpringContext.getEventPublisher().publish(incident);
	}

	public void refuel() {
		setCurrentFuelQuantity(getTankSize());

	}

	private void consume() {
		Double fuel = getCurrentFuelQuantity();
		Double consume = getConsumptionPer5Sec();
		if(fuel > getConsumptionPer5Sec())
			setCurrentFuelQuantity(fuel - consume);
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

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + " Vehicle ID: " + ID + " Tank Size: " + tankSize + " Current Fuel Quantity: " +  currentFuelQuantity;
		
	}

}
