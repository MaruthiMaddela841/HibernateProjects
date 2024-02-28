package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {
		/*
		 * Connection Pooling: Pool of connection objects will be created so we need not want to create that
		 * pool Every connection pool objects will be an implementation class object of data source interface. 
		 * If we work with connection pool objects the mechanism is for request of a client a connection object will be
		 * ready, and this object will be given to the request , then request will be processed with that and once the 
		 * request is completely processed the connection objects will not be closed rather the connection objects are 
		 * pushed back to connection pool through which reusability feature will be promoted.
		 */
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				Student student=new Student();
				student.setSname("Maruthi");
				student.setSage(28);
				student.setSaddress("MNCL");
				session.save(student);
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
