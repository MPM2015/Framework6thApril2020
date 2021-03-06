package OrangeHRM.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import OrangeHRM.factories.BrowserFactory;
import OrangeHRM.factories.ObjectProviderFactory;
import OrangeHRM.helper.Utility;

public class BaseClass {
	
	/*public LoginPage login;
	public LogoutPage logout;*/
	public WebDriver driver;
	public static ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupReport() {
		
		System.out.println("Log:INFO: Report is getting setup");
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		System.out.println("Log:INFO: Report setup is ready");
		
	}
	
	@AfterMethod
	public void tearDownReport(ITestResult result) {
		
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Log:INFO:Test Executed : Test Result is Passed");
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Log:INFO:Test Executed : Test Result is Failed");
				
			}
			
		else if(result.getStatus()==ITestResult.SKIP) {
			System.out.println("Log:INFO:Test Executed : Test Result is Skipped");
			
		}
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed");
			
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			try {
				logger.fail("Test Failed" +result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenShot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to attach screenshot in the report" +e.getMessage());
				
			}
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped");
			
		}
		report.flush();
		
	}

	//Parameters will come from jenkins to POM.XML
	//@Parameters({"Browser","AppURL"})	
	//@BeforeClass
	//public void setUp(String browser,String appURL) 
	@BeforeClass
	public void setUp(){
		
		System.out.println("Log:INFO: Setting up Browser and Application");
		//ConfigProvider config=new ConfigProvider(); --- Created separate class to get the object- ObjectProviderFactory
		
		/*driver = BrowserFactory.getApplication(ObjectProviderFactory.getConfig().getValue("Browser"),
				ObjectProviderFactory.getConfig().getValue("QAEnv"));*/	
		
		driver = BrowserFactory.getApplication(ObjectProviderFactory.getConfig().getValue("Browser"),
				ObjectProviderFactory.getConfig().getValue("AzureURL"));	
		
		//driver = BrowserFactory.getApplication(browser,appURL);
		
		
		System.out.println("Log:INFO: Browser and Application is ready");
		
		
	/*	login = PageFactory.initElements(driver, LoginPage.class);
		logout = PageFactory.initElements(driver, LogoutPage.class);
		*/

	}
	
	/*@Parameters({"os","os_version","browser","browser_version","applicationURL"})	
	@BeforeClass
	public void setUpGrid(String os,String os_version,String browser,String browser_version,String applicationURL) {
		
		System.out.println("Log:INFO: Setting up Selenium Grid Details");
		driver=BrowserFactory.startApplicationUsingGrid(ObjectProviderFactory.getConfig().getValue("os"),
				ObjectProviderFactory.getConfig().getValue("os_version"),ObjectProviderFactory.getConfig().getValue("browser"),
				ObjectProviderFactory.getConfig().getValue("browser_version"),ObjectProviderFactory.getConfig().getValue("applicationURL"));
				
		driver=BrowserFactory.startApplicationUsingGrid(os,os_version,browser,browser_version,applicationURL);
		
		System.out.println("Log:INFO:Selenium Grid Details are ready");
		
	}*/
	
	/*@AfterClass
	public void tearDown() {
		System.out.println("Log:INFO: Terminating Browser");
		BrowserFactory.closeApplication(driver);		
		System.out.println("Log:INFO: Browser Terminated");
		
	}*/

	
	

}
