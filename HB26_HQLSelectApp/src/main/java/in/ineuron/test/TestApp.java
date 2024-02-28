package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Query query=session.createQuery("FROM in.ineuron.model.Product");
			List<Product> products=query.list();
			products.forEach(System.out::println);
			
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
