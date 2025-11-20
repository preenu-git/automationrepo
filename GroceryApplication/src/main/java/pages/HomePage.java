package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class HomePage  {
		public WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "//li[@class='nav-item dropdown']") WebElement adminField;
		//@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']") WebElement logOutField;
	  @FindBy(linkText = "More info")WebElement moreInfoField;
     @FindBy(xpath = "//p[text()='Manage News']")WebElement moreInfoField1;
	@FindBy(xpath = "//i[@class='fas fa-bars']")WebElement threeLines;
		
		
		
		
		public void clickOnAdminField()
		{
		adminField.click();
		}
		/*public void clickOnLogOutButton()
		{
			logOutField.click();
		}*/
		public void clickOnMoreInfo()
		{
			moreInfoField.click();
		}
		public void clickOnMoreField1()
		{
			moreInfoField1.click();
		}
		public boolean threeLinesDisplayed()
		{
			return threeLines.isDisplayed();
		}
}
