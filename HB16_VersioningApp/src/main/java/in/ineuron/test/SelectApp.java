package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Integer id=1;
		Transaction transaction=null;
		Boolean flag=false;
		MobileCustomer customer=null;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				customer=session.get(MobileCustomer.class, id);
				System.out.println("Before Modification");
				System.out.println(customer);
				transaction=session.beginTransaction();
				customer.setCallerTune("Mission Impossible");
				session.update(customer);
				flag=true;
				
			}
			else {
				
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
				System.out.println("Updated Successfully..");
				System.out.println("After Modification");
				System.out.println(customer);
			}
			else {
				transaction.rollback();
				System.out.println("Not Updated");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
