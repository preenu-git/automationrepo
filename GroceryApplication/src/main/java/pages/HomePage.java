package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

	public class HomePage  {
		public WebDriver driver;
		WaitUtility waitutility=new WaitUtility();
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "//li[@class='nav-item dropdown']") WebElement adminField;
		@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']") WebElement logOutField;
	  @FindBy(linkText = "More info")WebElement moreInfoField;
     @FindBy(xpath = "//p[text()='Manage News']")WebElement moreInfoField1;
	@FindBy(xpath = "//i[@class='fas fa-bars']")WebElement threeLines;
		
		
		
		
		public HomePage clickOnAdminField()
		{
		waitutility.waitUntilElementToBeClickable(driver, adminField);
		adminField.click();
		return this;
		}
		public LoginPage clickOnLogOutButton()
		{
			logOutField.click();
			return new LoginPage(driver);
		}
		public AdminUserPage clickOnMoreInfo()
		{
			moreInfoField.click();
			return new AdminUserPage(driver);
		}
		public ManageNewsPage clickOnMoreField1()
		{
			moreInfoField1.click();
			return new ManageNewsPage(driver);
		}
		public boolean threeLinesDisplayed()
		{
			return threeLines.isDisplayed();
		}
}
