package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;


	public class AdminUserPage  {
		PageUtility pageutility=new PageUtility();
		public WebDriver driver;
		
		//constructor
		
		public AdminUserPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
		//find elements
		
		@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newField;
		@FindBy(xpath = "//button[@name='Create']")WebElement saveField;
		@FindBy(xpath = "//input[@name='username']")WebElement userName;
		@FindBy(xpath = "//input[@name='password']")WebElement password;
		@FindBy(id="user_type")WebElement type;
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement searchField;
		@FindBy(id="un")WebElement userNameField1;
		@FindBy(xpath = "//select[@name='ut']")WebElement usertype2;
		@FindBy(xpath = "//button[@value='sr']")WebElement search;
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement resetField;
		@FindBy(xpath = "//h3[text()='Admin Users Informations']")WebElement adminUserInformation;
		
		//new user
		
		public AdminUserPage clickOnNewButton()
		{
			newField.click();
			return this;
		}
		public AdminUserPage enterUsernameOnUsernameFields(String addUserName)
		{
			userName.sendKeys(addUserName);
			return this;
		}
		public AdminUserPage enterPasswordOnPasswordFields(String addPassword)
		{
			password.sendKeys(addPassword);
			return this;
		}
		public AdminUserPage selectTypeOnTypeField()
		{
			pageutility.selectDropdownWithVisibleText(type,Constant.dropDown);
			//Select select=new Select(type);
			//select.selectByVisibleText("Staff");
			return this;
		}
		public AdminUserPage clickOnSaveButton()
		{
			saveField.click();
			return this;
			
		}
		
		//search
		
		public AdminUserPage clickOnSearchButton()
		{
			searchField.click();
			return this;
		}
		public AdminUserPage enterUserNameOnUserNameField(String name)
		{
			userNameField1.sendKeys(name);
			return this;
		}
		public AdminUserPage selectType()
		{
			Select select=new Select(usertype2);
			select.selectByVisibleText("Staff");
			return this;
		}
		public AdminUserPage clickOnSearchButton2()
		{
		search.click();	
		return this;
		}
		
		// reset
		
		public AdminUserPage clickOnResetButton()
		{
			resetField.click();
			return this;
		}
		public boolean adminUserInformationDisplayed()
		{
			return adminUserInformation.isDisplayed();
		}
		

}
