package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Manager;
import com.revature.util.HibernateSessionFactory;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public List<Manager> findAll() {
		 List<Manager> retVal = new ArrayList<>();
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.createQuery("FROM Manager", Manager.class).getResultList();
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
	public Manager findByName(String username) {
		return null;
	}

	@Override
	public Manager findById(int id) {
		Manager retVal = null;
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.get(Manager.class, id);
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
	public void insert(Manager m) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.save(m);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void update(Manager m) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.update(m);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void delete(Manager m) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.delete(m);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

}
