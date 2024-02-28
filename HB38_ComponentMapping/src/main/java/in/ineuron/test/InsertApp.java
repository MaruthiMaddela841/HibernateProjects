package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.model.Address;
import in.ineuron.util.HibernateUtil;

public class InsertApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Address address1 = new Address();
			address1.setCity("MNCL");
			address1.setCountry("IND");

			Student student1 = new Student();

			student1.setSname("M1");
			student1.setSage(23);
			student1.setAddress(address1);

			Address address2 = new Address();
			address2.setCity("MNCL");
			address2.setCountry("IND");

			Student student2 = new Student();

			student2.setSname("M1");
			student2.setSage(23);
			student2.setAddress(address2);

			session.save(student1);
			session.save(student2);
			flag = true;
			
			
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
				System.out.println("Object added");
			}
			else {
				transaction.rollback();
				System.out.println("Object not added");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
