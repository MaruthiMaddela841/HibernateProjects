package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class TestApp {

	public static void main(String[] args) {
		
		Configuration configuration=new Configuration();
		configuration.configure();
		
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();

		
		Student student=new Student();
		student.setSid(1);
		student.setSaddress("MI");
		student.setSage(23);
		student.setSname("Sachin");
		
		session.save(student);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Object saved to DB Successfully	");
	}

}
