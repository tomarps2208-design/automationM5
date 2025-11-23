package p2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.*;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement src = driver.findElement(By.xpath("//form[contains(@class, '_9vtf')]"));
		File sc1 = src.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorShots/webel1.png");
		FileHandler.copy(sc1, dest);
		driver.quit();
	}

}
