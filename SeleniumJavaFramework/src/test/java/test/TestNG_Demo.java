package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {

	static WebDriver driver = null;
	public static String  browserName = null;


	@BeforeTest
	public void setUpTest() throws InterruptedException{

		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();



		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}


		else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	@Test
	public  void googleSearch()  {


		//goto google.com

		driver.get("https://www.google.co.in/");


		// enter text in search text box
		driver.findElement(By.name("q")).sendKeys("Automation Step by step");	

		//	Thread.sleep(2000);
		//Actions act = new Actions(driver);
		//act.sendKeys(Keys.TAB);



		//click on google search button

		//driver.findElement(By.name("btnk")).click();

		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
	}

	@AfterTest
	public void tearDownTest() {
		//close the browser
		driver.close();
		//driver.quit();
		System.out.println("Test Completed successfully");
		
		PropertiesFile.setProperties();
	



	}
}
