package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("Jdbc:mysql://106.51.90.215:3333/projects", "root@%","root" );
		System.out.println("Connection done");
		Statement stmnt = connection.createStatement();
		int result = stmnt.executeUpdate(" insert into project values ('TY_PROJ_5438', 'Pallavi', '27/05/2024','Face_book_01', 'Created', '15');");
		
		System.err.println(result);
		connection.close();

	

}
}
