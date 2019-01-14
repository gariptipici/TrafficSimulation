package com.luxoft.trafficsimulation.vehicles;
import static com.luxoft.trafficsimulation.constants.Constants.Status;


public class Truck extends Vehicle {

	public Truck(Integer ID, Double tankSize, Double consumptionPer5Sec, Status status) {
		super(ID, tankSize, consumptionPer5Sec, status);
	}

}
