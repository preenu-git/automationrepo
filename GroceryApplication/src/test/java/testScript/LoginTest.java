package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	@Test(priority=1,description="verifying successfull login with valid credentials",groups= {"smoke"} )
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		boolean isDashBoardDisplayed=loginPage.dashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, "user is not able to login with valid credentials");
		
		
	}
	@Test(priority=2,description="verifying login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUserNameValidPassword() throws IOException 
	{
		String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		String actual=loginPage.getPagetitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"user is able to login with invalid username");
	}
	@Test(priority=3,description="verifying login with valid username and invalid password")
	public void verifyUserLoginWithValidUserNameInvalidPassword() throws IOException 
	{
		String userName=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		boolean issignInToStartYourSession=loginPage.signInToStartYourSessionDisplayed();
		Assert.assertTrue(issignInToStartYourSession, "user is  able to login with valid username and invalid password");
	}
	@Test(priority=4,description="verifying login with invalid username and invalid password",groups= {"smoke"})
	public void verifyUserLoginWithInvalidUserNameInvalidPassword() throws IOException 
	{
		String userName=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		boolean issignInToStartYourSession=loginPage.signInToStartYourSessionDisplayed();
		Assert.assertTrue(issignInToStartYourSession, "user is able to login with invalid username and invalid password");
	}
	

}

