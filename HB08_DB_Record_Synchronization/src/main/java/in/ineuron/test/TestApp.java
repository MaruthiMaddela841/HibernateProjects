package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws IOException {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, 1);
			System.out.println(student);
			if (session != null) {
				if (student != null) {
					System.in.read();
					session.refresh(student);
					System.out.println(student);
				} else
					System.out.println("Record not found");
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
