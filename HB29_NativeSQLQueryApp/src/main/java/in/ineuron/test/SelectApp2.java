package in.ineuron.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp2 {
	
	public static void main(String[] args) {
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			NativeQuery<InsurancePolicy> nativeQuery=session.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>:min AND TENURE>:max");
			nativeQuery.setParameter("min", 10);
			nativeQuery.setParameter("max", 12);
			nativeQuery.addEntity(InsurancePolicy.class);
			List<InsurancePolicy> policies=nativeQuery.getResultList();
			System.out.println("PID\tCOMPANY\tPNAME\tPTYPE\tTENURE");
			policies.forEach(System.out::println);
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