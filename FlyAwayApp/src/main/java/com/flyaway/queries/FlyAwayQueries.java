package com.flyaway.queries;

public class FlyAwayQueries {
	StringBuilder strQuery;
	
	public String updateLoginPwd()
	{
		strQuery=new StringBuilder();
		
		strQuery.append("update table login set password=:password where userName=:userName");
		
		return strQuery.toString();
	}
	
	public String validateUser()
	{
		strQuery=new StringBuilder();
		
		strQuery.append("select user_id,userName,password,Role from login  where userName=:userName and password=:password");
		
		return strQuery.toString();
	}

}
