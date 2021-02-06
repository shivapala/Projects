package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.flyaway.model.Locations;
import com.flyaway.operations.AdminServices;

/**
 * Servlet implementation class LocationsSV
 */
public class LocationsSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationsSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		AdminServices adminSvc=new AdminServices();
		PrintWriter out=null;
		try
		{
			System.out.println("IN the Post do");
			List<Locations> locations=adminSvc.getLocations();
	out=response.getWriter();
	out.println("<table class=\"center\">");
	out.println("<tr>");
	out.println("<th>Id</th>");   
	out.println("<th>City</th> <th>Country</th>	<th>code</th>  <th>created</th>");
	out.println("</tr>");
	for(Locations location : locations)
	{
	  out.println("<tr>");
	  out.println("<td>"+location.getId()+"</td>");
	  out.println("<td>"+location.getLocName()+"</td>");
	  out.println("<td>"+location.getCountry()+"</td>");
	  out.println("<td>"+location.getCountry()+"</td>");
	  out.println("<td>"+location.getCreated()+"</td>");

	  out.println("</tr>");
		
	}
			//request.setAttribute("listLocation", locations);
			//request.getRequestDispatcher("/pages/jsp/AdminSuccess.jsp").forward(request, response);;
			
		}catch(Exception ex)
		{
			request.setAttribute("ErrorMsg", ex.getMessage());
			request.getRequestDispatcher("/pages/jsp/Error.jsp").forward(request, response);;

		}
	}

}
