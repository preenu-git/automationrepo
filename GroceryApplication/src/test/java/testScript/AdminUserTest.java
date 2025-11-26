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
	@Test(description="verify User Is Able To Add NewUser")
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException
	{
		
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfo();
		AdminUserPage adminUser=new AdminUserPage(driver);
		adminUser.clickOnNewButton();
		FakerUtility utility=new FakerUtility();
		String addUserName=utility.createRandomUserName();
		String addPassword=utility.createRandomPassword();
		adminUser.enterUsernameOnUsernameFields(addUserName);
		adminUser.enterPasswordOnPasswordFields(addPassword);
		adminUser.selectTypeOnTypeField();
		adminUser.clickOnSaveButton();
		boolean isAdminUserDisplayed=adminUser.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.AddUserErrorMessage);
	}
	@Test(description="verify User Is Able Search newly added user")
		public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException
		{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfo();
	    AdminUserPage adminUser=new AdminUserPage(driver);
		adminUser.clickOnSearchButton();
		String UserNames=ExcelUtility.getStringData(0, 0, "AdminUser");
		adminUser.enterUserNameOnUserNameField(UserNames);
		adminUser.selectType();
		adminUser.clickOnSearchButton2();
		boolean isAdminUserDisplayed=adminUser.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.SearchErrorMessage);
		
		}
	@Test(description="verify User Is Able To Reset")
	public void verifyWhetherUserIsAbleToReset() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreInfo();
		AdminUserPage adminUser=new AdminUserPage(driver);
		adminUser.clickOnResetButton();
		boolean isAdminUserDisplayed=adminUser.adminUserInformationDisplayed();
		Assert.assertFalse(isAdminUserDisplayed,Constant.ResetErrorMessage);
	}
		
	}
	    





