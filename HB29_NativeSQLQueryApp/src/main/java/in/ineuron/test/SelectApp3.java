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

public class SelectApp3 {
	
	public static void main(String[] args) {
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			NativeQuery<Object[]> nativeQuery=session.createSQLQuery("SELECT policyName,policyType FROM INSURANCEPOLICY WHERE TENURE>:min AND TENURE>:max");
			nativeQuery.setParameter("min", 10);
			nativeQuery.setParameter("max", 12);
			nativeQuery.addScalar("policyName",StandardBasicTypes.STRING);
			nativeQuery.addScalar("policyType",StandardBasicTypes.STRING);
			List<Object[]> policies=nativeQuery.getResultList();
			System.out.println("PNAME\tPTYPE");
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