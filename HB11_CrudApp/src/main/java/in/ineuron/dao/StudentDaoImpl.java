package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	Session session=HibernateUtil.getSession();
	
	@Override
	public String addStudent(String name, Integer age, String address) {
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status=null;
		try {
			if(transaction!=null) {
				Student student=new Student();
				student.setSname(name);
				student.setSage(age);
				student.setAddress(address);
				session.save(student);
				flag=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				status="success";
			}
			else {
				transaction.rollback();
				status="failure";
			}
		}
		return status;
	}

	@Override
	public Student searchStudent(Integer id) {
		Student student=session.get(Student.class, id);
		if(student!=null) {
			return student;
		}
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		Student student=searchStudent(sid);
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status=null;
		try {
			if(student!=null) {
				student.setAddress(saddress);
				student.setSage(sage);
				student.setSname(sname);
				session.update(student);
				flag=true;
			}
			else {
				return "not found";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				status="success";
			}
			else {
				transaction.rollback();
				status="not found";
			}
		}
		return status;
	}

	@Override
	public String deleteStudent(Integer id) {
		Student student=searchStudent(id);
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status=null;
		try {
			if(student!=null) {
				session.delete(student);
				flag=true;
			}
			else {
				return "not found";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				status="success";
			}
			else {
				transaction.rollback();
				status="failure";
			}
		}
		return status;
	}

	@Override
	public String updateStudent(Student stdnt) {
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status=null;
		try {
			if(transaction!=null) {
				session.merge(stdnt);
				flag=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(flag) {
				transaction.commit();
				status="success";
			}
			else {
				transaction.rollback();
				status="not found";
			}
		}
		return status;
	}
}