package com.comcast.crm.listnerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClassTest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listner_implimentation implements ITestListener, ISuiteListener{
	public static ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report config");
	    spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "chrome");
		
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"==start===");
	    test= report.createTest(result.getMethod().getMethodName());
	    test.log(Status.INFO, result.getMethod().getMethodName()+"Started");
			}

	public void onTestSuccess(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"==End===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"completed");
		
	}

	public void onTestFailure(ITestResult result) {
		String testname= result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String filepath= ts.getScreenshotAs(OutputType.BASE64);
		String time= new Date().toString().replace("", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,testname+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"failed");
			
		
			
		
	
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
	
	}

}
