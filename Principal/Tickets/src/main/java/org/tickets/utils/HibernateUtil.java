package org.tickets.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {

			Configuration conf = new Configuration().configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder s = new StandardServiceRegistryBuilder();
			s.applySettings(conf.getProperties());
			ServiceRegistry sr = s.build();
			sessionFactory = conf.buildSessionFactory(sr);
		} catch (Throwable ex) {
			System.err.println("La sesion creada fallo." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
