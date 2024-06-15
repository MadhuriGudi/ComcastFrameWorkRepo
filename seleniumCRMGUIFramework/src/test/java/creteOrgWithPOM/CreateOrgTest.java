package creteOrgWithPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectRepositryUtility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.LoginPage;
import com.comcast.crm.objectRepositryUtility.OrganisationInfoPage;
import com.comcast.crm.objectRepositryUtility.Organisationpage;

public class CreateOrgTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib=new FileUtility();
    	ExcelUtility Elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		String BROWSER=flib.getDataFRomPropertiesFile("browser");
		String URL=flib.getDataFRomPropertiesFile("url");
		String USERNAME=flib.getDataFRomPropertiesFile("username");
		String PASSWORD=flib.getDataFRomPropertiesFile("password");
		String orgname=Elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
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
		
		//navigate to  organization page
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();
		
		//click on CreateOrganization link
		Organisationpage oip=new Organisationpage(driver);
		oip.getCreateNeworgButton().click();
		
		//Enter mandatory details
		CreateNewOrganisationPage cnorgp=new CreateNewOrganisationPage(driver);
		cnorgp.createorg(orgname);
		
		//verify header message
		OrganisationInfoPage oip1= new OrganisationInfoPage(driver);
		String ActOrg = oip1.getHeaderMsg().getText();
		if(ActOrg.contains(orgname)) {
			System.out.println(orgname+  "name is varified and pass");
		}
		else {
			System.out.println(orgname+  "name is varified and fail");
			
		}
		
		//LogOut
		hp.logout();
		
		
		


}
}
