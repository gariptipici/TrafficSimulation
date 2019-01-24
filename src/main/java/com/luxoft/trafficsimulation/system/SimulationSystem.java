package com.luxoft.trafficsimulation.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.luxoft.trafficsimulation.constants.Constants.Status;
import com.luxoft.trafficsimulation.factory.VehicleFactory;
import com.luxoft.trafficsimulation.vehicles.Bus;
import com.luxoft.trafficsimulation.vehicles.Car;
import com.luxoft.trafficsimulation.vehicles.Truck;
import com.luxoft.trafficsimulation.vehicles.Vehicle;
import static com.luxoft.trafficsimulation.constants.Constants.STEP_TIME;
import static com.luxoft.trafficsimulation.constants.Constants.VEHICLE_COUNT;
import static com.luxoft.trafficsimulation.constants.Constants.INCIDENT_PERCENTAGE;
import static com.luxoft.trafficsimulation.constants.Constants.ALERT_PERCENTAGE;

public class SimulationSystem {

	static int counter = 0;

	public static List<Vehicle> vehicles;

	static {
		System.out.println("--------------CREATION--------------------");
		vehicles = new ArrayList<>();
		for (Integer i = 0; i < VEHICLE_COUNT; i++) {
			if (i % 3 == 0) {
				vehicles.add(VehicleFactory.getVehicle(i, Car.class));
			} else if (i % 3 == 1) {
				vehicles.add(VehicleFactory.getVehicle(i, Bus.class));
			} else {
				vehicles.add(VehicleFactory.getVehicle(i, Truck.class));
			}
		}
		System.out.println("------------------------------------------");
	}

	public static Boolean getIncident() {
		Random rand = new Random();
		return (rand.nextInt(100) < INCIDENT_PERCENTAGE);
	}

	public static Boolean getAlert() {
		Random rand = new Random();
		return (rand.nextInt(100) < ALERT_PERCENTAGE);
	}

	public static void start() {
		while (true) {
			request();
			report();
			checkVehiclesAndRefuelIfNecessary();
			
			oneStep();
		}

	}
	
	public static Vehicle getRandomVehicle() 
    { 
        Random rand = new Random(); 
        return vehicles.get(rand.nextInt(vehicles.size())); 
    } 

	private static void report() {
		System.out.println("------------------------REPORT-------------------------------");
		vehicles.stream().forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");

	}

	private static void checkVehiclesAndRefuelIfNecessary() {
		vehicles.stream().filter(v -> v.getCurrentFuelQuantity() / v.getTankSize() < 0.1 && !Status.INCIDENT.equals(v.getStatus())).forEach(v -> 
				{
					v.refuel();
					if(Status.ALERT.equals(v.getStatus())) {
						repairVehicle(v);
					}
					
				}
		);
	}
	
	private static void repairVehicle(Vehicle vehicle) {
		System.out.println("Repairing Vehicle " + vehicle.getStatus().name());
		vehicle.setStatus(Status.OK);
	}

	private static void request() {
		vehicles.stream().forEach(Vehicle::response);
	}

	private static void oneStep() {
		counter++;
		System.out.println(counter + "th Step");
		try {
			Thread.sleep(STEP_TIME);
		} catch (InterruptedException e) {

		}
	}

}
