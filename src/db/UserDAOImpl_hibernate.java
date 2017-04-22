package db;
import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import db.UserDTO;


public class UserDAOImpl_hibernate{
	
	private static SessionFactory sessionFactory;
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public void createUser(UserDTO user) {
		try {
//			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			Transaction tx =(Transaction) session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void removeByPrimaryKey(java.lang.String username) {
		try {
			UserDAOImpl_hibernate.createSessionFactory();
			Session session = sessionFactory.openSession();
//			session = HibernateInitialize.getSession();
			org.hibernate.Transaction tx =session.beginTransaction();
			
//			session.delete("from MYUSER where USERNAME ='"+username+"'");
			session.delete(username);
			session.flush();
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}