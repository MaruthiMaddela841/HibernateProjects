package in.ineuron.test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		int rowEffected=0;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			NativeQuery nativeQuery=session.createSQLQuery("INSERT INTO InsurancePolicy(company,policyName,policyType,tenure) VALUES (?,?,?,?)");
			nativeQuery.setParameter(1, "Infy");
			nativeQuery.setParameter(2, "Exco");
			nativeQuery.setParameter(3, "Yearly");
			nativeQuery.setParameter(4, "8");
			rowEffected=nativeQuery.executeUpdate();
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