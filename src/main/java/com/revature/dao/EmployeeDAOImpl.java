package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Employee;
import com.revature.util.HibernateSessionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> findAll() {
		List<Employee> retVal = new ArrayList<>();
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.createQuery("FROM Employee", Employee.class).getResultList();
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return retVal;
	}

	@Override
	public Employee findByName(String username) {
		Employee retVal = null;
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.get(Employee.class, username);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return retVal;
	}


	@Override
	public void insert(Employee e) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.save(e);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void update(Employee e) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.update(e);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void delete(Employee e) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.delete(e);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

}
