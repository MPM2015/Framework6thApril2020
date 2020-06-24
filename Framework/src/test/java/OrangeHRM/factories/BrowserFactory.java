package OrangeHRM.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import OrangeHRM.helper.HubDetails;

public class BrowserFactory {
	
	public static void closeApplication(WebDriver driver) {
		driver.quit();
		System.out.println("LOG-INFO: Session Closed");
	}
	
	
	public static WebDriver startApplicationUsingGrid(String os,String os_version,String browser,String browser_version,String applicationURL)
	{
		URL hub = null;
			
		try {
			hub = new URL("http://"+ObjectProviderFactory.getConfig().getValue("username")+":"
								+ObjectProviderFactory.getConfig().getValue("accesskey")+"@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("URL is Malformed"+e.getMessage());
			
		}
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("os",os);
		caps.setCapability("os_version",os_version);
		caps.setCapability("browser",browser);
		caps.setCapability("browser_version",browser_version);		
		WebDriver driver = new RemoteWebDriver(hub, caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;		
		
		
	}
	
	public static WebDriver startApplicationUsingGridNew(String Platform,String PlatformVersion,String browser,String browserVersion )
	{
		URL hub = null;
		String uname=HubDetails.username;
		String key=HubDetails.accesskey;
		
		try {
			hub = new URL("http://"+uname+":"+key+"@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("URL is Malformed"+e.getMessage());
			
		}
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("os",Platform);
		caps.setCapability("os_version",PlatformVersion);
		caps.setCapability("browser",browser);
		caps.setCapability("browser_version",browserVersion);		
		WebDriver driver = new RemoteWebDriver(hub, caps);
		
		
		return driver;
	}
	
	public static WebDriver startMobileApplicationUsingGrid(String device,String os_version)
	{
		URL hub = null;
		try {
			hub = new URL("http://"+ObjectProviderFactory.getConfig().getValue("username")+":"
								+ObjectProviderFactory.getConfig().getValue("accesskey")+"@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("URL is Malformed"+e.getMessage());
			
		}
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("device",device);
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version",os_version);				
		WebDriver driver = new RemoteWebDriver(hub, caps);
		return driver;
	}
	
	public static WebDriver getApplication(String browser,String appURL) {
		
	WebDriver driver = null;
	
		/*ChromeOptions opt=new ChromeOptions();
		opt.setHeadless(true);
		
		FirefoxOptions optFF=new FirefoxOptions();
		optFF.setHeadless(true);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver(opt);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver =new FirefoxDriver(optFF);
			
		}*/
		
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver =new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("IEDriver"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			driver.quit();
			
			
		}
		else
		{
			System.out.println("Sorry we dont support this browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
		
	}

}
