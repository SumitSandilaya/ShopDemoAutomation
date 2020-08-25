package com.ShopDemoQA.solutions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration implements IMyAccount {

	
	public Registration reg(WebDriver driver, String UserName, String Email) {

		driver.findElement(By.id(IDRegName)).sendKeys(UserName);
		driver.findElement(By.id(IDRegEmail)).sendKeys(Email);
		System.out.println("Email Entered is " + Email);
		System.out.println("Registration Email Entered");
		driver.findElement(By.id(IDRegPassword)).sendKeys("ABC@12345678901");
		System.out.println("Registration Password Entered");
		driver.findElement(By.name(NameRegBTN)).click();
		System.out.println("Reg Button clicked");

		if (driver.getPageSource().contains("Error:")) {
			driver.findElement(By.id(IDRegName)).clear();
			driver.findElement(By.id(IDRegName)).sendKeys(UserName);
			driver.findElement(By.id(IDRegEmail)).clear();
			driver.findElement(By.id(IDRegEmail)).sendKeys(Email);
			driver.findElement(By.id(IDRegPassword)).clear();
			driver.findElement(By.id(IDRegPassword))
					.sendKeys("ABC@12345678901");
			driver.findElement(By.name(NameRegBTN)).click();
		}

		return new Registration();
	}

	public Registration confirmreg(WebDriver dr1, String Email) {
		dr1.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		dr1.findElement(By.id(IDCNF_EMAL_TXTBOX)).sendKeys(Email);
		System.out.println("(Confirmation Email Entered)");
		dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).clear();
		dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).click();
		dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).sendKeys("ABC@12345678901");
		System.out.println("Confirmation Password Entered");
		dr1.findElement(By.id(IDCNF_REG_BTN)).click();
		System.out.println("(By.id(IDCNF_REG_BTN)).click()");
		dr1.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		if (dr1.getPageSource().contains("Error")) {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dr1.findElement(By.id(IDCNF_EMAL_TXTBOX)).clear();
			dr1.findElement(By.id(IDCNF_EMAL_TXTBOX)).sendKeys(Email);
			System.out.println("(Confirmation Email Entered)");
			dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).clear();
			dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).click();
			dr1.findElement(By.id(IDCNF_PASS_TXTBOX)).sendKeys(
					"ABC@12345678901");
			System.out.println("Confirmation Password Entered");
			dr1.findElement(By.id(IDCNF_REG_BTN)).click();

		}

		return new Registration();
	}

}
