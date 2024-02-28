package in.ineuron.test;

import java.io.IOException;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Integer id=1;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
			PersonInfo personInfo=session.get(PersonInfo.class,id);
			if(personInfo!=null) {
				System.out.println(personInfo);
			}
			else {
				System.out.println("Record Not Available");
			}
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
