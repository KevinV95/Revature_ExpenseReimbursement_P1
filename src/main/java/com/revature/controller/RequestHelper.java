package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

public class RequestHelper {
	
	//decide available endpoints here
	public static Object processGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//grab the endpoint
		final String URI = req.getRequestURI();
		final String RESOURCE = URI.replace("/Project_1/api", "");
		System.out.println(RESOURCE + ": GET");
		
		
		switch(RESOURCE) {
		case "/cid/all":
			res.setStatus(200);
			return new EmployeeService().findAll();
		case "/logout":
			System.out.println(req.getHeader("referer"));
			HttpSession session = req.getSession(false);
			if(session != null) session.invalidate();
			res.getWriter().write("You've logged out");
//			res.flushBuffer();
//			delay(5000);
//			res.sendRedirect("/Project_1/index.html");
			break;
		case "/requests/all":
			res.setStatus(200);
			return new ReimbursementService().findAll();
		default:
			res.setStatus(404);
			return "not a valid endpoint";
		
		}
		return null;
	}
	
	//decide available POST endpoints
	public static void processPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//grab the endpoint
		final String URI = req.getRequestURI();
		final String RESOURCE = URI.replace("/Project_1/api", "");
		System.out.println(RESOURCE + " :POST");
		
		switch(RESOURCE) {
		//employee login portal
		case "/empLogin":
			final String e_username = req.getParameter("empLogin");
			final String e_password = req.getParameter("empPass");
			System.out.println(e_username + " withpassword: " + e_password);
			
			//if credentials are valid, grant the employee a session & redirect to a new view/resource
			if(new EmployeeService().isValidUser(e_username, e_password)) {
				System.out.println(e_username + " is granted a session with: " + e_password);
				HttpSession session = req.getSession();
				session.setAttribute("role", "employee");
				session.setAttribute("name", e_username);
				
				res.sendRedirect("/Project_1/Pages/employee.html");
			}
		res.getWriter().write("Invalid username or password");
		break;
		
		//manager login portal
		case "/manaLogin":
			final String username = req.getParameter("manaLogin");
			final String password = req.getParameter("manaPass");
			
			//if credentials are valid, grant the manager a session & redirect to a new view/resource
			if(new EmployeeService().isValidUser(username, password)) {
				System.out.println(username + " is logging in..");
				if(username.equals("cid")) {
					HttpSession session = req.getSession();
					session.setAttribute("role", "headmaster");
					session.setAttribute("name", username);
					res.sendRedirect("/Project_1/Pages/cid.html");
				} else {
					HttpSession session = req.getSession();
					session.setAttribute("role", "manager");
					session.setAttribute("name", username);
					
					res.sendRedirect("/Project_1/Pages/manager.html");					
				}
			}
			break;
			
		default:
			res.setStatus(404);
		
		}
	}
	
	private static void delay(int timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Slept for: " + timeInMillis/1000 + " seconds");
	}
}
