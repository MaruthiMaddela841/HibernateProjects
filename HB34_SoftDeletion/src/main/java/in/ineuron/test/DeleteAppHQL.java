package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class DeleteAppHQL {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		Integer rowCount=0;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("DELETE FROM in.ineuron.model.BankAccount where accno=:no");
			query.setParameter("no", 1234);
			rowCount=query.executeUpdate();
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
				System.out.println("Object Status changed to Closed/Blocked"+rowCount);
			}
			else {
				transaction.rollback();
				System.out.println("Object Status Not Changed"+rowCount);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}