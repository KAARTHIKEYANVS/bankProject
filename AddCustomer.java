package bankProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AddCustomer {
	
	WebDriver driver;
	@DataProvider(name="customer")
	public String[][] customeradd() throws BiffException, IOException
	{
		String[][] data = addcustomer();
		return data;
	}
	public String[][] addcustomer() throws BiffException, IOException
	{
		FileInputStream excel = new FileInputStream("C:\\Users\\SPARTEN\\Desktop\\Book1.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][]= new String [rowCount-1][columnCount];

		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				testData[i-1][j] = sheet.getCell(j,i).getContents();
			}
		}
		return testData;
	}

	@Test(dataProvider = "customer")
	public void AddDetails(String fName, String lName, String PostCode) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SPARTEN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "Localhost:9630");
		ChromeDriver driver = new ChromeDriver(options);                       
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement admin = 	driver.findElement(By.xpath("//*[@class=\"ng-scope\"]/div/div/div[2]/div/div/div[2]/button"));
		admin.click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys(fName);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys(lName);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys(PostCode);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
}
