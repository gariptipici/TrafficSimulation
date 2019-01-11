package com.luxoft.trafficsimulation.system;

import java.util.List;


import com.luxoft.trafficsimulation.service.VehicleService;
import com.luxoft.trafficsimulation.vehicles.Vehicle;

public class SimulationSystem {
	
	public static List<Vehicle> vehicles = new VehicleService().createVehicles(1000);
	

	
	public static void checkVehiclesAndRefuelIfNecessary() {
		vehicles.stream().filter(v -> v.getCurrentFuelQuantity() / v.getTankSize() < 0.1).forEach(v -> v.refuel());
	}

}
