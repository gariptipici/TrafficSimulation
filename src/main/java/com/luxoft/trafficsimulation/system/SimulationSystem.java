package com.luxoft.trafficsimulation.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.service.IVehicleService;
import com.luxoft.trafficsimulation.vehicles.Vehicle;
import static com.luxoft.trafficsimulation.constants.Constants.STEP_TIME;
import static com.luxoft.trafficsimulation.constants.Constants.VEHICLE_COUNT;

@Component
public class SimulationSystem {

	@Autowired
	IVehicleService vehicleService;
	
	public List<Vehicle> getVehicles() {
		return vehicleService.createVehicles(VEHICLE_COUNT);
	}
	public void start() {
		while(true) {
			request();
			checkVehiclesAndRefuelIfNecessary();
			oneStep();
		}
		
	}

	private void checkVehiclesAndRefuelIfNecessary() {
		getVehicles().stream().filter(v -> v.getCurrentFuelQuantity() / v.getTankSize() < 0.1).forEach(v -> v.refuel());
	}

	private void request() {
		getVehicles().stream().forEach(v -> v.response());
	}

	private void oneStep() {
		try {
			Thread.sleep(STEP_TIME);
		} catch (InterruptedException e) {

		}
	}

}
