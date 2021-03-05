package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee findByName(String username);
	void insert(Employee e);
	void update(Employee e);
	void delete(Employee e);

}
