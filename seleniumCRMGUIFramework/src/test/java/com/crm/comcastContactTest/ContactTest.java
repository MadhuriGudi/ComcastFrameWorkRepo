package com.crm.comcastContactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClassTest.BaseClass;
import com.comcast.crm.objectRepositryUtility.ContactInfoPage;
import com.comcast.crm.objectRepositryUtility.ContactPage;
import com.comcast.crm.objectRepositryUtility.CreateContactPage;
import com.comcast.crm.objectRepositryUtility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepositryUtility.Homepage;
import com.comcast.crm.objectRepositryUtility.Organisationpage;
@Listeners(com.comcast.crm.listnerutility.Listner_implimentation.class)
public class ContactTest extends BaseClass {
	@Test
	public void createContacttest() throws EncryptedDocumentException, IOException {
		String LASTNAME = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		Homepage hp = new Homepage(driver);
		hp.getContactlink().click();
        ContactPage cp = new ContactPage(driver);
		cp.getNewcontbtn().click();
		System.out.println("after click");
		// enter mandatory field
		CreateContactPage ccp = new CreateContactPage(driver);
		wlib.waitForElement(driver, cp.getNewcontbtn());
		ccp.CreateNewContact(LASTNAME);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ActCont = cip.getContheader().getText();
		if (ActCont.contains(LASTNAME)) {
			System.out.println(LASTNAME + "name is varified and pass");
		} else {
			System.out.println(LASTNAME + "name is varified and fail");

		}
	}
	
	@Test
	public void createContactWithDate() throws Exception, IOException {
	String	LASTNAME = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
	System.out.println("navigate to home page");
		Homepage hp=new Homepage(driver);
		System.out.println("home page displayed");
		hp.getContactlink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getNewcontbtn().click();
		System.out.println("after click");
		//enter mandatory field
		CreateContactPage ccp=new CreateContactPage(driver);
		Thread.sleep(5000);
//		wlib.waitForElement(driver,cp.getNewcontbtn());
		ccp.contactDate(LASTNAME);
		}
       @Test
       public void CreateContactWithOrg() throws InterruptedException, Exception, IOException {
    	   String	LASTNAME = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
    	   String ORGNAME=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
    	   Homepage hp=new Homepage(driver);
    	   System.out.println("home page displayed");
    	   hp.getOrgLink().click();
    	   Organisationpage oip=new Organisationpage(driver);
   		oip.getCreateNeworgButton().click();
   		//Enter mandatory details
   		CreateNewOrganisationPage cnorgp=new CreateNewOrganisationPage(driver);
   		cnorgp.createorg(ORGNAME);
   		//navigate to  contact pageo
   		Thread.sleep(2000);
   		hp.getContactlink().click();
  		System.out.println("clicked on contact page");
  		ContactPage cp=new ContactPage(driver);
   		System.out.println("navigated to contact info page");
   		cp.getNewcontbtn().click();
   		
  	    //enter mandatory field
  		CreateContactPage ccp=new CreateContactPage(driver);
 		Thread.sleep(2000);
 		ccp.createContWithOrg(LASTNAME, ORGNAME);
 		
   		}
       }
    	   
       
