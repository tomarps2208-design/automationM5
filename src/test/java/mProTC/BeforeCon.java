package mProTC;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BeforeCon 
{
	ExtentReports report;
	@BeforeSuite
	public void congif()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/newrep1");
		spark.config().setDocumentTitle("mPro Test");
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

}
