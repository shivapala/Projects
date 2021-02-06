package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.flyaway.model.Login;
import com.flyaway.operations.LoginServices;

/**
 * Servlet implementation class Login
 */
public class LoginSvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSvc() {
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
		HttpSession sesssion=request.getSession();
		//request.getH
		String userName=request.getParameter("UserName");
		String password=request.getParameter("Password");
		//String role=request.getParameter("Role");
		Login login=new Login();
		login.setUserName(userName);
		login.setPassword(password);
		//login.setRole(role);
		RequestDispatcher rd=null;
		LoginServices log=new LoginServices();
	 login=log.validateUser(login);
		if( login!=null && login.getRole().equalsIgnoreCase("Admin"))
		{
		rd=request.getRequestDispatcher("/pages/jsp/AdminSuccess.jsp");
		rd.forward(request, response);
		}else if(login!=null && ! login.getRole().equalsIgnoreCase("Admin"))
		{
			
		}
		else
		{
			request.setAttribute("ErrorMsg", "User/Password not valid");
	rd=request.getRequestDispatcher("/pages/jsp/Error.jsp");
			rd.forward(request, response);
	
		}
		
	}

}
