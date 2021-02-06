package com.flyaway.DAO.services;

import java.util.List;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.AirLines;
import com.entity.flyaway.model.Locations;

public interface AdminSvc {
	
	public List<AirLines> listAirlLines();
	public List<AirFlights> listAirFlights() throws Exception;
	public List<Locations> listLocations() throws Exception;
	
	
	
	

}
