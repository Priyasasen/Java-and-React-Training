package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;


public class StudentConn {
	
	private static SessionFactory sessionFactory;
	
	StudentConn()
	{
		sessionFactory = new Configuration().configure("hiber.config.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		
		StudentConn s= new StudentConn();
		return sessionFactory;
	}
}

