package com.luxoft.trafficsimulation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.factory.VehicleFactory;
import com.luxoft.trafficsimulation.vehicles.Bus;
import com.luxoft.trafficsimulation.vehicles.Car;
import com.luxoft.trafficsimulation.vehicles.Truck;
import com.luxoft.trafficsimulation.vehicles.Vehicle;

@Component
public class VehicleService implements IVehicleService{

	
	@Override
	public List<Vehicle> createVehicles(Integer n) {
		List<Vehicle> vehicles = new ArrayList<>();
		for(Integer i = 0; i < n; i++) {
			if(i % 3 == 0) {
				vehicles.add(VehicleFactory.getVehicle(i, Car.class));
			} else if(i % 3 == 1) {
				vehicles.add(VehicleFactory.getVehicle(i, Bus.class));
			} else {
				vehicles.add(VehicleFactory.getVehicle(i, Truck.class));
			}
		}
		return vehicles;
	}
	
}
