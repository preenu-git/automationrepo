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
	@Test(description="verify User Is Able To AddNewNews")
	public void verifyWhetherTheUserIsAbleToAddNewNews() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreField1();
		ManageNewsPage newsPage=new ManageNewsPage(driver);
		newsPage.clickOnNewField1();
		String news=ExcelUtility.getStringData(0, 0, "ManageNews");
		newsPage.enterNewsOnNewsField(news);
		newsPage.clickOnSaveButton();
		boolean isNewsPageDisplayed=newsPage.alertMsgDisplayed();
		Assert.assertTrue(isNewsPageDisplayed,Constant.AddNewsErrorMessage);
		
	}
	@Test(description="verify User Is Able To Search")
	public void verifyWhetherUserIsAbleToSearch() throws IOException
	{
		String userName=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInkButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMoreField1();
		ManageNewsPage newsPage=new ManageNewsPage(driver);
		newsPage.clickOnSearchButton();
		String news=ExcelUtility.getStringData(0, 0, "ManageNews");
		newsPage.enterNewsOnSearchField(news);
		newsPage.clickOnSearchButton1();
		boolean isDashBoardDisplayed=loginPage.dashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,Constant.SearchNewsErrorMessage);
	}
		
	}

