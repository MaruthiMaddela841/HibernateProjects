package in.ineuron.test;

import java.io.IOException;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.MySqlHibernateUtil1;
import in.ineuron.util.MySqlHibernateUtil2;

public class InteractWithMultipleDB {

	public static void main(String[] args) throws IOException {
		
		ITransferDao dao= new TransferDaoImpl();
		System.out.println(dao.transferProductById(1));
		
		MySqlHibernateUtil1.closeSessionFactory();
		MySqlHibernateUtil2.closeSessionFactory();
	}

}
