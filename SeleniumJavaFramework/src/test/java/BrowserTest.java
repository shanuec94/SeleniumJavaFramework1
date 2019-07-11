import java.util.IdentityHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserTest {

	public static void main(String[] args) {
		
	    String projectpath=System.getProperty("user.dir");
	    
	    System.out.println("Project Path:"+projectpath);   //C:\Users\Prakat-TempUser\Downloads\java Softwares\oxygenWorkSpace\SeleniumJavaFramework\drivers\geckodriver\chromedriver.exe
	    													//(right click on chromedriver.exe and goto properties and found the path)
	    
	    
	    // System.setProperty("webdriver.gecko.driver", projectpath+"/drivers/geckodriver/geckodriver.exe");
	    // WebDriver driver = new FirefoxDriver();
	    
	    
	   // System.setProperty("webdriver.ie.driver", "C:\\Users\\Prakat-TempUser\\Downloads\\java Softwares\\oxygenWorkSpace\\SeleniumJavaFramework\\drivers\\geckodriver\\IEDriverServer.exe");
	   // WebDriver driver = new InternetExplorerDriver();
	    
	
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/geckodriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://google.com/");
		
		
		//driver.findElement(By.name("q")).sendKeys("Automation step by step");                    // 1 way find the google text box and pass thye value
		

		// WebElement textbox = driver.findElement(By.name("q"));                                 // 2 way
		
		// textbox.sendKeys("Automation step by step");
		 
		
		 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");    // 3 way
		
		
		 List<WebElement> ListOfInputElement = driver.findElements(By.xpath("//input"));    // find the Number of input elements in the google page
		  
		 int count = ListOfInputElement.size();
		 
		 System.out.println("count of Input elements:" +count);
		
		
		
		
		
		
		driver.close();

	}

}
 