package in.ineuron.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			NativeQuery<Object[]> nativeQuery=session.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>? AND TENURE>?");
			nativeQuery.setParameter(1, 10);
			nativeQuery.setParameter(2, 12);
			List<Object[]> policies=nativeQuery.getResultList();
			System.out.println("PID\tCOMPANY\tPNAME\tPTYPE\tTENURE");
			policies.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
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