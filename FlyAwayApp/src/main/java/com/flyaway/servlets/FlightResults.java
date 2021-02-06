package com.flyaway.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.flyaway.model.AirFlights;
import com.entity.flyaway.model.Locations;
import com.flyaway.operations.AdminServices;
import com.flyaway.operations.AirwayServices;

/**
 * Servlet implementation class Booking
 */
public class FlightResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AirwayServices air=new AirwayServices();
		HttpSession session=request.getSession();
		int src=Integer.parseInt(request.getParameter("srcLocation"));
		int tgt=Integer.parseInt(request.getParameter("DestLocation"));
		LocalDate dt=LocalDate.parse(request.getParameter("bookDate"));
		try
		{
			System.out.println("IN the Post do"+dt.toString()+" src : "+src+" tgt : "+tgt);
			List<AirFlights> flights=air.getFlights(src, tgt, dt);
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
			session.setAttribute("listFlights", flights);
			request.getRequestDispatcher("/pages/jsp/ResultsPage.jsp").forward(request, response);;
			
		}catch(Exception ex)
		{
			request.setAttribute("ErrorMsg", ex.getMessage());
			request.getRequestDispatcher("/pages/jsp/Error.jsp").forward(request, response);;

		}
	}

}
