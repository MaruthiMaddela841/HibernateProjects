package in.ineuron.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp4 {
	
	public static void main(String[] args) {
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			NativeQuery<String> nativeQuery=session.createSQLQuery("SELECT policyName FROM INSURANCEPOLICY WHERE TENURE>:min AND TENURE>:max");
			nativeQuery.setParameter("min", 10);
			nativeQuery.setParameter("max", 12);
			List<String> policies=nativeQuery.getResultList();
			System.out.println("PNAME");
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