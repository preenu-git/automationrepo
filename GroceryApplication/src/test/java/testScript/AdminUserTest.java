package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage homePage;
	AdminUserPage adminUserPage;
	@Test(description="verify User Is Able To Add NewUser")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException
	{
		
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homePage=loginPage.clickOnSignInkButton();
		adminUserPage=homePage.clickOnMoreInfo().clickOnNewButton();
		FakerUtility utility=new FakerUtility();
		String addUserName=utility.createRandomUserName();
		String addPassword=utility.createRandomPassword();
		adminUserPage.enterUsernameOnUsernameFields(addUserName).enterPasswordOnPasswordFields(addPassword).selectTypeOnTypeField().clickOnSaveButton();
		boolean isAdminUserDisplayed=adminUserPage.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.AddUserErrorMessage);
	}
	@Test(description="verify User Is Able Search newly added user")
		public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException
		{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homePage=loginPage.clickOnSignInkButton();
		adminUserPage=homePage.clickOnMoreInfo().clickOnSearchButton();
		String UserNames=ExcelUtility.getStringData(0, 0, "AdminUser");
		adminUserPage=adminUserPage.enterUserNameOnUserNameField(UserNames).selectType().clickOnSearchButton2();
		boolean isAdminUserDisplayed=adminUserPage.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.SearchErrorMessage);
		
		}
	@Test(description="verify User Is Able To Reset")
	public void verifyWhetherUserIsAbleToReset() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password).clickOnSignInkButton();
	
		adminUserPage=homePage.clickOnMoreInfo().clickOnResetButton();
		boolean isAdminUserDisplayed=adminUserPage.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.ResetErrorMessage);
	}
		
	}
	    





