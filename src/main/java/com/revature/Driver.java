package com.revature;


import com.revature.model.Employee;
import com.revature.model.ReimbursementRequest;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;
import com.revature.util.HibernateSessionFactory;

public class Driver {

	public static void main(String...args) {
		

		HibernateSessionFactory.getSession();


	}
}
