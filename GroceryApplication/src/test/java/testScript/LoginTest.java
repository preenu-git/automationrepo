package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import automationCore.Base;
import constants.Constant;
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
		Assert.assertTrue(isDashBoardDisplayed,Constant.ValidCredentialsErrorMessage);
		
		
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
		Assert.assertEquals(actual, expected,Constant.InvalidUserNameErrorMessage);
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
		Assert.assertTrue(issignInToStartYourSession,Constant.InvalidPasswordErrorMessage);
	}
	@Test(priority=4,description="verifying login with invalid username and invalid password",groups= {"smoke"},dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidUserNameInvalidPassword(String userName,String password ) throws IOException 
	{
		//String userName=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		boolean issignInToStartYourSession=loginPage.signInToStartYourSessionDisplayed();
		Assert.assertTrue(issignInToStartYourSession,Constant.InvalidCredentialsErrorMessage);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	

}
}

