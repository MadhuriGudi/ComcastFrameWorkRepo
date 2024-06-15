package practice_report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sample_reportTest {
	public ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "chrome");
		
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	
	@Test
	public void createContacttest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		
		ExtentTest test= report.createTest("create Contact test");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if("HDFgfC".equals("HDFC")) {
			test.log(Status.PASS, "contact created");
		}
		else {
			test.log(Status.FAIL, "contact created");
			test.addScreenCaptureFromBase64String(filepath,"Error");
			
		}
		driver.close();
		
		
	}
	

}
