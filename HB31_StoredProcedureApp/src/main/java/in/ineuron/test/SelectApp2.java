package in.ineuron.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp2 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		int rowEffected = 0;

		try {
			session = HibernateUtil.getSession();
			Integer pid = 1;
			ProcedureCall procedureCall = session.createStoredProcedureCall("SP_GET_PRODUCT_DETAILS_BY_ID");
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(pid);
			;
			procedureCall.registerParameter(2, String.class, ParameterMode.OUT);
			procedureCall.registerParameter(3, Integer.class, ParameterMode.OUT);
			procedureCall.registerParameter(4, Integer.class, ParameterMode.OUT);

			String pname = (String) procedureCall.getOutputParameterValue(2);
			Integer price = (Integer) procedureCall.getOutputParameterValue(3);
			Integer qty = (Integer) procedureCall.getOutputParameterValue(4);
			System.out.println("PNAME:"+pname+", PRICE:"+price+", QTY:"+qty);

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Rows Effected");
			} else {
				transaction.rollback();
				System.out.println("Rows Not Effected");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}