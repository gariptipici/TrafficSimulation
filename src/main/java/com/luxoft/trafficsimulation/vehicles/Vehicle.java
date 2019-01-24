package com.luxoft.trafficsimulation.vehicles;



import com.luxoft.trafficsimulation.events.Alert;
import com.luxoft.trafficsimulation.events.Incident;
import com.luxoft.trafficsimulation.system.SimulationSystem;
import com.luxoft.trafficsimulation.system.SpringContext;
import static com.luxoft.trafficsimulation.constants.Constants.Status;


public class Vehicle {
	

	
	private Integer ID;
	private Double tankSize;
	private Double consumptionPer5Sec;
	private Double currentFuelQuantity;
	private Status status;

	

	public Vehicle(Integer ID, Double tankSize, Double consumptionPer5Sec, Status status) {
		this.ID = ID;
		this.setConsumptionPer5Sec(consumptionPer5Sec);
		this.setTankSize(tankSize);
		this.setCurrentFuelQuantity(tankSize);
		this.setStatus(status);
	}
	
	public void response() {
		
		consume();
		if(SimulationSystem.getAlert() && !Status.INCIDENT.equals(this.getStatus()) && !Status.ALERT.equals(this.getStatus()))
			alert();
		if(SimulationSystem.getIncident() && !Status.INCIDENT.equals(this.getStatus()))
			incident();

	}

	public void alert() {
		Alert alert = new Alert(this, this);
		SpringContext.getEventPublisher().publish(alert);
	}

	public void incident() {
		Vehicle otherVehicle = SimulationSystem.getRandomVehicle();
		Incident incident = new Incident(this, otherVehicle);
		SpringContext.getEventPublisher().publish(incident);
	}

	public void refuel() {
		System.out.println("Refueling " + this);
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
	


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString(){
		return this.getClass().getSimpleName() + "Status: " + this.getStatus().name() + " Vehicle ID: " + ID + " Tank Size: " + tankSize + " Current Fuel Quantity: " +  currentFuelQuantity;
		
	}

}
