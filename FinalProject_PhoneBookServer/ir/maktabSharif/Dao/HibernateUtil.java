package ir.maktabSharif.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	final static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration()
		        .configure("hibernate.cfg.xml").buildSessionFactory();	
	}
	
	public static Session getHibernateSession() {

	   
	    Session session = sessionFactory.openSession();
	    return session;
	    }
	
	
}
