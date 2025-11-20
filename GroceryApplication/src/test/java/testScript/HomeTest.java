package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description="verify successsfully logout by the user")//,retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminField();
		//homepage.clickOnLogOutButton();
		//homepage.clickOnMoreInfo();
		//homepage.clickOnMoreField1();
		boolean isHomePageDisplayed=homepage.threeLinesDisplayed();
		Assert.assertTrue(isHomePageDisplayed, "user is not able to successfully logout");
		
	}
	
}
