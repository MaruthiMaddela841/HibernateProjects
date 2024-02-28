package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Long id=1L;
		Transaction transaction=null;
		Boolean flag=false;
		BankAccount account=null;
		try {
			session=HibernateUtil.getSession();
			account=session.get(BankAccount.class, id);
			System.out.println("Before modifying:"+account);
			if(account!=null) {
				transaction=session.beginTransaction();
				account.setHolderName("Maruthi");;
				flag=true;
				
			}
			else {
				System.out.println("Record Not Found");
				System.exit(0);
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
				System.out.println("After Modifying:"+account);
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
