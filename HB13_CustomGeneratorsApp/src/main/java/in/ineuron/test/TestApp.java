package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
import in.ineuron.util.HibernateUtilmySQl;

public class TestApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String id=null;
		
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtilmySQl.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				Student student=new Student();
				student.setSname("Maruthi");
				student.setSage(26);
				student.setSaddress("ssp");
				id=(String)session.save(student);
				flag=true;
				
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
				transaction.commit();
				System.out.println("Object inserted to DB with ID:"+id);
			}
			else {
				transaction.rollback();
				System.out.println("Object not inserted to DB");
			}
			HibernateUtilmySQl.closeSession(session);
			HibernateUtilmySQl.closeSessionFactory();
		}

	}

}
