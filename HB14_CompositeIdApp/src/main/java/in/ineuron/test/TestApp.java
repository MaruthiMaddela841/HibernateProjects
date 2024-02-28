package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		ProgrammerProjId pk=null;
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				ProgrammerProjId projId= new ProgrammerProjId();
				projId.setPid(100);
				projId.setProjId(502);
				
				ProgrammerProjInfo info=new ProgrammerProjInfo();
				info.setId(projId);
				info.setpName("IPL");
				info.setDeptNo(10);
				info.setProjName("IND");
				pk=(ProgrammerProjId)session.save(info);
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
