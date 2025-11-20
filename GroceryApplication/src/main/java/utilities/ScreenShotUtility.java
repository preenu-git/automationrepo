package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException { 
		  
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot=predefined interface   ,  (TakesScreenShot)=casting
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); 
  
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //timeformat=differentiate with mins,hour and second...mostly using seconds
  
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory 
 		if (!f1.exists()) { 
  
 			f1.mkdirs(); 
 		} 
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp //outputScreenshot=screenshot stored in this folder in .png file.
 				+ ".png"; 
 		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp + 
 		// ".png"; 
  
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination); 
 	}
}


