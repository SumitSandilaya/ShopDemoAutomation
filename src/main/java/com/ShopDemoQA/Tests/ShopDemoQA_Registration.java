package com.ShopDemoQA.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ShopDemoQA.Infra.CommonMethods;
import com.ShopDemoQA.Infra.InitateBrowser;
import com.ShopDemoQA.Infra.ReadWriteExcelFile;
import com.ShopDemoQA.solutions.Home;
import com.ShopDemoQA.solutions.Logout;
import com.ShopDemoQA.solutions.Registration;

@Test
public class ShopDemoQA_Registration {
	@Parameters({ "driverVer", "baseUrl" })
	public static void Registration(String driverVer, String baseUrl)
			throws Exception {

		CommonMethods cm = new CommonMethods();
		String date = cm.CurDate();
		String Email = "ss" + date + "@gmail.com";
		String curemail = Email;
		String UserName = "ss" + date;
		WebDriver driver = null;
		InitateBrowser browser;
		Home home;
		Registration registration;
		Logout logout;
		String projectPath = System.getProperty("user.dir");
		ReadWriteExcelFile wrExcel = new ReadWriteExcelFile(projectPath
				+ "/dataFiles/TestData.xlsx", "Register");
		// String Path =
		// "D:/Selenium Projects/ShopDemoQA/dataFiles/TestData.xlsx";

		browser = new InitateBrowser();
		driver = browser.startDriverForTest(driverVer);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		home = new Home();
		home = home.home(driver);
		registration = new Registration();

		registration = registration.reg(driver, UserName, curemail);
		registration = registration.confirmreg(driver, curemail);
		System.out.println("Curent Username is: " + UserName);
		System.out.println("Current Emial is: " + curemail);
		logout = new Logout();
		logout = logout.logout(driver);

		Thread.sleep(5000);
		driver.quit();
	}
}