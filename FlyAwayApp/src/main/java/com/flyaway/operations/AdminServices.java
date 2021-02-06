package com.flyaway.operations;

import java.util.List;

import com.entity.flyaway.model.Locations;
import com.flyaway.DAO.services.AdminSvc;
import com.flyaway.DAO.services.Impl.AdminSvcImpl;

public class AdminServices {
	AdminSvc admin=new AdminSvcImpl();
	public List<Locations> getLocations() throws Exception
	{
		try {
			return admin.listLocations();
		} catch (Exception e) {
			System.out.println("Exception while fetching locations "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception ("Exception while fetching locations");
		}
	}

}
