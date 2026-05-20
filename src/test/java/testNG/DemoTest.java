package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
	@Test
	public void case1()
	{
		System.out.println("1. This Method Will replace MAIN method.....");
		Reporter.log("This message will be Printed in the HTML Report", true);
	}
	
	@Test
	public void case2()
	{
		System.out.println("2. This Method Will replace MAIN method.....");
		Reporter.log("This message will be Printed in the HTML Report");
	}
	
	
	public static void main(String[] args) 
	
	{
		
		System.out.println("This Method is MAIN method.....");
	}

}
