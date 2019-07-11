package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		   // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");
        

        String projectPath = System.getProperty("user.dir");
    	System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
    	driver = new ChromeDriver();
    	
    
    	test1.log(Status.INFO, "Starting test case");
    	driver.get("https://www.google.com/");
    	test1.pass("Navigate to google.com");
    	
    	
    	driver.findElement(By.name("q")).sendKeys("Automation step by step");
    	test1.pass("Enter text in searchbox");
    	
    	
    	driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
    	test1.pass("Pressed keyboard enter key");
    	
    	
    	driver.close();
    	driver.quit();
    	test1.pass("Closed the Browser");   
    	
    	
    	test1.info("Test Completed");
    	
    	
    	// We are run the same test case again, but one line fail
    	ExtentTest test2 = extent.createTest("Google Search Test Two", "this is a test to validate google search functionality");
         

        System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
     	driver = new ChromeDriver();
     	
     
     	test2.log(Status.INFO, "Starting test case");
     	driver.get("https://www.google.com/");
     	test2.pass("Navigate to google.com");
     	
     	
     	driver.findElement(By.name("q")).sendKeys("Automation step by step");
     	test2.pass("Enter text in searchbox");
     	
     	
     	driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
     	test2.fail("Pressed keyboard enter key");
     	
     	
     	driver.close();
     	driver.quit();
     	test2.pass("Closed the Browser");   
     	
     	
     	test2.info("Test Completed");
    	
    	// calling flush writes everything to the log file
    	extent.flush();
    	
    	
    	
	}

}
