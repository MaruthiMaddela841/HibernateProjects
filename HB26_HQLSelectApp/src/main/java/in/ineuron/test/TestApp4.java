package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp4 {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Query<Product> query=session.createQuery("FROM in.ineuron.model.Product WHERE pid=:id");
			query.setParameter("id", 15);
			List<Product> products=query.list();
			System.out.println(products.size());
			if(!products.isEmpty()) {
				System.out.println(products);
			}
			else {
				System.out.println("Record Not Available");
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
