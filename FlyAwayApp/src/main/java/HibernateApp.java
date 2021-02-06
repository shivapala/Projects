import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.Locations;
import com.entity.flyaway.model.Login;
import com.flyaway.DAO.DBConnection;
import com.flyaway.DAO.services.AdminSvc;
import com.flyaway.DAO.services.DBOperations;
import com.flyaway.DAO.services.Impl.AdminSvcImpl;
import com.flyaway.DAO.services.Impl.DBOperationsImp;
import com.flyaway.operations.AdminServices;
import com.flyaway.operations.AirwayServices;
import com.flyaway.operations.LoginServices;



public class HibernateApp {

	public static void main(String[] args) {
		System.out.println("Hello World");
		// TODO Auto-generated method stub
	//EntityManager entityManger=DBConnection.getEntityManager();
	System.out.println("After getting connection");
	String userName="cap1";
	String password="cap11";
	String role="Admin";
	Login login=new Login();
	login.setUserName(userName);
	login.setPassword(password);
	login.setRole(role);
LoginServices log=new LoginServices();
	//boolean k=log.validateUser(login);
	
	//if(k)
//	{	
	//AdminSvc admin= new AdminSvcImpl();
	AdminServices adc=new AdminServices();
	AirwayServices air=new AirwayServices();
	try {
		System.out.println("Geeting List");
		List<AirFlights> flights=air.getFlights(1, 2,LocalDate.now());
		for(AirFlights flight: flights)
		{
			System.out.println("Flight Details ....");
			System.out.println( "Flight Id : "+flight.getFlight_Id());
			System.out.println( "Flight NBr : "+flight.getFlightNbr());
			System.out.println( "Flight Typ : "+flight.getFlight_Typ());
			System.out.println( "Occupancy : "+flight.getOccupancy());
			System.out.println( "Price : "+flight.getPrice());
			System.out.println("Air Line Details : ");
			System.out.println("Air Line Name : "+flight.getAirLine().getAirLineName());
			System.out.println("Source  : "+flight.getSource().getLocName());
			System.out.println("Source AirPort Code  : "+flight.getSource().getCodeNM());
			System.out.println("Destination  : "+flight.getDest().getLocName());
			System.out.println("Destination AirPort Code  : "+flight.getDest().getCodeNM());
		}
		
		
		List<Locations> locations=adc.getLocations();
	
		for(Locations loc :locations)
		{
			System.out.println("Counry Name : "+loc.getLocName());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//}
	//else
	//	System.out.println("User Name/Password issue:  "+login.getUserName());

	}

}
