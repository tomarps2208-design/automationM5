package ExtentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReport 
{
	ExtentReports report;
	@Test
	public void intaLogin()
	{
		System.out.println("Login");
	}
	
	@BeforeSuite
	public void config()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/newrep1");
		spark.config().setDocumentTitle("Instagram Test");
		spark.config().setReportName("Instagram Login");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("ATE", "Prashant");
		ExtentTest test = report.createTest("intaLogin");
		test.log(Status.FAIL, "This Test is Failed.....");
		test.log(Status.PASS, "This Test is Passed.....");
		test.log(Status.INFO, "This Test is Info.....");

	}
	@AfterSuite
	public void backup()
	{
		report.flush();
	}
}
