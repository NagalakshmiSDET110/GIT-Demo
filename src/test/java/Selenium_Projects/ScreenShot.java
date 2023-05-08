package Selenium_Projects;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void takeScreenShot(String stepName) throws IOException, HeadlessException, AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("See an example alert")).click();
		
		try {
			
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcfile =screenshot.getScreenshotAs(OutputType.FILE);
		
		String TCName = "TestCase_001";
		String dir = System.getProperty("user.dir");
		
		String path = dir+"/src/test/resources/ScreenShots/TCName/Alert.jpeg";
		
		File destfile = new File(path);
		FileUtils.copyFile(srcfile, destfile);
		
		}
		
		catch(Exception e){
			
			BufferedImage AlertScreenshot = new Robot().createScreenCapture
											(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			String TCName = "TestCase_001";
			String dir = System.getProperty("user.dir");
			
			String path = dir+"/src/test/resources/ScreenShots/TCName/Alert.jpeg";			
			ImageIO.write(AlertScreenshot, "png", new File(path));
			
		}
		}
	
	public static void main(String[] args) throws IOException, HeadlessException, AWTException, InterruptedException {
		
		takeScreenShot("Alert");
	}
	}

