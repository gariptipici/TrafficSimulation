package com.luxoft.trafficsimulation.repository;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luxoft.trafficsimulation.repository.rowmapper.VehicleRowMapper;
import com.luxoft.trafficsimulation.vehicles.Vehicle;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



@Repository
public class VehicleService implements IVehicleService{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Vehicle findById(Long id) {
		return jdbcTemplate.queryForObject("select * from vehicle where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
	}
	
	public List<Vehicle> findAll() {
		return jdbcTemplate.query("select * from vehicle", new VehicleRowMapper());
	}
	
	public Integer deleteById(Integer id) {
		return jdbcTemplate.update("delete from vehicle where id=?", new Object[] { id });
	}

	public Integer insert(Vehicle vehicle) {
		return jdbcTemplate.update("insert into vehicle (id, tank_size, consumption_per_5_sec, current_fuel_quantity, status) " + "values(?,  ?, ?)",
				new Object[] { vehicle.getID(), vehicle.getConsumptionPer5Sec(), vehicle.getCurrentFuelQuantity(), vehicle.getStatus().toString() });
	}

	public Integer update(Vehicle vehicle) {
		return jdbcTemplate.update("update vehicle " + " set consumption_per_5_sec = ?, current_fuel_quantity = ? , status = ? " + " where id = ?",
				new Object[] {vehicle.getConsumptionPer5Sec(), vehicle.getCurrentFuelQuantity(), vehicle.getStatus().toString(), vehicle.getID() });
	}

	
}
