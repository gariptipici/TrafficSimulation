package com.luxoft.trafficsimulation.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.luxoft.trafficsimulation.constants.Constants.Status;

import org.springframework.jdbc.core.RowMapper;

import com.luxoft.trafficsimulation.vehicles.Vehicle;


public class VehicleRowMapper implements RowMapper<Vehicle> {
	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vehicle = new Vehicle(rs.getInt("id"), 
				rs.getDouble("tank_size"), 
				rs.getDouble("consumption_per_5_sec"), 
				Status.valueOf(rs.getString("status")));
		
		return vehicle;
	}

}
