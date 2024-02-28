package in.ineuron.test;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		int rowEffected=0;
		
		try {
			session=HibernateUtil.getSession();
			ProcedureCall procedureCall=session.createStoredProcedureCall("SP_GET_PRODUCT_BY_NAME",Product.class);
			procedureCall.registerParameter(1,String.class, ParameterMode.IN).bindValue("fossil");;
			procedureCall.registerParameter(2,String.class, ParameterMode.IN).bindValue("titan");;
			List<Product> products=procedureCall.getResultList();
			products.forEach(System.out::println);
			flag=true;
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Rows Effected");
			}
			else {
				transaction.rollback();
				System.out.println("Rows Not Effected");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}