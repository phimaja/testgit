package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.TestScript.BaseClass1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class GenerateReport extends TestListenerAdapter
{
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext testcontext)
	{
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String rep="Test-Report"+date+".html";
		reporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+rep);
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("First report");
		reporter.config().setReportName("colorful report");
		reporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("QA", "Himaja");
		extent.setSystemInfo("OS", "windows 10");
		extent.setSystemInfo("Browser", "Google chrome");
	
		
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
	public void onTestSuccess(ITestResult rv)
	 {
		test=extent.createTest(rv.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(rv.getName(), ExtentColor.GREEN));
	 }
	
	 public void onTestFailure(ITestResult rv)
	 {
		test=extent.createTest(rv.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(rv.getName(), ExtentColor.RED));
		  String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		  String s=rv.getName();	
		  EventFiringWebDriver efw= new EventFiringWebDriver(BaseClass1.driver); 
		  File f1=efw.getScreenshotAs(OutputType.FILE); 
		  String path=System.getProperty("user.dir")+"/Screenshot1/"+s+date+".jpg";
		  File f2= new File(path);
		  try { 
			  FileUtils.copyFile(f1,f2);
			  test.addScreenCaptureFromPath(path);
			  System.out.println("This line is executed");
		  }
		  catch (IOException e) {
		  
		  e.printStackTrace(); 
		  }
		 
		 
	 }
	
	 public void onTestSkipped(ITestResult rv)
	 {
	        test = extent.createTest(rv.getName());
	        test.log(Status.SKIP,MarkupHelper.createLabel(rv.getName(), ExtentColor.ORANGE));
	        
	 }

}
