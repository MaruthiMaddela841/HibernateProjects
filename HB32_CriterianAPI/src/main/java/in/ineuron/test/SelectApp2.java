package in.ineuron.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp2 {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			Criteria criteria=session.createCriteria(Product.class);
			Criterion c1=Restrictions.ge("price", 1600);
			Criterion c2=Restrictions.le("price", 1800);
			criteria.add(c1);
			criteria.add(c2);//default AND condition
			
			Order order=Order.asc("pname");
			criteria.addOrder(order);
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