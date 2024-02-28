package in.ineuron.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertApp {
	
	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Employee employee=new Employee();
			employee.setEid(10);
			employee.setEaddress("HYD");
			employee.setEname("Maru");
			
			employee.setFriendsList(List.of("Pruthwi","Srikanth","Ranjith","Vijju"));
			employee.setPhones(Set.of(10429L,11393L,26935L,33926L));
			employee.setBankAccounts(Map.of("SBI",122383L,"KOTAK",1120342L,"ICICI",112035L));
			
			session.save(employee);
			
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
