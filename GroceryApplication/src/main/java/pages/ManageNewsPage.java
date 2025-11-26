package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(id="news")WebElement newsField;
	@FindBy(name="create")WebElement saveField1;
	@FindBy(xpath = "//i[@class=' fa fa-search']")WebElement searchbutton;
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement searchField;
	@FindBy(name="Search")WebElement searchButton1;
	//@FindBy(xpath = "//h3[text()='Enter News Informations']")WebElement enterNewsInformation;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")WebElement alert;
	
	public ManageNewsPage clickOnNewField1()
	{
		newbutton.click();
		return this;
	}
	public ManageNewsPage enterNewsOnNewsField(String news) {
		newsField.sendKeys(news);
		return this;
	}
   public ManageNewsPage clickOnSaveButton()
   {
	   saveField1.click();
	   return this;
   }
   public ManageNewsPage clickOnSearchButton()
   {
	   searchbutton.click();
	   return this;
   }
   public ManageNewsPage enterNewsOnSearchField(String news)
   {
	   searchField.sendKeys(news);
	   return this;
    }
   public ManageNewsPage clickOnSearchButton1()
   {
	   searchButton1.click();
	   return this;
   }
   public boolean alertMsgDisplayed()
   {
	 return alert.isDisplayed();
   }
}
