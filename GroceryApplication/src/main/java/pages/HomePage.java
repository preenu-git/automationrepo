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
		@FindBy(xpath ="//i[@class='ace-icon fa fa-power-off']") WebElement logOutField;
		
		
		public void clickOnAdminField()
		{
		adminField.click();
		}
		public void clickOnLogOutButton()
		{
			logOutField.click();
		}
}
