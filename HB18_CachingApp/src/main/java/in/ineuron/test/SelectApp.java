package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Integer id=null;
		InsurancePolicy policy=null;
		try {
			session = HibernateUtil.getSession();
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy);
			System.out.println("-------------------------------");//from db to L1 cache
			
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy);
			System.out.println("-------------------------------");//from l1 cache
			
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy);
			System.out.println("-------------------------------");//from l1 cache
			
			session.evict(policy);//remove policy obj from l1 cache
			
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy);
			System.out.println("-------------------------------");//from l1 cache
			
			session.clear();

		} catch (

		HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
