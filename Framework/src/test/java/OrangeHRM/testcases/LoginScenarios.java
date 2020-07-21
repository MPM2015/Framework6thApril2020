package OrangeHRM.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import OrangeHRM.factories.ExcelProvider;
import OrangeHRM.factories.ObjectProviderFactory;
import OrangeHRM.pages.BaseClass;
import OrangeHRM.pages.LoginPage;
import OrangeHRM.pages.LogoutPage;


public class LoginScenarios extends BaseClass {
	
	LoginPage login;
	LogoutPage logout;

	@Test(priority = 0)
	public void verifyBeforeLoginDetails() {
		
		login = PageFactory.initElements(driver, LoginPage.class);
		logout = PageFactory.initElements(driver, LogoutPage.class);
		
		logger=report.createTest("URL Validation");
		login.verifyUrlBeforeLogin();
		logger.info("Validating url");

	}

	@Test(priority = 1, dependsOnMethods = "verifyBeforeLoginDetails")
	public void verifyAfterLoginDetails() {
		
		//ExcelProvider excel=new ExcelProvider(); - Created separate class to get the object- ObjectProviderFactory
		
		logger=report.createTest("Login as Admin");
		login.loginToApplication(ObjectProviderFactory.getExcel().getCellData("OrangeHRM", 1, 0), 
				ObjectProviderFactory.getExcel().getCellData("OrangeHRM", 1, 1));
		login.verifyUrlAfterLogin();
		logger.info("Logged in");
	}

	@Test(priority = 2, dependsOnMethods = "verifyAfterLoginDetails")
	public void verifyLogoutDetails() {
		logger=report.createTest("Logout");
		logout.logoutfromApplication();
		logger.info("Logout done");

	}

}
