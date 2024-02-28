package in.ineuron.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			Criteria criteria=session.createCriteria(Product.class);
			List<Product> products=criteria.list();
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