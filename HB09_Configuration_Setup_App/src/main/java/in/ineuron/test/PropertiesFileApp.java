package in.ineuron.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class PropertiesFileApp {
	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {

			Configuration configuration = new Configuration();// by default searches for hibernate.properties file
//			FileInputStream fis= new FileInputStream(file);
//			Properties properties= new Properties();
//			properties.load(fis);
//			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Student.class);

			sessionFactory=configuration.buildSessionFactory();
			session=sessionFactory.openSession();
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
