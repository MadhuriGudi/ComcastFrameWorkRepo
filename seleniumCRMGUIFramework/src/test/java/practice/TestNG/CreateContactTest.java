package practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest {
	@Test(dataProvider="geatData")
	public void createContact(String Firstname,String lastName) {
		System.out.println("FirstName"  +Firstname+  ",LastName"   +lastName);
		
	}
	@DataProvider
	public Object[][] geatData(){
		Object[][] objarr=new Object[3][2];
		objarr[0][0]= "steve";
		objarr[0][1]= "Jhon";
		
		objarr[1][0]= "Tom";
		objarr[1][1]= "Kvein";
		
		objarr[2][0]= "Sam";
		objarr[2][1]= "SJ";
		
		return objarr;
	}

}
