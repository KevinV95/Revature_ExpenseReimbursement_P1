package com.revature.service;

import java.util.List;

import com.revature.dao.ManagerDAO;
import com.revature.dao.ManagerDAOImpl;
import com.revature.model.Manager;

public class ManagerService {
	
	private ManagerDAO mDao;
	
	public ManagerService() {
		mDao = new ManagerDAOImpl();
	}
	
	public void insert(Manager m) {
		this.mDao.insert(m);
	}
	
	public void delete(Manager e) {
		this.mDao.delete(e);
	}
	
	public List<Manager> findAll(){
		return this.mDao.findAll();
	}
	
	public Manager findById(int id) {
		return this.mDao.findById(id);
	}
	
	public void update(Manager e) {
		this.mDao.update(e);
	}

}
