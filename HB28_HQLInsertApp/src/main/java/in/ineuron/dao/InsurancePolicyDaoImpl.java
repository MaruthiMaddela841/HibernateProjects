package in.ineuron.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao{

	@Override
	public String transferPolicies(int minTenure) {
		Session session=null;
		Transaction transaction = null;
		Query query=null;
		int rowTransfered=0;
		Boolean flag=false;
		String msg=null;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			query=session.getNamedQuery("HQL_TRANSFER_POLICIES");
			query.setParameter("min", minTenure);
			rowTransfered=query.executeUpdate();
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				transaction.commit();
				msg="Rows effected:"+rowTransfered;
			}
			else {
				transaction.rollback();
				msg="No Rows effected";
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		return msg;
	}

}
