package OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OrangeHRM.helper.Utility;

public class LogoutPage {

	WebDriver driver;

	public LogoutPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	By adminText = By.xpath("//a[text()='Welcome Admin']");
	By logoutText = By.xpath("//a[text()='Logout']");

	public void logoutfromApplication() {
		Utility.waitForWebElement(driver, adminText).click();
		Utility.waitForWebElement(driver, logoutText).click();

	}

}
