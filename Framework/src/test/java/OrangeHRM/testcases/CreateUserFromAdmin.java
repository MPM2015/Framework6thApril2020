package OrangeHRM.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import OrangeHRM.factories.ExcelProvider;
import OrangeHRM.factories.ObjectProviderFactory;
import OrangeHRM.pages.AdminPage;
import OrangeHRM.pages.BaseClass;
import OrangeHRM.pages.LoginPage;
import OrangeHRM.pages.LogoutPage;


public class CreateUserFromAdmin extends BaseClass {
	
	LoginPage login;
	LogoutPage logout;
	AdminPage admin;

	@Test(priority = 0)
	public void verifyBeforeLoginDetails() {
		
		login = PageFactory.initElements(driver, LoginPage.class);
		logout = PageFactory.initElements(driver, LogoutPage.class);
		admin = PageFactory.initElements(driver, AdminPage.class);
		
		logger=report.createTest("URL Validation - Admin Scenario");
		login.verifyUrlBeforeLogin();
		logger.info("Validating url");

	}

	@Test(priority = 1, dependsOnMethods = "verifyBeforeLoginDetails")
	public void verifyAfterLoginDetails() {
		
		//ExcelProvider excel=new ExcelProvider(); - Created separate class to get the object- ObjectProviderFactory
		
		logger=report.createTest("Login as Admin - Admin Scenario");
		login.loginToApplication(ObjectProviderFactory.getExcel().getCellData("OrangeHRM", 1, 0), 
				ObjectProviderFactory.getExcel().getCellData("OrangeHRM", 1, 1));
		login.verifyUrlAfterLogin();
		logger.info("Logged in");
	}

	@Test(priority = 2, dependsOnMethods = "verifyAfterLoginDetails")
	public void verifyUserAddition() {
		logger=report.createTest("User Addition - Admin Scenario");
		admin.createUser();		
		logger.info("User added Successfully");

	}

}
