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

public class ManageNewsTest extends Base {
	HomePage homePage;
	ManageNewsPage manageNewsPage;
	@Test(description="verify User Is Able To AddNewNews")
	public void verifyWhetherTheUserIsAbleToAddNewNews() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homePage=loginPage.clickOnSignInkButton();
		manageNewsPage=homePage.clickOnMoreField1().clickOnNewField1();
		String news=ExcelUtility.getStringData(0, 0, "ManageNews");
		manageNewsPage.enterNewsOnNewsField(news).clickOnSaveButton();
		boolean isNewsPageDisplayed=manageNewsPage.alertMsgDisplayed();
		Assert.assertTrue(isNewsPageDisplayed,Constant.AddNewsErrorMessage);
		
	}
	@Test(description="verify User Is Able To Search")
	public void verifyWhetherUserIsAbleToSearch() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		homePage=loginPage.clickOnSignInkButton();
		manageNewsPage=homePage.clickOnMoreField1();
		manageNewsPage=manageNewsPage.clickOnSearchButton();
		String news=ExcelUtility.getStringData(0, 0, "ManageNews");
		manageNewsPage=manageNewsPage.enterNewsOnSearchField(news).clickOnSearchButton1();
		boolean isDashBoardDisplayed=loginPage.dashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,Constant.SearchNewsErrorMessage);
	}
		
	}

