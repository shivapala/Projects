package com.flyaway.operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.Availablity;
import com.flyaway.DAO.services.AirwaySvc;
import com.flyaway.DAO.services.Impl.AirWaySvcImpl;

public class AirwayServices {
	
	AirwaySvc air=new AirWaySvcImpl();
	
	public List<AirFlights> getFlights(int srcId,int destId,LocalDate dat)
	{
	 List<AirFlights> eligibleFlights=new ArrayList<AirFlights>();
		
		List<AirFlights> flights=air.searchFlights(srcId, destId,dat);
		
		for(AirFlights flight:flights)
		{
		
			if(flight.getAvail()==null )
			{
				Availablity avl=new Availablity();
				avl.setAvl_cnt(flight.getOccupancy());
				avl.setAvl_date(dat);
				flight.setAvail(avl);
				eligibleFlights.add(flight);
			}else if(flight.getAvail().getAvl_cnt()>0)
			{
				eligibleFlights.add(flight);
			}
		}
		
		return eligibleFlights;
	}

}
