package com.revature.dao;

import java.util.List;

import com.revature.model.ReimbursementRequest;

public interface ReimbursementRequestDAO {
	
	List<ReimbursementRequest> findAll();
	ReimbursementRequest findById(int id);
	void insert(ReimbursementRequest r);
	void update(ReimbursementRequest r);
	void delete(ReimbursementRequest r);

}
