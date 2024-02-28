package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Products;
import in.ineuron.util.MySqlHibernateUtil1;
import in.ineuron.util.MySqlHibernateUtil2;

public class TransferDaoImpl implements ITransferDao{

	@SuppressWarnings("finally")
	@Override
	public String transferProductById(Integer id) {
		Session session1=MySqlHibernateUtil1.getSession();
		Session session2=MySqlHibernateUtil2.getSession();
		Integer idValue=0;
		Boolean flag=false;
		Products products=session1.get(Products.class, id);
		Transaction t1=null;
		if(products==null) {
			return "Record not available for copying..";
		}
		else {
			try {
				t1=session2.beginTransaction();
				idValue=(Integer) session2.save(products);
				flag=true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					t1.commit();
					return "Record copied";
				}
				else {
					t1.rollback();
					return "Record not copied";
				}
			}
		}
	}
}
