package com.revature;


import com.revature.model.Employee;
import com.revature.model.ReimbursementRequest;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;
import com.revature.util.HibernateSessionFactory;

public class Initialize {

	public static void main(String...args) {
		

		HibernateSessionFactory.getSession();
		EmployeeService eService = new EmployeeService();
//		ManagerService mService = new ManagerService();
		ReimbursementService rService = new ReimbursementService();
		
		Employee emp0 = new Employee("cid", "kramer", "balamb", null, true);
		System.out.println("This employee is: " + emp0.getUsername());
		eService.insert(emp0);
//		eService.update(emp0);
		System.out.println(eService.findAll());
		
		Employee emp1 = new Employee("squall", "leo", "ellone", emp0, true);
		System.out.println("This employee is: " + emp1.getUsername());
		eService.insert(emp1);
//		eService.update(emp1);
		System.out.println(eService.findAll());
		
		Employee emp2 = new Employee("rinoa", "heart", "angelo", emp0, true);
		System.out.println("This employee is: " + emp1.getUsername());
		eService.insert(emp2);
//		eService.update(emp2);
		System.out.println(eService.findAll());
		
		Employee emp3 = new Employee("lan", "mega", "navi", emp1, false);
		System.out.println("This employee is: " + emp3.getUsername());
		eService.insert(emp3);
//		eService.update(emp3);
		System.out.println(eService.findAll());
		
		Employee emp4 = new Employee("maylu", "roll", "acdc", emp2, false);
		System.out.println("This employee is: " + emp3.getUsername());
		eService.insert(emp4);
//		eService.update(emp4);
		System.out.println(eService.findAll());
		
		Employee emp5 = new Employee("dex", "guts", "strength", emp2, false);
		System.out.println("This employee is: " + emp3.getUsername());
		eService.insert(emp5);
//		eService.update(emp5);
		System.out.println(eService.findAll());
		
		ReimbursementRequest req1 = new ReimbursementRequest(1, "lanReq", 500.00, false, emp3, emp1, null );
		System.out.println("This request is for: " + req1.getAmount_requested());
		rService.insert(req1);
//		eService.update(req1);
		System.out.println(rService.findAll());
		
		ReimbursementRequest req2 = new ReimbursementRequest(1, "lanReq2", 1000.00, false, emp3, emp1, null );
		System.out.println("This request is for: " + req1.getAmount_requested());
		rService.insert(req2);
//		eService.update(req2);
		System.out.println(rService.findAll());
		
		ReimbursementRequest req3 = new ReimbursementRequest(1, "maylreq", 800.00, false, emp4, emp2, null );
		System.out.println("This request is for: " + req1.getAmount_requested());
		rService.insert(req3);
//		eService.update(req3);
		System.out.println(rService.findAll());
		
		
		ReimbursementRequest req4 = new ReimbursementRequest(1, "dexreq", 200.00, false, emp5, emp2, null );
		System.out.println("This request is for: " + req1.getAmount_requested());
		rService.insert(req4);
//		eService.update(req4);
		System.out.println(rService.findAll());

	}
}
