package Selenium_Projects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hello_World {
	
	
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kodai\\eclipse-workspace\\HelloSelenium\\src\\test\\resources\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		
	}

}
