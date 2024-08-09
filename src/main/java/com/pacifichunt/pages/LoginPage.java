package com.pacifichunt.pages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
import com.pacifichunt.base.BaseClass;
 
 
public class LoginPage extends BaseClass{
 
	WebDriver driver;
	Properties prop;
	FileInputStream credentials;
	private static String secretsPropertiesPath = "./src/main/java/configs/secrets.properties";
	private static final String expectedInvalidEmailText = "Invalid Email";
	private static final String expectedEmptyEmailText = "Email is required";
	private static final String expectedDashboardText = "Dashboard";
 
	@FindBy(name="email")
	private WebElement emailId;
 
	@FindBy(name="password")
	private WebElement password;
 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
 
	@FindBy(xpath="//span[.='Your Trusted Career Partner']")
	private WebElement header;
 
	@FindBy(xpath="//button[.='Login']")
	@CacheLookup
	private WebElement headerLoginBtn;
 
	@FindBy(xpath="//button[.='LOGIN AS EMPLOYER']")
	private WebElement loginAsEmployer;
 
	@FindBy(xpath="//p[contains(.,'Invalid email')]")
	private WebElement invalidEmailText;
 
	@FindBy(xpath="//p[.='Email is required']")
	private WebElement emptyEmailText;
	
	@FindBy(xpath = "//li[.='Dashboard']")
	private static WebElement dashboardTxt;
 
 
 
	public LoginPage(WebDriver driver) {
 
		PageFactory.initElements(driver, this);
	}
 
 
	public void initializeCredentials() {
 
		prop = new Properties();
 
		try {
			credentials = new FileInputStream(secretsPropertiesPath);
			prop.load(credentials);
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
 
		} catch (IOException e) {
 
			e.printStackTrace();
		}
 
	}
 
 
	public String getLoginPageTitle() {
 
 
		return driver.getTitle();
 
	}
 
 
	public void goToHeaderLoginBtn() {
 
		headerLoginBtn.click();
	}
 
	public void goToLoginAsEmployer() {
 
		loginAsEmployer.click();
	}	
 
 
	public String getEmail() {
 
		initializeCredentials();
 
		return prop.getProperty("email");
	}
 
	public String getPassword() {
 
		initializeCredentials();
 
		return prop.getProperty("password");
	}
 
	public void clickLoginButton() {
 
		loginBtn.click();
	}
 
 
 
	public void setValidCredentials() {
 
 
		emailId.sendKeys(getEmail());
		password.sendKeys(getPassword());
	}
 
	public void setEmptyUserNameAndEmptyPasswordCredentials() {
 
		emailId.sendKeys("");
		password.sendKeys("");
	}
 
	public String getInvalidEmailText() {
 
		return invalidEmailText.getText();
	}
 
	public String getExpectedInvalidEmailText() {
 
		return expectedInvalidEmailText;
	}
 
	public String getEmptyEmailText() {
 
		return emptyEmailText.getText();
	}
 
	public String getExpectedEmptyEmailText() {
 
		return expectedEmptyEmailText;
	}
 
	public WebElement getInvalidEmailLocator() {
 
		return invalidEmailText;
	}
	
	public static String getDashboardText() {
		
		return dashboardTxt.getText();
	}
	
	public static String getExpectedDashboardText() {
		
		return expectedDashboardText;
	}
 
}