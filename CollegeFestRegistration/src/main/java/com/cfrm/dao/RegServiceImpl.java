package com.cfrm.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfrm.entity.Student;
import com.cfrm.service.RegistrationServices;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * One and only repository class 
 * Handling all Data Access job
 * 
 * @author Shain Joy
 */

@Repository
public class RegServiceImpl implements RegistrationServices {

	@Override
	public void save(Student participant) {
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(participant);
		txn.commit();
	}
	
	@Override
	public Student searchById(int studentId) {
		Student participant = new Student();
		Transaction txn = session.beginTransaction();
		participant = session.get(Student.class, studentId);
		txn.commit();
		return participant;
	}

	@Override
	public void deleteById(int studentId) {
		Transaction txn = session.beginTransaction();
		Student participant = session.get(Student.class, studentId);
		session.delete(participant);
		txn.commit();
	}
		
	@Override
	public List<Student> findAll() {
		Transaction txn = session.beginTransaction();
		List<Student> participants =session.createQuery("from Student").list();
		txn.commit();
		return participants;
	}
	
	@Override
	public List<Student> searchBy(String name, String dept, String country) {
		//Building query string based on passed in parameters
		String qry="from Student where";
		boolean flag = false;
		if (name.length()!=0) {
			qry = qry + " name like '%"+name+"%'";
			flag = true;
		}
		if (dept.length()!=0) {
			qry = qry + " dept like '%"+dept+"%'";
			flag = true;
		}
		if (country.length()!=0) {
			qry = qry + " country like '%"+country+"%'";
			flag = true;
		}
		if(flag == false)
			System.out.println("Cannot search without input data");
		
		System.out.println("my Qry: " + qry);
		
		//Executing query to get result
		Transaction txn = session.beginTransaction();
		List<Student> participants = session.createQuery(qry).list();
		txn.commit();
		return participants;
	}

	//Session
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	RegServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

}
