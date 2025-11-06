package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(css="input[type=\'text\']") WebElement userNameField;
	//name='username'
	@FindBy(css="input[type=\'password\']") WebElement passwordField;
	//name='password
	@FindBy(css = "button[type='submit']") WebElement signInField;
	//xpath="//button[text()=\"SignIn\"]"

public void enterUsernameOnUsernameField(String userName)
{
	userNameField.sendKeys(userName);
}
public void enterPasswordOnPasswordField(String password)
{
	passwordField.sendKeys(password);
}
public void clickOnSignInkButton()
{
	signInField.click();
}
}
