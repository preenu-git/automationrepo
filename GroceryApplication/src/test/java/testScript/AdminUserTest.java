package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	@Test
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
		String addUserName=ExcelUtility.getStringData(4, 0, "LoginPage");
		String addPassword=ExcelUtility.getStringData(4, 1, "LoginPage");
		adminUser.enterUsernameOnUsernameFields(addUserName);
		adminUser.enterPasswordOnPasswordFields(addPassword);
		adminUser.selectTypeOnTypeField();
		adminUser.clickOnSaveButton();
	}
	@Test
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
		String UserNames=ExcelUtility.getStringData(4, 0, "LoginPage");
		adminUser.enterUserNameOnUserNameField(UserNames);
		adminUser.selectType();
		adminUser.clickOnSearchButton2();
		}
	@Test
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
		
	}
	    

}



