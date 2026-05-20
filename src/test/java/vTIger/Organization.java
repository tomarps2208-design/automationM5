package vTIger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Organization {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1800);
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		Thread.sleep(1800);
		double num1 = Math.random()* 1000;
		int num = (int) num1;
		driver.findElement(By.name("accountname")).sendKeys("CresTech MLI Partnership" + num);
		Thread.sleep(1800);
		
		driver.findElement(By.name("website")).sendKeys("Crestech.com " + num);
		Thread.sleep(1800);
		driver.findElement(By.id("employees")).sendKeys(String.valueOf(num));
		Thread.sleep(1800);
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select s = new Select(dropdown);
		s.selectByValue("Technology");
		Thread.sleep(1800);
		WebElement dropdown1 = driver.findElement(By.name("rating"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("Active");
		Thread.sleep(1800);
		driver.findElement(By.name("bill_street")).sendKeys("Sector 18"+ num);
		Thread.sleep(1800);
		driver.findElement(By.id("bill_city")).sendKeys("Gurgaon");
		Thread.sleep(1800);
		driver.findElement(By.id("bill_country")).sendKeys("India");
		Thread.sleep(1800);
		driver.findElement(By.cssSelector("input.crmbutton.small.save")).click();
		Thread.sleep(3000);
		driver.quit();
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		Thread.sleep(1500);
		driver.quit();
	}

}
