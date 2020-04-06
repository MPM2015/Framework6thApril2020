package OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import OrangeHRM.helper.Utility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	By username = By.id("txtUsername");

	/*
	 * @FindBy(id = "txtUsername") WebElement Username;
	 */

	By Password = By.id("txtPassword");

	/*
	 * @FindBy(id = "txtPassword") WebElement Password;
	 */

	By loginbutton = By.id("btnLogin");

	/*
	 * @FindBy(id="btnLogin") WebElement loginbutton;
	 */

	public void typeUsername() {
		Utility.waitForWebElement(driver, username).sendKeys("Admin");

	}

	public void typePassword() {
		Utility.waitForWebElement(driver, Password).sendKeys("admin123");

	}

	public void clickonLoginButton() {
		Utility.waitForWebElement(driver, loginbutton).click();

	}

	public void loginToApplication(String userName, String PassWord) {

		Utility.waitForWebElement(driver, username).sendKeys(userName);
		Utility.waitForWebElement(driver, Password).sendKeys(PassWord);
		Utility.waitForWebElement(driver, loginbutton).click();

	}

	public void verifyUrlBeforeLogin() {

		Assert.assertTrue(driver.getCurrentUrl().contains("demo"), "Before login Does Not Contain demo in the URL");
	}

	public void verifyUrlAfterLogin() {

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
				"After login Page Does Not Contain Dashboard in the URL");
	}

}
