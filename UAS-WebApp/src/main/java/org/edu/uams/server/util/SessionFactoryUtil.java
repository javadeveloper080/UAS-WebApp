package org.edu.uams.server.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static SessionFactory factory; 


	public static Session getSession() {
		createSessionFactory();
		return factory.openSession();

	}

	public static SessionFactory createSessionFactory() {

		if (factory==null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;

	}

}
