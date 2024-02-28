package in.ineuron.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp6 {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Query<Product> query=session.createQuery("FROM in.ineuron.model.Product WHERE pid=:id");
			query.setParameter("id", 1);
			Optional<Product> optional=query.uniqueResultOptional();
			if(optional.isPresent()) {
				Product product=optional.get();
				System.out.println(product);
			}
			else {
				System.out.println("Record not avaialable");
			}
			
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
