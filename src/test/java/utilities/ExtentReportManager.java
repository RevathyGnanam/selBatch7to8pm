package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest test;
	String repName;
	
	
	public void onStart(ITestContext context) {
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   repName= "test-report-"+ timeStamp + ".html";
	   sparkReporter = new ExtentSparkReporter(".\\Reports\\" +repName);
	   
	   sparkReporter.config().setDocumentTitle("DemoWebShop Automation Report");
	   sparkReporter.config().setReportName("DemoWebShop Functional testing");
	   sparkReporter.config().setTheme(Theme.DARK);
	   
	   extentReports = new ExtentReports();
	   extentReports.attachReporter(sparkReporter);
	   extentReports.setSystemInfo("Application", "DemoWebShop");
	   extentReports.setSystemInfo("Module", "Admin");
	   extentReports.setSystemInfo("Sub Module", "Customers");
	   extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
	   extentReports.setSystemInfo("Environment", "QA");
	   
	   String browser = context.getCurrentXmlTest().getParameter("os");
	   extentReports.setSystemInfo("Operating System", browser);
	   
	   List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
	   if(!includedGroups.isEmpty()) {
		   extentReports.setSystemInfo("Groups", includedGroups.toString());
	   }
	   
	  }
	
	public void onTestSuccess(ITestResult result) {
	   test = extentReports.createTest(result.getTestClass().getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.PASS, result.getName()+" Got successfully executed");
	   
	  }
	
	  
	   public void onTestFailure(ITestResult result) {
		   test = extentReports.createTest(result.getTestClass().getName());
		   test.assignCategory(result.getMethod().getGroups());
		   test.log(Status.FAIL, result.getName()+" Got failed");
		   test.log(Status.INFO, result.getThrowable().getMessage());
		   
		   try {
			   String imgpath = new BaseClass().captureScreen( result.getName());
			   test.addScreenCaptureFromPath(imgpath);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   
	     
	   }
	   
	   public void onTestSkipped(ITestResult result) {
		   test = extentReports.createTest(result.getTestClass().getName());
		   test.assignCategory(result.getMethod().getGroups());
		   test.log(Status.SKIP, result.getName()+" Got skipped");
		   test.log(Status.INFO, result.getThrowable().getMessage());
		  }
	   public void onFinish(ITestContext context) {
		   extentReports.flush();
		   String pathOfReport= System.getProperty("user.dir")+"\\Reports\\"+repName;
		   File report = new File(pathOfReport);
		   
		   try {
			Desktop.getDesktop().browse(report.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  }
	   

	

}
