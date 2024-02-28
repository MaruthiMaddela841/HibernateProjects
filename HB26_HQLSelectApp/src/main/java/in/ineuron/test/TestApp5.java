package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp5 {
	
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction = null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			Query<Product> query=session.createQuery("FROM in.ineuron.model.Product WHERE pid=:id");
			query.setParameter("id", 1);
			Product product=query.uniqueResult();
			if(product!=null)
				System.out.println(product);
			else
				System.out.println("Record not found");
			
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
