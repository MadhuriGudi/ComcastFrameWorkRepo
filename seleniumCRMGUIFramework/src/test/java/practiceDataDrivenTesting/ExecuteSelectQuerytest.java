package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQuerytest {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("Jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("connection Done");
		Statement stmnt = connection.createStatement();
		ResultSet result = stmnt.executeQuery("select * from project");
		while(result.next()) {
			System.out.println(result.getString(1)+ "   "+ result.getString(2)+ "   " + result.getString(3));
		}
		connection.close();
		

	}

}
