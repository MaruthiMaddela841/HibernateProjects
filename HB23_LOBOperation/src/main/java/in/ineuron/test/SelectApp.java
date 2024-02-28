package in.ineuron.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Integer id=1;
		JobSeeker js=null;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
			js=session.get(JobSeeker.class, id);
			if(js!=null) {
				System.out.println(js);
				try(FileOutputStream fos= new FileOutputStream("./store/pic.jpg");FileWriter fw= new FileWriter("./store/test.pdf")) {
					fos.write(js.getPhoto());
					fw.write(js.getResume());
		
				}
			}
			else {
				System.out.println("Record not available");
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
