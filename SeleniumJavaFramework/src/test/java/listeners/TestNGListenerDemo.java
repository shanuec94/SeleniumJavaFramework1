package listeners;

import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo {


	@Test
	public void test1() {
		System.out.println("I am Inside test1");
	}


	@Test
	public void test2() {
		System.out.println("I am Inside test2");                     //test the selenium code here 


		String projectpath=System.getProperty("user.dir");
		System.out.println("Project Path:"+projectpath);


		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/geckodriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		driver.get("http://google.com/");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");                                       // correct
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("Automation step by step"); 									// not correct

	}


	@Test
	public void test3() {
		System.out.println("I am Inside test3");
		throw new SkipException("this test is skipped");
	}

}
