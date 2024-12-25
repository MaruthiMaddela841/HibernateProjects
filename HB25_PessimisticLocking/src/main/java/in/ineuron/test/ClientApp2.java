package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PolicyInfo;
import in.ineuron.util.HibernateUtil;

public class ClientApp2 {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction = null;
		Long id=2L;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				PolicyInfo pi=session.get(PolicyInfo.class, id,LockMode.UPGRADE_NOWAIT);
				System.out.println(pi);
				pi.setPolicyType("Monthly");
				flag=true;
			}
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to DB with id:"+id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
