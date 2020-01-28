package com.demo.bussinesslogic;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.model.Address;
import com.demo.model.Student;
import com.demo.util.HibernateUtil;

public class MainLogicClass {
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	public static void main(String[] args) {
		
		logger.info("***************Application starting **********************");
		logger.info("***********************************************");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
			Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
			Student student1 = new Student("Eswar", address1);
			Student student2 = new Student("Joe", address2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}