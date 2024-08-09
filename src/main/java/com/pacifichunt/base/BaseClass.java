package com.pacifichunt.base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
import com.pacifichunt.util.Utilities;
 
 
 
public class BaseClass {
 
	public static WebDriver driver;
	public static WebDriver eventDriver;
	//public static WebEventListener listener;
	//public static EventFiringDecorator<WebDriver> decorator;
 
	@BeforeMethod
	public void setUp() {
		
		
		Utilities.getPropertiesFileConfiguration();
 
		String propertiesValueOfBrowserName = Utilities.getBrowserName();
 
		if(propertiesValueOfBrowserName.equals(Utilities.chrome)) {
 
			Reporter.log(Utilities.RUNNING_ON_CHROME, true);
 
			driver = new ChromeDriver();
			
			
		}else if(propertiesValueOfBrowserName.equals(Utilities.firefox)) {
 
			Reporter.log(Utilities.RUNNING_ON_FIREFOX, true);
 
			driver = new FirefoxDriver();
			
 
		}else {
 
			Reporter.log(Utilities.INVALID_BROWSER_NAME + propertiesValueOfBrowserName + Utilities.RUNNING_AS_DEFAULT_BROWSER, true );
			driver = new ChromeDriver();
			
		}
		
		//callEventListenerWebDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		
		
		driver.get(Utilities.getBaseUrl());
 
	}
 
 
	
	/*
	 * public static WebDriver callEventListenerWebDriver() {
	 *
	 * listener = new WebEventListener(); decorator = new
	 * EventFiringDecorator<WebDriver>(listener); eventDriver =
	 * decorator.decorate(driver); driver = eventDriver; return driver; }
	 *
	 */
 
	@AfterMethod
	public void tearDown() {
 
		//Reporter.log(Utilities.CLOSNG_BROWSER_SESSION, true);
		driver.quit();
	}
 
 
 
}


