package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp3 {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Query<Object[]> query=session.createQuery("SELECT price,qty FROM in.ineuron.model.Product WHERE pname IN(:prod1,:prod2)");
			query.setParameter("prod1", "fossil");
			query.setParameter("prod2", "titan");
			List<Object[]> products=query.list();
			System.out.println("PRICE\tQTY");
			products.forEach(row->{
				
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
			
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
