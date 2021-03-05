package com.revature.dao;

import java.util.List;

import com.revature.model.Manager;

public interface ManagerDAO {
	
	List<Manager> findAll();
	Manager findByName(String username);
	Manager findById(int id);
	void insert(Manager m);
	void update(Manager m);
	void delete(Manager m);

}
