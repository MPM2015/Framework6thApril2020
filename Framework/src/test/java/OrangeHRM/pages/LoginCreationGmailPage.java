package OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OrangeHRM.helper.Utility;

public class LoginCreationGmailPage {
	
	WebDriver driver;

	public LoginCreationGmailPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	By firstname = By.id("firstName");
	By lastname = By.id("lastName");
	By username = By.id("username");
	By passwd = By.name("Passwd");
	By confirmPasswd = By.name("ConfirmPasswd");
	By nextbutton = By.id("accountDetailsNext");
	By month = By.id("lastName");
	
	
	public void logincreation(String FN,String LN,String UN,String PW,String CPW) {

		Utility.waitForWebElement(driver, firstname).sendKeys(FN);
		Utility.waitForWebElement(driver, lastname).sendKeys(LN);
		Utility.waitForWebElement(driver, username).sendKeys(UN);
		Utility.waitForWebElement(driver, passwd).sendKeys(PW);
		Utility.waitForWebElement(driver, confirmPasswd).sendKeys(CPW);
		Utility.waitForWebElement(driver, nextbutton).click();
		Utility.selectDropdown(Utility.waitForWebElement(driver, month),"test");

	}

}
