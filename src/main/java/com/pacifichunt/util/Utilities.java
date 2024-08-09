package com.pacifichunt.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.pacifichunt.base.BaseClass;
 
 
public class Utilities extends BaseClass{
 
	public static long IMPLICIT_WAIT_TIME = 10;
	public static long EXPLICIT_WAIT_TIME = 15;
	public static final long QUICK_THREAD_WAIT_TIME = 2000;
	public static String chrome = "chrome";
	public static String firefox = "firefox";
	public static String RUNNING_ON_CHROME = "\n" + "== RUNNING ON CHROME BROWSER ==" + "\n";
	public static String RUNNING_ON_FIREFOX = "\n" + "== RUNNING ON FIREFOX BROWSER ==" + "\n";
	public static String CLOSNG_BROWSER_SESSION = "\n" + "== BROWSER CLOSED SUCCESSFULLY ==" + "\n";
	public static final String TEST_PASSED = "\n" + "=== Your Test has been Passed Successfully ===" + "\n";
	public static final String INVALID_BROWSER_NAME= "\n" + "Invalid Browser Selection! Chosen Browser => ";
	public static final String RUNNING_AS_DEFAULT_BROWSER = "\n" + "Setting & Running Default Browser As: Google Chrome" + "\n" + "Next time, Please Check your browser name before running the test."+ "\n";
	private static String configPropertiesPath = "./src/main/java/configs/config.properties";
	private static Properties prop;
	private static FileInputStream globalConfig;
	public static String browserName;
	public static WebDriverWait wait;
	private static String BASE_URL;
	public static final int HIGH_PRIORITY = 1;
	public static final int MEDIUM_PRIORITY = 2;
	public static final int VERY_HIGH_PRIORITY = 0;
	public static final int CRITICAL_PRIORITY = -1;
	public static final int LOW_PRIORITY = 3;
	public static final String HIGH_PRIORITY_STATEMET = "\n" + "== EXECUTING HIGH PRIORITY TEST ==";
	public static final String MEDIUM_PRIORITY_STATEMENT = "\n" + "== EXECUTING MEDIUM PRIORITY TEST ==";
	public static final String VERY_HIGH_PRIORITY_STATEMENT = "\n" + "== EXECUTING VERY HIGH PRIORITY TEST ==";
	public static final String CRITICAL_PRIORITY_STATEMENT = "\n" + "== EXECUTING CRITICAL PRIORITY TEST ==";
	public static final String LOW_PRIORITY_STATEMENT = "\n" + "== EXECUTING LOW PRIORITY TEST ==";
 
 
 
	public static void getPropertiesFileConfiguration() {
 
		prop = new Properties();
 
		try {		
			globalConfig = new FileInputStream(configPropertiesPath);
			prop.load(globalConfig);
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		}
 
		catch (IOException e) {
 
			e.printStackTrace();
		}
 
 
	}
 
	public static String getBrowserName() {
 
		getPropertiesFileConfiguration();
		browserName = prop.getProperty("browser");
		return browserName;
 
	}
 
	public static String getBaseUrl() {
 
		getPropertiesFileConfiguration();
		BASE_URL = prop.getProperty("baseurl");
		return BASE_URL;
	}
 
 
	public static void quickWait() throws InterruptedException {
 
		Thread.sleep(QUICK_THREAD_WAIT_TIME);
	}
 
	public static WebDriverWait explicitWaitForElementInitialize() {
 
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME));
		return wait;
	}
 
	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./src/test/resources"+ "/screenshots/" + System.currentTimeMillis() + ".png");
		FileHandler.copy(source, destination);
	}
 
}
