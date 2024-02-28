package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class DeleteApp2 {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = 2;

		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, 2);
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				if(student!=null) {
					session.delete(student);
					flag = true;
				}
				else
					System.out.println("Record not found");

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object deleted to DB");
			} else {
				transaction.rollback();
				System.out.println("Object not deleted to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
