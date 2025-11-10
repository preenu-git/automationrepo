package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


	public class AdminUserPage  {
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
		
		//new user
		
		public void clickOnNewButton()
		{
			newField.click();
		}
		public void enterUsernameOnUsernameFields(String addUserName)
		{
			userName.sendKeys(addUserName);
		}
		public void enterPasswordOnPasswordFields(String addPassword)
		{
			password.sendKeys(addPassword);
		}
		public void selectTypeOnTypeField()
		{
			Select select=new Select(type);
			select.selectByVisibleText("Staff");
		}
		public void clickOnSaveButton()
		{
			saveField.click();
		}
		
		//search
		
		public void clickOnSearchButton()
		{
			searchField.click();
		}
		public void enterUserNameOnUserNameField(String name)
		{
			userNameField1.sendKeys(name);
		}
		public void selectType()
		{
			Select select=new Select(usertype2);
			select.selectByVisibleText("Staff");
		}
		public void clickOnSearchButton2()
		{
		search.click();	
		}
		
		// reset
		
		public void clickOnResetButton()
		{
			resetField.click();
		}
		

}
