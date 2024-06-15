package com.BaseClassTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.LoginPage;
import com.comcast.generic.databaseutility.DataBaseUtility;

public class BaseClass2 {
	 public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	
	 public WebDriver driver=null;
	 public static WebDriver sdriver;
	 public ExtentReports report;
	 
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("===connect DB======,Report config");
		dlib.getDbConnection();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "chrome");
	}
		@BeforeClass
		public void configBC() throws IOException {
			System.out.println("====Launch Browser");
			String BROWSER = flib.getDataFRomPropertiesFile("browser");
			
			if (BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}
			else if (BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			sdriver=driver;
			
		}
		@BeforeMethod
		public void configBM() throws IOException {
			System.out.println("===Login to app====");
			LoginPage lp=new LoginPage(driver);
			String URL = flib.getDataFRomPropertiesFile("url");
			String USERNAME = flib.getDataFRomPropertiesFile("username");
			String PASSWORD = flib.getDataFRomPropertiesFile("password");
			lp.loginToApp( URL,USERNAME ,PASSWORD); 
		}
		@AfterMethod
		public void configAM() throws InterruptedException {
			System.out.println("====logout======");
			Homepage hp= new Homepage(driver);
			hp.logout();
			
		}
		@AfterClass
		public void configAC() {
			System.out.println("==close browser===");
			driver.quit();
		}
		@AfterSuite
		public void configAS() throws SQLException {
			System.out.println("===closedb==,Report backup");
			dlib.closeDbConnection();
			
			report.flush();
		}
	

}
