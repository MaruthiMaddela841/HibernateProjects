package in.ineuron.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.util.HibernateUtil;

public class InsertApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			CardPayment cardPayment= new CardPayment();
			cardPayment.setCardNo(45678L);
			cardPayment.setPid(1234);
			cardPayment.setAmount(8000.5f);
			cardPayment.setCardType("Debit");
			cardPayment.setPaymentGateway("Visa");
			
			ChequePayment chequePayment= new ChequePayment();
			chequePayment.setAmount(4500.6f);
			chequePayment.setPid(1235);
			chequePayment.setChequeNo(229458L);
			chequePayment.setChequeType("Self");
			chequePayment.setExpiryDate(LocalDate.of(2024, 01, 21));
			
			session.save(cardPayment);
			session.save(chequePayment);
			
			flag = true;
			
			
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
				System.out.println("Object added");
			}
			else {
				transaction.rollback();
				System.out.println("Object not added");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
