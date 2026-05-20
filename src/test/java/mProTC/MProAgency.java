package mProTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MProAgency {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mprouat.axismaxlife.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("userId")).sendKeys("121939");
		driver.findElement(By.id("password")).sendKeys("Login!2347");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
