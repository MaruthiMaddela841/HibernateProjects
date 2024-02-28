package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			BankAccount account= new BankAccount();
			account.setAccNo(1234);
			session.delete(account);
			flag=true;
			
			
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
				System.out.println("Object Status changed to Closed/Blocked");
			}
			else {
				transaction.rollback();
				System.out.println("Object Status Not Changed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}