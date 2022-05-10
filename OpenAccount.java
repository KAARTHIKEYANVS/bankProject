package bankProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OpenAccount {
	WebDriver driver;
	@Test
	public void openaccount() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SPARTEN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "Localhost:9630");
		ChromeDriver driver = new ChromeDriver(options);                       
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement admin = 	driver.findElement(By.xpath("//*[@class=\"ng-scope\"]/div/div/div[2]/div/div/div[2]/button"));
		admin.click();	
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
		
		Thread.sleep(2000);
		
		WebElement open = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select select = new Select(open);
		select.selectByVisibleText("david michel");
		WebElement currency = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select curr = new Select(currency);
		curr.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement open1 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select select1 = new Select(open1);
		select1.selectByVisibleText("michel david");
		WebElement currency1 = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select curr1 = new Select(currency1);
		curr1.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		WebElement open2 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select select2 = new Select(open2);
		select2.selectByVisibleText("david john");
		WebElement currency2 = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select curr2 = new Select(currency2);
		curr2.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		WebElement open3 = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select select3 = new Select(open3);
		select3.selectByVisibleText("john david");
		WebElement currency3 = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select curr3 = new Select(currency3);
		curr3.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
	}
}
