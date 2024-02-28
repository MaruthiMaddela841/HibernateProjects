package in.ineuron.test;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppHQL {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			Filter filter=session.enableFilter("FILTER_NOT_CLOSED_ACCOUNTS");
			filter.setParameter("accType1","blocked");
			filter.setParameter("accType2","closed");
			
			Query query=session.createQuery("FROM in.ineuron.model.BankAccount WHERE balance>=:amt");
			query.setParameter("amt", 3000.0f);
			
			List<BankAccount> account=query.list();
			account.forEach(System.out::println);
			
			System.out.println("*********************");
			
			session.disableFilter("FILTER_NOT_CLOSED_ACCOUNTS");
			Query query1=session.createQuery("FROM in.ineuron.model.BankAccount WHERE balance>=:amt");
			query1.setParameter("amt", 3000.0f);
			
			List<BankAccount> account1=query1.list();
			account1.forEach(System.out::println);
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