package com.flyaway.DAO.services.Impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.flyaway.model.Login;
import com.flyaway.DAO.DBConnection;
import com.flyaway.DAO.services.LoginSvc;
import com.flyaway.queries.FlyAwayQueries;

public class LoginSvcImpl implements LoginSvc {
	EntityManager entityManger=null;
	FlyAwayQueries queries=new FlyAwayQueries();
	
	public LoginSvcImpl()
	{
		
		entityManger=DBConnection.getEntityManager();
	}
	@Override
	public int updatePassword(Login login) {
		
		// TODO Auto-generated method stub
		//entityManger.
		String strQuery=queries.updateLoginPwd();
		Query query=entityManger.createNativeQuery(strQuery, login.getClass());
		query.setParameter("userName", login.getUserName());
		query.setParameter("password", login.getPassword());
		
		int result=query.executeUpdate();
		
		return result;
	}
	@Override
	public Login validateUser(Login login) {
		// TODO Auto-generated method stub
		String strQuery=queries.validateUser();
		Query query=entityManger.createNativeQuery(strQuery,login.getClass());
		query.setParameter("userName", login.getUserName());
		query.setParameter("password", login.getPassword());
		try {
		login= (Login) query.getSingleResult();
		return login;
		}catch(Exception ex)
		{
			System.out.println("No result found ");
			ex.printStackTrace();
			return null;
		}
	}

}
