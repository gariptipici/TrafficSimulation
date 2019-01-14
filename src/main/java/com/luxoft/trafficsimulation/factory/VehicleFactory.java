package com.luxoft.trafficsimulation.factory;

import static com.luxoft.trafficsimulation.constants.Constants.*;

import com.luxoft.trafficsimulation.vehicles.Bus;
import com.luxoft.trafficsimulation.vehicles.Car;
import com.luxoft.trafficsimulation.vehicles.Truck;
import com.luxoft.trafficsimulation.vehicles.Vehicle;

public class VehicleFactory {
	

	
	public static Vehicle getVehicle(Integer ID, Class<? extends Vehicle> clazz) {
		if(clazz.equals(Car.class)) {
			Car car = new Car(ID, CAR_TANKSIZE, CAR_CONSUMPTIONPER5SEC);
			System.out.println("New Car created: " + car.toString());
			return car;
			
		} else if(clazz.equals(Bus.class)) {
			Bus bus = new Bus(ID, BUS_TANKSIZE, BUS_CONSUMPTIONPER5SEC);
			System.out.println("New Bus created: " + bus.toString());
			return bus;
		} else if(clazz.equals(Truck.class)) {
			Truck truck = new Truck(ID, TRUCK_TANKSIZE, TRUCK_CONSUMPTIONPER5SEC);
			System.out.println("New Truck created: " + truck.toString());
			return truck;
		} else {
			return null;
		}
		
	}

}
