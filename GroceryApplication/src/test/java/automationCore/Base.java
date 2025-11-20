package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;

public class Base {
	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws Exception {
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
			else if(browsers.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
		}
			else if(browsers.equalsIgnoreCase("Edge"))
			{
				driver=new EdgeDriver();
				
			}
			else {
				throw new Exception("invalid browser");
			}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait code
		
	}
	//@AfterMethod
	//public void driverCloseAndQuit()
	//{
		//driver.close();//closing last window
		//driver.quit();//close all windows
		
	//}
	
	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException { //ITestResult=interface,it shows result status
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { //if testcase fails,it creates objects
  
 		ScreenShotUtility screenShot = new ScreenShotUtility(); //creates object
 			screenShot.getScreenshot(driver, iTestResult.getName()); //takes screenshot
 		} 
 		driver.quit(); 
  
 	}



}
