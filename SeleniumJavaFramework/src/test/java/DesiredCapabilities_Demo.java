import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\Prakat-TempUser\\Downloads\\java Softwares\\oxygenWorkSpace\\SeleniumJavaFramework\\drivers\\geckodriver\\IEDriverServer.exe");
		 
		 WebDriver driver = new InternetExplorerDriver(caps);
		 
		 driver.get("https://www.google.com/");
		
		 driver.findElement(By.name("q")).sendKeys("ABCD");
		 
		 driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);
		 
		 driver.close();
		 driver.quit();
	
		
	}
	
}
