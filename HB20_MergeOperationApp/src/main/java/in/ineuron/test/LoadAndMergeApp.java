package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadAndMergeApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Student std1=null;
		Student std2=null;
		Student std3=null;
		
		try {
			session=HibernateUtil.getSession();
			
			if(session!=null) {
				std1=session.get(Student.class, 4);
				System.out.println("STD1:"+std1);
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				std2=new Student();
				std2.setSid(4);
				std2.setSaddress("WGL");
				std2.setSage(30);
				std2.setSname("Raj");
				std3=(Student) session.merge(std2);
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
