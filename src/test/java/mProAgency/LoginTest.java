package mProAgency;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import mProAGency.*;

public class LoginTest extends BaseClass {

	
	@Test()
	public void stageOne() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement newAppBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class,'newApplicationBtn')]")));
		newAppBtn.click();
		//driver.findElement(By.xpath("//li[contains(@class,'newApplicationBtn')]")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("//input[@type='radio' and @value='new']")).click(); //new customer check
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		WebElement nationality = wait.until(ExpectedConditions.elementToBeClickable(By.id("indian")));
		driver.findElement(By.id("indian")).click();
		Thread.sleep(400);
		driver.findElement(By.cssSelector("label[for='nri']")).click();
		Thread.sleep(400);
		WebElement self = driver.findElement(By.cssSelector("label[for='self']"));
		self.click();
		Thread.sleep(400);
		driver.findElement(By.cssSelector("label[for='i2']")).click();
		Thread.sleep(400);
		driver.findElement(By.cssSelector("label[for='mv1']")).click();
		Thread.sleep(400);
		driver.findElement(By.cssSelector("input[name='aadhaarNo']")).sendKeys("222222222233"); //enter Aadhar No
		Thread.sleep(400);
		driver.findElement(By.className("OCR-verifyBtn")).click();  //click verify
		Thread.sleep(400);
		driver.findElement(By.cssSelector("input[name='checkedG']")).click(); 
		Thread.sleep(400);
		driver.findElement(By.xpath("//button[text()='Get OTP']")).click();
		Thread.sleep(400);
		driver.findElement(By.cssSelector("input[name='otpvalue']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Verify OTP']")).click();
		WebElement skipBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Skip']")));
		skipBtn.click();
		driver.findElement(By.className("OCR-upload-Btn")).click();
		driver.findElement(By.className("RenderCustomDropdown__labelText__2TLdA")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Letter issued by National Population Register']")).click();
		Thread.sleep(2000);
		
		//WebElement upload = //driver.findElement(By.className("FileUpload__iconWrap__11JdV"));
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\PrashantSinghTomar\\Downloads\\ISTQB_CTFL_Syllabus_v4.0.1.pdf");
		
		int randomPAN = (int) Math.random()*10000;
		String PAN;
		if (self.isEnabled())
		{
			PAN = panGenerator.generatePAN("individual");

		}
		
		else 
		{
			PAN = panGenerator.generatePAN("company");

		}
		Thread.sleep(300);
		WebElement pan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='panNumber']")));
		pan.sendKeys(PAN);
		Thread.sleep(300);
		int MobNo = (int) (Math.random()*1000000000);
		WebElement mobNo = driver.findElement(By.cssSelector("input[name='mobileNumber']"));
		actions.moveToElement(mobNo).perform();
		mobNo.sendKeys("9"+String.valueOf(MobNo));
		Thread.sleep(300);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("tomarps2208@gamil.com");
		Thread.sleep(300);
		//driver.findElement(By.cssSelector("input[name='customerConsentFlag']")).click();
		Thread.sleep(300);
		WebElement consent = driver.findElement(By.cssSelector("input[name='emailSMSConsent']"));
		actions.moveToElement(consent).perform();
		consent.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[.//span[text()='Proceed']]")).click();
		//driver.findElement(By.cssSelector("input[class='journeyButtonWrap']")).click();
		Thread.sleep(1500);
		
		//Stage 2
        char randomChar = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
		driver.findElement(By.name("firstName")).sendKeys("Tester"+String.valueOf(randomChar));
		driver.findElement(By.name("lastName")).sendKeys(String.valueOf(randomChar)+String.valueOf(randomChar));
		Thread.sleep(500);
		driver.findElement(By.cssSelector("label[for='male']")).click();
		Thread.sleep(500);

		driver.findElement(By.name("dateOfBirth")).click();
		WebElement yearDropdown = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.cssSelector(".react-datepicker__year-select")
		        )
		);

		Select year = new Select(yearDropdown);
		year.selectByVisibleText("1997");
		
		WebElement monthDropdown = wait.until(
									ExpectedConditions.elementToBeClickable(
											By.cssSelector(".react-datepicker__month-select")
		        )
		);

		Select month = new Select(monthDropdown);
		month.selectByVisibleText("March");
		WebElement day = driver.findElement(
			    By.xpath("//div[contains(@class,'react-datepicker__day--tue') and text()='4']")
			);
			day.click();
		
		Thread.sleep(1000);
		WebElement panAdhaarLink = wait.until(
		        ExpectedConditions.elementToBeClickable(By.cssSelector(".PanAdharLinkedDialog__btn__bjiLm"))
		);
		panAdhaarLink.click();
		WebElement panAdhaarLinkConf = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cancel']")));
		panAdhaarLinkConf.click();
		WebElement countryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("communicationCountry_idd")));

		//WebElement countryInput = driver.findElement(By.id("communicationCountry_idd"));
		countryInput.click();
		Thread.sleep(2000);

		countryInput.sendKeys("Ind");
		List<WebElement> suggestions = wait.until(
		  ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[(@name,'communicationCountry')]")));
		for(WebElement option : suggestions) {
		if(option.getText().equalsIgnoreCase("India")) {
		option.click();
		break;
		}
	}
		System.out.println("Test Jenkins update");
	}
}
