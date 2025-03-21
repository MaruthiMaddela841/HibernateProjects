package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class GetApp {

	public static void main(String[] args) {
		
		Session session=null;
		Integer id=2;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				Student student=session.get(Student.class, id);
				if(student!=null) {
					System.out.println(student);
				}
				else
					System.out.println("Record not found");
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
