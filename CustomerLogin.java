package bankProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CustomerLogin {
	
WebDriver driver;
@Test
	public void customerlogin() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\SPARTEN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "Localhost:9630");
		ChromeDriver driver = new ChromeDriver(options);                       
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		
		WebElement choose = driver.findElement(By.id("userSelect"));
		Select select = new Select(choose);
		select.selectByVisibleText("david michel");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("5000");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		System.out.println("David Michel Deposited");
		
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		WebElement choose1 = driver.findElement(By.id("userSelect"));
		Select select1 = new Select(choose1);
		select1.selectByVisibleText("michel david");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("5000");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		System.out.println("Michel David Deposited");
		
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
		

	}
}
