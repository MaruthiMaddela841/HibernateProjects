package in.ineuron.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp3 {
	
	public static void main(String[] args) {
		
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();
			
			
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