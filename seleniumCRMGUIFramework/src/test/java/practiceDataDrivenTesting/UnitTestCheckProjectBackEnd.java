package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class UnitTestCheckProjectBackEnd {
	@Test
	public void projectCheckTest() throws SQLException {
		String expectedProjectName= "Instgram_25";
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("Jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("connection done");
		Statement stmnt = connection.createStatement();
		ResultSet result = stmnt.executeQuery("select * from project");
		while(result.next()) {
			String actualProjectName= result.getString(4);
			if(expectedProjectName.equals(actualProjectName)) {
				flag=true;
				System.out.println(expectedProjectName+"  is available==pass");
				
			}
		}
		if(flag==false) {
			System.out.println(expectedProjectName+ "  is not available==Fail");
			Assert.fail();
		}
		connection.close();
	}
	

}
