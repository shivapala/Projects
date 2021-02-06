package com.flyaway.DAO.services.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.AirLines;
import com.entity.flyaway.model.Locations;
import com.flyaway.DAO.DBConnection;
import com.flyaway.DAO.services.AdminSvc;

public class AdminSvcImpl implements AdminSvc {

	EntityManager entityManger=null;
	public AdminSvcImpl()
	{
		entityManger=DBConnection.getEntityManager();
	}
	@Override
	public List<AirLines> listAirlLines() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<AirFlights> listAirFlights() throws Exception {
		// TODO Auto-generated method stub
		
		TypedQuery<AirFlights> query=entityManger.createQuery("from AirFlights e",AirFlights.class);
		
		if(query.getResultList().size()>0)
		{
			return query.getResultList();
		}
		else
		{
			throw new Exception("No FlighList");
		}
	}
	@Override
	public List<Locations> listLocations() throws Exception {
		// TODO Auto-generated method stub
TypedQuery<Locations> query=entityManger.createQuery("from Locations e",Locations.class);
		
		if(query.getResultList().size()>0)
		{
			return query.getResultList();
		}
		else
		{
			throw new Exception("No Locations List");
		}
	}

}
