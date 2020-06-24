package OrangeHRM.pages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import OrangeHRM.helper.Utility;

public class AzureLoginPage {

	WebDriver driver;

	public AzureLoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	By username = By.id("signInName");
	By Password = By.id("password");
	By loginbutton = By.id("next");
	By vcode=By.id("strongAuthenticationAppCode");
	By continuebutton=By.id("continue");
	

	
	public void loginToApplication(String userName, String PassWord) {
		
		Utility.waitForWebElement(driver, username).sendKeys(userName);
		Utility.waitForWebElement(driver, Password).sendKeys(PassWord);
		Utility.waitForWebElement(driver, loginbutton).click();
		
		String otpKeyStr = "6jm7n6xwitpjooh7ihewyyzeux7aqmw2";
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now();
		
		Utility.waitForWebElement(driver, vcode).sendKeys(twoFactorCode);
		Utility.waitForWebElement(driver, continuebutton).click();

	}

	public void verifyUrlBeforeLogin() 
	{

		Assert.assertTrue(driver.getCurrentUrl().contains("pmprichui"),"Before login: <pmprichui> does Not Contain in the URL");
	}

	public void verifyUrlAfterLogin()
	{

		Assert.assertTrue(driver.getCurrentUrl().contains("b2clogin1"),"After login: <b2clogin> Page does not contain in the URL");
	}

}
