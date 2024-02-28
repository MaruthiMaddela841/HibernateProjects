package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateApp2 {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		Integer id=1;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Student student=session.get(Student.class, id);
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				
				if(student!=null) {
					System.out.println(student);
					System.in.read();
					student.setSname("MMM");
					session.update(student);
					flag=true;
				}
				else {
					System.out.println("Record not Found");
				}
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Object updated to DB");
			}
			else {
				transaction.rollback();
				System.out.println("Object not updated to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
