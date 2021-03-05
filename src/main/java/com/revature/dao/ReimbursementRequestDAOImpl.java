package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ReimbursementRequest;
import com.revature.util.HibernateSessionFactory;

public class ReimbursementRequestDAOImpl implements ReimbursementRequestDAO {

	@Override
	public List<ReimbursementRequest> findAll() {
		List<ReimbursementRequest> retVal = new ArrayList<>();
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.createQuery("FROM ReimbursementRequest", ReimbursementRequest.class).getResultList();
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
	public ReimbursementRequest findById(int id) {
		ReimbursementRequest retVal = null;
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			retVal = s.get(ReimbursementRequest.class, id);
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
	public void insert(ReimbursementRequest r) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.save(r);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void update(ReimbursementRequest r) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.update(r);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}


	@Override
	public void delete(ReimbursementRequest r) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.delete(r);
			tx.commit();
		}catch(HibernateException exc) {
			exc.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}
}
