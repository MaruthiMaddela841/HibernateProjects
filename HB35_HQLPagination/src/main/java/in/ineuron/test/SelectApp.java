package in.ineuron.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			Query<InsurancePolicy> query=session.createQuery("FROM in.ineuron.model.InsurancePolicy");
			query.setFirstResult(0);
			query.setMaxResults(2);
			List<InsurancePolicy> list=query.list();
			list.forEach(System.out::println);
			
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