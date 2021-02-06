package com.flyaway.DAO.services.Impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.Availablity;
import com.entity.flyaway.model.BookingDtls;
import com.entity.flyaway.model.Passenger;
import com.flyaway.DAO.DBConnection;
import com.flyaway.DAO.services.AirwaySvc;

import javassist.bytecode.stackmap.TypeData;

public class AirWaySvcImpl implements AirwaySvc {

	EntityManager entityManger=null;
	StringBuilder str=new StringBuilder();
	public AirWaySvcImpl()
	{
		entityManger=DBConnection.getEntityManager();
	}
	@Override
	public void insertPassengers(List<Passenger> paasenger) {
		// TODO Auto-generated method stub

	}

	@Override
	
	public BookingDtls insertBookingDtls(BookingDtls bookingDtl,Availablity avail) {
		entityManger.getTransaction().begin();
		entityManger.persist(bookingDtl);
		entityManger.merge(avail);
		// TODO Auto-generated method stub
		entityManger.getTransaction().commit();
		System.out.println("Added the data sucessfully"+bookingDtl.getClass().getName());
return bookingDtl;

	}

	@Override
	public List<AirFlights> searchFlights(int srcId, int TgtId,LocalDate avlDate)  {
		// TODO Auto-generated method stub
		str.append("SELECT c FROM AirFlights c ")
		.append(" LEFT OUTER JOIN Availablity avail")
		.append(" ON avail.Flight_id=c.flight_Id")
		.append( " AND avail.avl_date=:AvlDate")
		.append(" WHERE c.srcId=:SrcId AND c.destId=:DestId");
		List<AirFlights> airFlights=null;
		TypedQuery<AirFlights> query=entityManger.createQuery( str.toString(), AirFlights.class);
		query.setParameter("SrcId", srcId);
		query.setParameter("DestId", TgtId);
		query.setParameter("AvlDate", avlDate);
		airFlights=query.getResultList();
		
		
		return airFlights;
			
		
	}

}
