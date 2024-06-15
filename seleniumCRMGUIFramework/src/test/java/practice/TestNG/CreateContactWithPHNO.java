package practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithPHNO {
	public class CreateContactTest {
		@Test(dataProvider="geatData")
		public void createContact(String Firstname,String lastName, long phno) {
			System.out.println("FirstName"  +Firstname+  ",LastName"   +lastName+  ",phoneno" +phno);
			
		}
		@DataProvider
		public Object[][] geatData(){
			Object[][] objarr=new Object[3][3];
			objarr[0][0]= "steve";
			objarr[0][1]= "Jhon";
			objarr[0][2]=987654321;
			
			objarr[1][0]= "Tom";
			objarr[1][1]= "Kvein";
			objarr[1][2]=876543219;
			
			objarr[2][0]= "Sam";
			objarr[2][1]= "SJ";
			objarr[2][2]=765432198;
			
			return objarr;
		}

	}


}
