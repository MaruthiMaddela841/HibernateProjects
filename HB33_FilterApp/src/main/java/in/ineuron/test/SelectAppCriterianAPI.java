package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppCriterianAPI {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Filter filter = session.enableFilter("FILTER_NOT_CLOSED_ACCOUNTS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");

			Criteria criteria = session.createCriteria(BankAccount.class);

			Criterion c1 = Restrictions.gt("balance", 2000.0f);
			Criterion c2 = Restrictions.lt("balance", 10000.0f);

			criteria.add(c1);
			criteria.add(c2);

			List<BankAccount> list = criteria.list();
			list.forEach(System.out::println);

			System.out.println("*************");

			session.disableFilter("FILTER_NOT_CLOSED_ACCOUNTS");

			Criteria criteria1 = session.createCriteria(BankAccount.class);

			Criterion c3 = Restrictions.gt("balance", 2000.0f);
			Criterion c4 = Restrictions.lt("balance", 10000.0f);

			criteria1.add(c3);
			criteria1.add(c4);

			List<BankAccount> list1 = criteria1.list();
			list1.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}