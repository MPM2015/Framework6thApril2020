package OrangeHRM.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridExampleUsingAndroid {
	
	
	@Test
	public void testonAndroid() throws MalformedURLException {
		
		
		URL hub=new URL("http://jenkinsgit1:Z65NZrsyD79prKAJNHai@hub-cloud.browserstack.com/wd/hub");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("browsername", "android");
		caps.setCapability("device", "Samsung Galaxy S10 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "9.0");
		caps.setCapability("name", "Selenium Grid Example using Android");
		caps.setCapability("browserstack.debug", "true");
		
		WebDriver driver = new RemoteWebDriver(hub, caps);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium By Mukesh Otwani");
		driver.quit();
		
		
	}

}
