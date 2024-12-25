package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		byte[] photo=null;
		char[] resume=null;
		File file=null;
		try (FileInputStream fis = new FileInputStream("D:\\iNeuron\\pic.jpg")) {
			photo = new byte[fis.available()];
			fis.read(photo);
		}
		try{
			file=new File("D:\\iNeuron\\test.pdf");
			try(FileReader fr= new FileReader(file);) {
				resume=new char[(int) file.length()];
				fr.read(resume);
			}
			
			
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				JobSeeker js = new JobSeeker();
				js.setJsAddress("HNK");
				js.setJsId(1);
				js.setJsName("Maru");
				js.setPhoto(photo);
				js.setResume(resume);
				id=(Integer) session.save(js);
				flag = true;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to DB with ID:" + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
