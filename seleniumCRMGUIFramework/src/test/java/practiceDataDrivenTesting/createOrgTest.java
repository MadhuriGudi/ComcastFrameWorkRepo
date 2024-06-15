package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class createOrgTest {

	public static void main(String[] args) throws IOException  {
		FileInputStream fis=new FileInputStream("./testdata/commondata.Properties");
		Properties p=new Properties();
		p.load(fis);
		Random random= new Random();
		int randomint=random.nextInt(1000);
		FileInputStream fis1=new FileInputStream("./testdata/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String data = row.getCell(2).toString() +  randomint;
		wb.close();
		WebDriver driver = null;
		String BROWSER=p.getProperty("browser");
		String URL =p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD= p.getProperty("password");
		if (BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
				}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(data);
		WebElement industry = driver.findElement(By.name("industry"));
		Select s=new Select(industry);
		s.selectByVisibleText("Communications");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	String headertext = driver.findElement(By.className("dvHeaderText")).getText();
		
	String exphtext="abc123456789";
	if(headertext.contains(exphtext)) {
		System.out.println("organisation name is varified and correct");
	}
	else {
		System.out.println("organisation name is incorrect");
	}
	WebElement target = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
	Actions action= new Actions(driver);
	action.moveToElement(target).build().perform();
	driver.findElement(By.linkText("Sign Out")).click();
		
		
			
		
		
		
	
	

	}

}
