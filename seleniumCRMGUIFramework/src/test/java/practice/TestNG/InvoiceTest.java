package practice.TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClassTest.BaseClass;
@Listeners(com.comcast.crm.listnerutility.Listner_implimentation.class)
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoice() {
		System.out.println("execute createInvoicetest");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");


	}
	@Test
	public void createInvoiceContactTest() {
		System.out.println("execute createInvoicetestContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		
	}

}
