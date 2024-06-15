package com.comcast.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection connection;
	public void getDbConnection(String url,String username,String password) throws SQLException {
	try {
		Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 connection = DriverManager.getConnection(url,username,password);
	
	}
	catch (Exception e) {}
	}
	
	public void getDbConnection() throws SQLException {
		try {
			System.out.println("enter db");
			Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 connection = DriverManager.getConnection("Jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("connection sucssesfull");
		}
		catch (Exception e) {
			System.out.println("connection failed");
		}
		}
		public void closeDbConnection() throws SQLException {
			connection.close();
			
		}
	public ResultSet executeSelectQuery(String Query) throws SQLException {
		ResultSet result = null;
		try {
		 Statement stat = connection.createStatement();
		 result = stat.executeQuery(Query);
		
		} catch(Exception e) {}
		return result;
		
	}
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = connection.createStatement();
			 result =  stat.executeUpdate(query);
			}
		catch(Exception e){}
	return result;
	}

}
