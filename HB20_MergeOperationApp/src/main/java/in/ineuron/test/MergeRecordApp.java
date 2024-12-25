package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.StudentRecords;
import in.ineuron.util.HibernateUtil;

public class MergeRecordApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		StudentRecords std=null;
		
		try {
			StudentRecords student=new StudentRecords();
			student.setSid(4);
			student.setSaddress("HYD");
			student.setSage(29);
			student.setSname("Maruthi");
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				std=(StudentRecords) session.merge(student);
				System.out.println(std);
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
