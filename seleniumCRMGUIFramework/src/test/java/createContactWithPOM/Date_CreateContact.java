package createContactWithPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositryUtility.ContactPage;
import com.comcast.crm.objectRepositryUtility.CreateContactPage;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.LoginPage;

public class Date_CreateContact {
	public static void main(String[] args) throws IOException {
		FileUtility flib=new FileUtility();
		ExcelUtility Elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String BROWSER=flib.getDataFRomPropertiesFile("browser");
		String URL=flib.getDataFRomPropertiesFile("url");
		String USERNAME=flib.getDataFRomPropertiesFile("username");
		String PASSWORD=flib.getDataFRomPropertiesFile("password");
		String LASTNAME=Elib.getDataFromExcel("contact", 7, 3)+jlib.getRandomNumber();
		WebDriver driver=null;
		if (BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		//login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		
		//navigate to  contact page
		Homepage hp=new Homepage(driver);
		hp.getContactlink().click();
		
		
		ContactPage cp=new ContactPage(driver);
		cp.getNewcontbtn().click();
		System.out.println("after click");
				
		//enter mandatory field
		CreateContactPage ccp=new CreateContactPage(driver);
		wlib.waitForElement(driver,cp.getNewcontbtn());
		ccp.CreateNewContact(LASTNAME);
	
		ccp.contactDate();
		

		
	
		
		
		
		
	}

}
