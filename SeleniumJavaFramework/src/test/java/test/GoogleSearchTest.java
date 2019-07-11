package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pages.GoogleSearchPage;


public class GoogleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}
	
	public static void googleSearch() throws InterruptedException {
	
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
	
	driver = new ChromeDriver();
	
	//goto google.com
	driver.manage().window().maximize();
	driver.get("https://www.google.co.in/?gws_rd=ssl");
	

	
	// enter text in search text box
	//driver.findElement(By.name("q")).sendKeys("Automation Step by step");	
	
	GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by step");
	
	
//	Thread.sleep(2000);
	Actions act = new Actions(driver);
	act.sendKeys(Keys.TAB);
	
	
	
	//click on google search button
	
	//driver.findElement(By.name("btnk")).click();
	
	// driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
	
	GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
	                       
	
	//close the browser
	driver.close();
	
	System.out.println("Test Completed successfully");
	
	
	
	
	}
}
