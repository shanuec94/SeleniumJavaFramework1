package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	 WebDriver driver = null;



	/*public static void main(String[] args) {

		String excelPath = "C:\\Users\\Prakat-TempUser\\Downloads\\java Softwares\\oxygenWorkSpace\\SeleniumJavaFramework\\excel\\data.xlsx";
		testData(excelPath, "Sheet1");
	}*/

	
	
	 @BeforeTest
		public void setUpTest() {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/geckodriver/chromedriver.exe");	
			driver = new ChromeDriver();
	 }
	

	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username+ " | " +password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}


	
	
	@DataProvider(name = "test1data")
	public static Object[][] getData() {

		String excelPath = "C:\\Users\\Prakat-TempUser\\Downloads\\java Softwares\\oxygenWorkSpace\\SeleniumJavaFramework\\excel\\data.xlsx";
		Object data[][]= testData(excelPath, "Sheet1");        // call the testData function and pass the path and sheet name
		return data;
	}




	public static Object[][] testData(String excelPath, String sheetName) {                       // create the function testData

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int  rowCount = excel.getRowCount();
		int  colCount = excel.getColCount();


		Object data[][] = new Object[rowCount-1][colCount];


		for(int i=1; i<rowCount; i++) {

			for(int j=0; j<colCount; j++)
			{
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + "  ");
				data[i-1][j] = cellData;
			}

			System.out.println();
		}

		return data;

	}



}
