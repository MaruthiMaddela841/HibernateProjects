package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Integer id=null;
		ProgrammerProjId pk=null;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				ProgrammerProjId projId= new ProgrammerProjId();
				projId.setPid(100);
				projId.setProjId(503);
				ProgrammerProjInfo info=session.get(ProgrammerProjInfo.class, projId);
				if(info!=null) {
					System.out.println(info);
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
