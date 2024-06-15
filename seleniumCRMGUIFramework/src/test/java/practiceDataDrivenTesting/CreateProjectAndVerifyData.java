package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyData {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
String projectname="Test_0802";

WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("http://106.51.90.215:8084/");
driver.findElement(By.id("username")).sendKeys("rmgyantra");
driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[text()='Sign in']")).click();
driver.findElement(By.linkText("Projects")).click();
driver.findElement(By.xpath("//span[text()='Create Project']")).click();
driver.findElement(By.name("projectName")).sendKeys(projectname);
driver.findElement(By.name("createdBy")).sendKeys("Glen");
driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select")).click();
driver.findElement(By.xpath("(//option[@value='On Going'])[2]")).click();
driver.findElement(By.xpath("//input[@type='submit']")).click();

Driver driverref=new Driver();
DriverManager.registerDriver(driverref);
Connection connection = DriverManager.getConnection("Jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
System.out.println("connection node");
Statement stmnt = connection.createStatement();
ResultSet result = stmnt.executeQuery("select * from project");
boolean flag=false;
while(result.next()) {
	String actualPrname=result.getString(4);
	if(projectname.endsWith(actualPrname)) {
		 flag= true;
		System.out.println(projectname+"is available pass");
		
	}
	if(flag=false) {
		System.out.println(projectname+"is not available fail");
		
	}
}






	}

}
