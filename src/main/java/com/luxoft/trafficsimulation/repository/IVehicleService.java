package com.luxoft.trafficsimulation.repository;

import java.util.List;

import com.luxoft.trafficsimulation.vehicles.Vehicle;

public interface IVehicleService {
	
	Vehicle findById(Long id);
	List<Vehicle> findAll();
	Integer deleteById(Integer id);
	Integer insert(Vehicle vehicle);
	Integer update(Vehicle vehicle);

}
