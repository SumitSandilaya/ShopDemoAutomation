package com.ShopDemoQA.solutions;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CopyOfLogin implements IMyAccount{
//	WebDriver driver = null;
	
	
	private Logger logger = LogManager.getLogger(CopyOfLogin.class);
//	private static final Logger logger = LogManager.getLogger(App.class);
	public  CopyOfLogin login(WebDriver driver){
		System.out.println("In Login Method");
		logger.info("In Login Method");
		Reporter.log("In Login Method");
		driver.findElement(By.id(IDUsername)).clear();
		System.out.println("Emailtext box click");
		logger.info("Emailtext box click");
		Reporter.log("Emailtext box click");
		driver.findElement(By.id(IDUsername)).sendKeys("sumitshandilaya84@gmail.com");
		System.out.println("Email Entered");
		logger.info("Email Entered");
		Reporter.log("Email Entered");
		driver.findElement(By.id(IDPassword)).clear();
		System.out.println("Password box clicked");
		logger.info("Password box clicked");
		Reporter.log("Password box clicked");
		driver.findElement(By.id(IDPassword)).sendKeys("ABC@12345678901");
		System.out.println("Enter Password");
		logger.info("Enter Password");
		Reporter.log("Enter Password");
		driver.findElement(By.name(BTNLogin)).click();
		logger.info("LogIn button clicked");
		System.out.println("LogIn button clicked");
		Reporter.log("LogIn button clicked");
		
		return new CopyOfLogin();
//		System.out.println("Code Executed");
	}


}
