package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PolicyInfo;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Long id=null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				PolicyInfo pi=new PolicyInfo();
				pi.setPolicyName("Mandir");
				pi.setPolicyType("Yearly");
				pi.setTenure(6);
				id=(Long) session.save(pi);
				flag = true;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
