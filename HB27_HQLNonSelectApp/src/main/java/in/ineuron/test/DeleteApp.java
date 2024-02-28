package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("DELETE FROM in.ineuron.model.Product WHERE pid=:id");
			query.setParameter("id", 4);
			int rowEffected=query.executeUpdate();
			System.out.println("No of rows updated:"+rowEffected);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
