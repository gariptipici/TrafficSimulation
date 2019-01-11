package com.luxoft.trafficsimulation.factory;

import static com.luxoft.trafficsimulation.constants.Constants.*;

import com.luxoft.trafficsimulation.vehicles.Bus;
import com.luxoft.trafficsimulation.vehicles.Car;
import com.luxoft.trafficsimulation.vehicles.Truck;
import com.luxoft.trafficsimulation.vehicles.Vehicle;

public class VehicleFactory {
	

	
	public static Vehicle getVehicle(Class<? extends Vehicle> clazz) {
		if(clazz.equals(Car.class)) {
			return new Car(CAR_TANKSIZE, CAR_CONSUMPTIONPER5SEC);
		} else if(clazz.equals(Bus.class)) {
			return new Bus(BUS_TANKSIZE, BUS_CONSUMPTIONPER5SEC);
		} else if(clazz.equals(Truck.class)) {
			return new Bus(TRUCK_TANKSIZE, TRUCK_CONSUMPTIONPER5SEC);
		} else {
			return null;
		}
		
	}

}
