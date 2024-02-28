package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

//Connection connection=DriverManager.getConnection(url,usr,pwd)
//abstraction logic of implementation
public class StudentServiceFactory {

	//private constructor so no object creation
	private StudentServiceFactory() {
		
	}
	private static IStudentService studentService=null;
	public static IStudentService getStudentService() {
		//singleton method
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}
}