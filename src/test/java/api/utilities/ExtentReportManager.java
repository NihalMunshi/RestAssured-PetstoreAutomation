package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkrepoters;
	public ExtentReports extent;
	public ExtentTest test;
	public void onstart(ITestContext testContext)
	{
		
		sparkrepoters.config().setDocumentTitle("page title");
		sparkrepoters.config().setEncoding("utf-8");
		
		
		sparkrepoters.config().setReportName("build name");
		sparkrepoters.config().setTheme(Theme.DARK);
		sparkrepoters.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
	}
}
