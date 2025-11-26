package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homePage;
	@Test(description="verify successsfully logout by the user",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homePage=loginPage.clickOnSignInkButton();
        homePage.clickOnAdminField();
		loginPage=homePage.clickOnLogOutButton();
		//homePage.clickOnMoreInfo();
		//homePage.clickOnMoreField1();
		boolean isHomePageDisplayed=homePage.threeLinesDisplayed();
		Assert.assertTrue(isHomePageDisplayed,Constant.LogOutErrorMessage);
		
	}
	
}
