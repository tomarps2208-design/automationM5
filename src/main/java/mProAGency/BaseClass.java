package mProAGency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
		protected WebDriver driver;
		@BeforeMethod
		public void  browserStart() throws InterruptedException
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://mprouat.axismaxlife.com/");		
			Thread.sleep(1000);
			driver.findElement(By.id("userId")).sendKeys("121939");
			driver.findElement(By.id("password")).sendKeys("Login!2347");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
			Thread.sleep(4000);
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}

	}
