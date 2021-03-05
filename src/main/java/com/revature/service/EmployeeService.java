package com.revature.service;

import java.util.List;

import com.revature.model.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeService {
	
	private EmployeeDAO eDao;
	
	public EmployeeService() {
		eDao = new EmployeeDAOImpl();
	}
	
	public void insert(Employee e) {
		this.eDao.insert(e);
	}
	
	public void delete(Employee e) {
		this.eDao.delete(e);
	}
	
	public List<Employee> findAll(){
		return this.eDao.findAll();
	}
	
	public boolean isValidUser(String username, String password) {
		List<Employee> users = findAll();
		
		for(Employee u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Employee findByName(String username) {
		return this.eDao.findByName(username);
	}
	
	public void update(Employee e) {
		this.eDao.update(e);
	}
}
