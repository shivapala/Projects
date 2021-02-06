package com.flyaway.DAO.services;

import com.entity.flyaway.model.Login;

public interface LoginSvc {
	
	public int updatePassword(Login login);
	public Login validateUser(Login login);

}
