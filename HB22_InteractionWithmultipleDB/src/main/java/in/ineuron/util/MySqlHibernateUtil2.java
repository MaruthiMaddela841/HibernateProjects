package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Product;

public class MySqlHibernateUtil2 {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private MySqlHibernateUtil2() {

	}

	static {
		sessionFactory = new Configuration().configure("in/ineuron/cfg/mysql2-hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSession(Session session) {
			if(session!=null)
				session.close();
	}

	public static void closeSessionFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();

	}
}
