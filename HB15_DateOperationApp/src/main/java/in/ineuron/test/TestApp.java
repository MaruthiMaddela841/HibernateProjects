package in.ineuron.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;

		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				
				PersonInfo personInfo=new PersonInfo();
				personInfo.setPname("sachin");
				personInfo.setDob(LocalDate.of(1973, 04, 24));
				personInfo.setDom(LocalDateTime.of(1995,5,25,7,45));
				personInfo.setDoj(LocalTime.of(9,15));
				id=(Integer) session.save(personInfo);
				flag=true;
			}
			
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
				System.out.println("Object inserted to DB with ID:"+id);
			}
			else {
				transaction.rollback();
				System.out.println("Object not inserted to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
