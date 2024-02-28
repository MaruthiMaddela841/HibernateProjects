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
		Transaction transaction=null;
		Boolean flag=false;
		int rowEffected=0;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			NativeQuery nativeQuery=session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			nativeQuery.setParameter("min", 8);
			List<Object[]> policies=nativeQuery.getResultList();
			policies.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
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
				System.out.println("Rows Effected");
			}
			else {
				transaction.rollback();
				System.out.println("Rows Not Effected");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}