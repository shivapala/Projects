package com.flyaway.DAO.services.Impl;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.flyaway.DAO.DBConnection;
import com.flyaway.DAO.services.DBOperations;

public class DBOperationsImp implements DBOperations {

	EntityManager entityManger=null;
	public DBOperationsImp()
	{
		entityManger=DBConnection.getEntityManager();
	}
	@Override
	public void addData(Object entity) {
		entityManger.getTransaction().begin();
		entityManger.persist(entity);
		// TODO Auto-generated method stub
		entityManger.getTransaction().commit();
		System.out.println("Added the data sucessfully"+entity.getClass().getName());

	}

	@Override
	public void Delete(Object entity) {
		// TODO Auto-generated method stub
		entityManger.getTransaction().begin();
		entityManger.remove(entity);
		// TODO Auto-generated method stub
		entityManger.getTransaction().commit();
		System.out.println("Removed the data sucessfully"+entity.getClass().getName());

	}
	
	public void validateUser(Object entity,Object key) {
		// TODO Auto-generated method stub
		entityManger.getTransaction().begin();
		entityManger.find(entity.getClass(),key);
		// TODO Auto-generated method stub
		entityManger.getTransaction().commit();
		System.out.println("Removed the data sucessfully"+entity.getClass().getName());

	}

}
