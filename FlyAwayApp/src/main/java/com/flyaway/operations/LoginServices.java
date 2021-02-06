package com.flyaway.operations;

import com.entity.flyaway.model.Login;
import com.flyaway.DAO.services.DBOperations;
import com.flyaway.DAO.services.LoginSvc;
import com.flyaway.DAO.services.Impl.DBOperationsImp;
import com.flyaway.DAO.services.Impl.LoginSvcImpl;

public class LoginServices {
	
	LoginSvc loginSvc=new LoginSvcImpl();
	public void addUser(Login login)
	{
		
		/*Login login=new Login();
		login.setUserName("capamerica");
		login.setPassword("capamerica");
		login.setRole("Admin");*/
		DBOperations dbOPs=new DBOperationsImp();
		dbOPs.addData(login);
		
		System.out.println("User "+login.getUserName()+" successfully added : "+login.getUser_id());
		
	}
	
	public Login validateUser(Login login)
	{
		String pwd=login.getPassword();
		login=loginSvc.validateUser(login);
		
		if(login!=null )
		{
		System.out.println("Values Pressent : "+login.getUserName());
			return login;
		}
		else
		{
			System.out.println("No user/pwd match : "+login);
			return login;
		}
		
		
	}
	
	public void updatePassword(Login login)
	{
		
		/*Login login=new Login();
		login.setUserName("capamerica");
		login.setPassword("capamerica");
		login.setRole("Admin");*/
	//	DBOperations dbOPs=new DBOperationsImp();
		//dbOPs.addData(login);
		
		System.out.println("User "+login.getUserName()+" successfully added : "+login.getUser_id());
		
	}

}
