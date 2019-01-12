package com.luxoft.trafficsimulation.vehicles;



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
		incident();
		alert();
	}



	protected abstract void incident();

	protected abstract void alert();

	public void refuel() {
		setCurrentFuelQuantity(getTankSize());

	}

	private void consume() {
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

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

}
