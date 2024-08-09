package com.pacifichunt.tests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
 
import com.pacifichunt.base.BaseClass;
import com.pacifichunt.pages.LoginPage;
import com.pacifichunt.util.Utilities;
import com.pacifichunt.userstories.UserStories;
 
 
public class LoginAsEmployerTest extends BaseClass{
 
 
	@Test(priority = Utilities.VERY_HIGH_PRIORITY, enabled = true, description = UserStories.REQUIREMENT_TYPE  + UserStories.VALID_LOGIN_SCENARIO  + UserStories.VALID_LOGIN_STATEMENT )
	public void verifyValidLoginAsEmployer() {
 
		Reporter.log(Utilities.VERY_HIGH_PRIORITY_STATEMENT, true);
 
		LoginPage login = new LoginPage(driver);
		login.goToHeaderLoginBtn();
		login.goToLoginAsEmployer();
		login.setValidCredentials();
		login.clickLoginButton();
		Assert.assertEquals(LoginPage.getDashboardText(), LoginPage.getExpectedDashboardText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}
 
	@Test(priority = Utilities.MEDIUM_PRIORITY,enabled = true, description = UserStories.REQUIREMENT_TYPE + UserStories.EMPTY_LOGIN_SCENERIO + UserStories.EMPTY_LOGIN_STATEMENT)
	public void verifyEmptyUsernameAndEmptyPassword() {
 
		Reporter.log(Utilities.MEDIUM_PRIORITY_STATEMENT, true);
 
		LoginPage login = new LoginPage(driver);
		login.goToHeaderLoginBtn();
		login.goToLoginAsEmployer();
		login.setEmptyUserNameAndEmptyPasswordCredentials();
		login.clickLoginButton();
		Assert.assertEquals(login.getEmptyEmailText(), login.getExpectedEmptyEmailText());
		Reporter.log(Utilities.TEST_PASSED, true);
	}
 
}
 
