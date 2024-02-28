package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports report;//globally declaration
	ExtentTest test;//globally declaration
	
	
	public void onTestStart(ITestResult result) {
		
		//@Test -method
		String methodname=result.getMethod().getMethodName();
		
		System.out.println(methodname+"---Test Execution Started---");
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		
		System.out.println(methodname+"---Test Pass---");
		test.log(Status.PASS,methodname+"---Test Pass---" );
	
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		
		System.out.println(methodname+"---Test  Fail---");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL,methodname+"---Test Fail---" );
		test.log(Status.INFO,result.getThrowable());
       
		//capture screenshot
		SeliniumUtility s=new SeliniumUtility();
		JavaUtility j=new JavaUtility();
		
		String ScreenshotName=methodname+" - "+j.getsystemDate();
		try {
		String path = s.captureScreenshot(Baseclass.sdriver, ScreenshotName);
		
		test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		
		System.out.println(methodname+"---Test Skip---");
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		


	}

	public void onStart(ITestContext context) {
		
		
		System.out.println("---Suite Execution Started---");
		
		ExtentSparkReporter htmlrep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getsystemDate()+".html");
		htmlrep.config().setDocumentTitle("excecution report");
		htmlrep.config().setReportName("vtiger report");
		htmlrep.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Baseplatform", "windows");
		report.setSystemInfo("BaseBrowser", "Chrome");
		report.setSystemInfo("Basep Env", "Test Env");
		report.setSystemInfo("Reporter Name", "Raji Reddy");
	
	}

	public void onFinish(ITestContext context) {
		
		
		System.out.println("---Suite Execution Finished---");
		report.flush();
		
	}
	
	

}
