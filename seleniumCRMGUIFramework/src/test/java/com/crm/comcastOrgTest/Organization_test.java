package com.crm.comcastOrgTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.BaseClassTest.BaseClass;
import com.comcast.crm.objectRepositryUtility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.OrganisationInfoPage;
import com.comcast.crm.objectRepositryUtility.Organisationpage;

public class Organization_test extends BaseClass {
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException, InterruptedException {
	String orgname=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
	//login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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

@Test
public void createOrgWithIndustry() throws Exception, IOException {
	
String orgname=elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
String Industries=elib.getDataFromExcel("org", 4, 3);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//navigate to  organization page
Homepage hp=new Homepage(driver);
System.out.println("navigated to home page");
hp.getOrgLink().click();
//click on CreateOrganization link
Organisationpage oip=new Organisationpage(driver);
oip.getCreateNeworgButton().click();
//Enter mandatory details
CreateNewOrganisationPage cnorgp=new CreateNewOrganisationPage(driver);
cnorgp.createorg(orgname, Industries);
hp.logout();
}


@Test
public void createOrgWithPhonenumber() throws InterruptedException, Exception, IOException {
	String orgname=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
	String phoneNo=elib.getDataFromExcel("org", 7, 3);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//navigate to  organization page
	Homepage hp=new Homepage(driver);
	hp.getOrgLink().click();
	//click on CreateOrganization link
	Organisationpage oip=new Organisationpage(driver);
	oip.getCreateNeworgButton().click();
	//Enter mandatory details
	CreateNewOrganisationPage cnorgp=new CreateNewOrganisationPage(driver);
	cnorgp.createphoneNum(phoneNo);
	cnorgp.createorg(orgname);
	System.out.println(orgname+"created");
	hp.logout();
}
}
	


