package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementRequestDAO;
import com.revature.dao.ReimbursementRequestDAOImpl;
import com.revature.model.ReimbursementRequest;

public class ReimbursementService {
	
	private ReimbursementRequestDAO rDao;
	
	public ReimbursementService() {
		rDao = new ReimbursementRequestDAOImpl();
	}
	
	public void insert(ReimbursementRequest r) {
		this.rDao.insert(r);
	}
	
	public void delete(ReimbursementRequest r) {
		this.rDao.delete(r);
	}
	
	public List<ReimbursementRequest> findAll(){
		return this.rDao.findAll();
	}
	
	public ReimbursementRequest findById(int id) {
		return this.rDao.findById(id);
	}
	
	public void update(ReimbursementRequest r) {
		this.rDao.update(r);
	}
}
