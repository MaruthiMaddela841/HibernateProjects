 package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.StudentRecords;
import in.ineuron.util.HibernateUtil;

public class LoadAndMergeApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		StudentRecords std1=null;
		StudentRecords std2=null;
		StudentRecords std3=null;
		
		try {
			session=HibernateUtil.getSession();
			
			if(session!=null) {
				std1=session.get(StudentRecords.class, 1);
				System.out.println("STD1:"+std1);
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				std2=new StudentRecords();
				std2.setSid(2);
				std2.setSaddress("WGL");
				std2.setSage(30);
				std2.setSname("Rajesh");
				std3=(StudentRecords) session.merge(std2);
				System.out.println("STD3:"+std3);
				System.out.println(std1.hashCode()+":"+std2.hashCode()+":"+std3.hashCode());
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
				System.out.println("Object updated to DB");
			}
			else {
				transaction.rollback();
				System.out.println("Object not updated to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
