package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		System.out.println("Studentgenerator generate()");
		String id=" ";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=si.connection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select sid_seq.nextval from dual");
			while(resultSet.next()) {
				int i=resultSet.getInt(1);
				id=""+i;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return id;
	}

}
