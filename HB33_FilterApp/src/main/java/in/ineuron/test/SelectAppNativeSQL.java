package in.ineuron.test;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppNativeSQL {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			Filter filter=session.enableFilter("FILTER_NOT_CLOSED_ACCOUNTS");
			filter.setParameter("accType1","blocked");
			filter.setParameter("accType2","closed");
			
			NativeQuery nativeQuery=session.createSQLQuery("SELECT * FROM bankaccount WHERE balance>=:amt");
			nativeQuery.setParameter("amt", 3000.0f);
			nativeQuery.addEntity(BankAccount.class);
			List<BankAccount> account=nativeQuery.list();
			account.forEach(System.out::println);
			
			System.out.println("*********************");
			
			session.disableFilter("FILTER_NOT_CLOSED_ACCOUNTS");
			NativeQuery nativeQuery1=session.createSQLQuery("SELECT * FROM bankaccount WHERE balance>=:amt");
			nativeQuery1.setParameter("amt", 3000.0f);
			nativeQuery1.addEntity(BankAccount.class);
			List<BankAccount> account1=nativeQuery1.list();
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