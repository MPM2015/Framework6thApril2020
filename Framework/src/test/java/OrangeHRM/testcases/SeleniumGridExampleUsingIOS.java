package OrangeHRM.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridExampleUsingIOS {
	
	
	@Test
	public void testonIOS() throws MalformedURLException {
		
		
		URL hub=new URL("http://jenkinsgit1:Z65NZrsyD79prKAJNHai@hub-cloud.browserstack.com/wd/hub");
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability("device", "iPhone XS");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "13");
		caps.setCapability("name", "Selenium Grid Example using IOS");
		caps.setCapability("browserstack.debug", "false");
		caps.setCapability("browserstack.local", "false");
		
		WebDriver driver = new RemoteWebDriver(hub, caps);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium By Mukesh Otwani");
		driver.quit();
		
		
	}

}
