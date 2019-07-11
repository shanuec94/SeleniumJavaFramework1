package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {


	public static void main(String[] args) throws InterruptedException {
		test();
	}


	public static void test() throws InterruptedException {

		String projectpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/geckodriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();



		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Abcd");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).sendKeys(Keys.RETURN);

		//driver.findElement(By.linkText("ABCD kids - Apps on Google Play")).click();



		// Waiting 30 seconds for an element to be present on the page, checking		// FluentWait goto Seleniumhq api wensite and click on overview search fluent wait
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("ABCD kids - Apps on Google Play"));

				if(linkElement.isEnabled()) {
					System.out.println(" Element Found");
				}
				return linkElement;

			}

		});


		element.click();



		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
