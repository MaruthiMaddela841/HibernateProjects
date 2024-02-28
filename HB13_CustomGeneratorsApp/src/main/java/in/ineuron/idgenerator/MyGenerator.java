package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		System.out.println("Studentgenerator generate()");
		System.out.println("Studentgenerator generate()");
		String date=new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int num=new Random().nextInt(1000);
		return "Maru"+date+"-"+num;
	}
}
