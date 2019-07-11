package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectpath = System.getProperty("user.dir");


	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("browserName: " +browserName);
		System.out.println("thread id :" +Thread.currentThread().getId());

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/geckodriver/chromedriver.exe");
			driver = new ChromeDriver();
		}	


		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Prakat-TempUser\\Downloads\\java Softwares\\oxygenWorkSpace\\SeleniumJavaFramework\\drivers\\geckodriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}




	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	}



	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed Successfully");
	}


}
