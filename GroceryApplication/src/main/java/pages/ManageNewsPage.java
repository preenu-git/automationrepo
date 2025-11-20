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
	
	public void clickOnNewField1()
	{
		newbutton.click();
	}
	public void enterNewsOnNewsField(String news) {
		newsField.sendKeys(news);
	}
   public void clickOnSaveButton()
   {
	   saveField1.click();
   }
   public void clickOnSearchButton()
   {
	   searchbutton.click();
   }
   public void enterNewsOnSearchField(String news)
   {
	   searchField.sendKeys(news);
    }
   public void clickOnSearchButton1()
   {
	   searchButton1.click();
   }
   public boolean alertMsgDisplayed()
   {
	 return alert.isDisplayed();
   }
}
