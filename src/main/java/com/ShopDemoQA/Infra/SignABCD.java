package com.ShopDemoQA.Infra;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;



public class SignABCD {
	
	
	 public static void main(String[] args ) {
		 Logger logger = LogManager.getLogger(SignABCD.class);
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium Projects//ShopDemoQA//src//Lib//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
//		System.out.println("Browser Open");
		logger.info("Browser Open");
		Reporter.log("Browser Open");
		driver.get("http://shop.demoqa.com/");
//		System.out.println("URL called");
		logger.info("URL aa gaya");
		Reporter.log("URL called");
		

		// driver.findElement(By.linkText("Dismiss")).click();
		// driver.findElement(By.linkText("My Account")).click();

	
		driver.findElement(By.linkText("Dismiss")).click();
//		System.out.println("Dimiss link clicked");
		logger.info("Dimiss link clicked");
		Reporter.log("Dimiss link clicked");
		
		driver.findElement(By.linkText("My Account")).click();
//		System.out.println("My Account link clicked");
		logger.info("My Account link clicked");
		Reporter.log("My Account link clicked");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).clear();
		System.out.println("Password box clicked");
		logger.info("Password box clicked");
		Reporter.log("Password box clicked");
		driver.findElement(By.id("password")).sendKeys("");
		System.out.println("Enter Password");
		logger.info("Enter Password");
		Reporter.log("Enter Password");
		driver.findElement(By.name("login")).click();
		logger.info("LogIn button clicked");
		System.out.println("LogIn button clicked");
		Reporter.log("LogIn button clicked");
		
////		driver.close();
////		System.out.println("Browser Closed");
//		logger.info("Browser Closed");
//		Reporter.log("Browser Closed");

	}

}