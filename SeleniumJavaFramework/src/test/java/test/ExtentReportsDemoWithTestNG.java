package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	
	  @BeforeTest
		public void setUpTest() throws InterruptedException{
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
	
	
	  @Test	
	    public void test1() throws IOException {
		ExtentTest test = extent.createTest("My First Test" , "Sample Description ");
		
		driver.get("https://www.google.com/");
		test.pass("Navigate to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info (details)");
		test.fail("details" , MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	  
	
		@Test
		public void test2() throws IOException {
			ExtentTest test = extent.createTest("My Second Test" , "Sample Description ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");
			test.info("This step shows usage of info (details)");
			test.pass("details" , MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
	}
		
		
		
		@AfterTest
		 public void tearDownTest() {
		//close the browser
		driver.close();
		driver.quit();
	    System.out.println("Test Completed successfully");
	}

	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		
		
	}
}
