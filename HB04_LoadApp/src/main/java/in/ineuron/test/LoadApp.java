package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session=null;
		Integer id=1;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				Student student=session.load(Student.class, id);
				if(student!=null) {
					System.out.println(student.getSid());
					System.in.read();
					System.out.println(student.getSage());
					System.out.println(student.getSname());
					System.out.println(student.getSaddress());
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
