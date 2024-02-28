package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class PureJavaApp {

	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {

			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jdbcsessions");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "Maru@841");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.addAnnotatedClass(Student.class);

			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Student student = session.get(Student.class, 1);
			if (session != null) {
				if (student != null) {
					System.out.println(student);
				} else
					System.out.println("Record not found");
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
