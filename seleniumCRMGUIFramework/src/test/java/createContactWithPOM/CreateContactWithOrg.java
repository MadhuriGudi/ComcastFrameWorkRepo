package createContactWithPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectRepositryUtility.ContactPage;
import com.comcast.crm.objectRepositryUtility.CreateContactPage;
import com.comcast.crm.objectRepositryUtility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.LoginPage;
import com.comcast.crm.objectRepositryUtility.Organisationpage;

public class CreateContactWithOrg {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib=new FileUtility();
		ExcelUtility Elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		String BROWSER=flib.getDataFRomPropertiesFile("browser");
		String URL=flib.getDataFRomPropertiesFile("url");
		String USERNAME=flib.getDataFRomPropertiesFile("username");
		String PASSWORD=flib.getDataFRomPropertiesFile("password");
		String LASTNAME=Elib.getDataFromExcel("contact", 7, 3)+jlib.getRandomNumber();
		String ORGNAME=Elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
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
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();
		
		//click on CreateOrganization link
		Organisationpage oip=new Organisationpage(driver);
		oip.getCreateNeworgButton().click();
		
		//Enter mandatory details
		CreateNewOrganisationPage cnorgp=new CreateNewOrganisationPage(driver);
		cnorgp.createorg(ORGNAME);
		//navigate to  contact page
		Thread.sleep(2000);
		hp.getContactlink().click();
		
		
		ContactPage cp=new ContactPage(driver);
		cp.getNewcontbtn().click();
		System.out.println("after click");
				
		//enter mandatory field
		CreateContactPage ccp=new CreateContactPage(driver);
		Thread.sleep(2000);
		ccp.createContWithOrg(LASTNAME, ORGNAME);
		

	}

}
