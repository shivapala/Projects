package com.flyaway.DAO.services;

import java.time.LocalDate;
import java.util.List;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.Availablity;
import com.entity.flyaway.model.BookingDtls;
import com.entity.flyaway.model.Passenger;

public interface AirwaySvc {
	
	public void insertPassengers(List<Passenger> paasenger);
	
	public BookingDtls insertBookingDtls(BookingDtls bookingDtl, Availablity avail);
	
	public List<AirFlights> searchFlights(int srcId,int DestId,LocalDate date) ;

	
	

}
