package com.ShopDemoQA.Tests;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ShopDemoQA.Infra.InitateBrowser;
import com.ShopDemoQA.Infra.ReadWriteExcelFile;
import com.ShopDemoQA.solutions.Home;
import com.ShopDemoQA.solutions.Login;
import com.ShopDemoQA.solutions.Logout;

@Test
public class ShopDemoQA_SignIn {
	@Parameters({ "driverVer", "baseUrl" })
	public static void signin(String driverVer, String baseUrl)
			throws Exception {
		WebDriver driver = null;
		InitateBrowser browser;
		Home home;
		Login login;
		Logout logout;
		String projectPath = System.getProperty("user.dir");
		ReadWriteExcelFile reExcel = new ReadWriteExcelFile(projectPath
				+ "/dataFiles/TestData.xlsx", "SignIn");

		browser = new InitateBrowser();
		driver = browser.startDriverForTest(driverVer);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		home = new Home();
		home = home.home(driver);

		for (int rowNum = 1; rowNum < 5; rowNum++) {
			String Uname = reExcel.userName(rowNum);
			String Upass = reExcel.password(rowNum);
			System.out.println(Uname);
			System.out.println(Upass);

			login = new Login();
			login = login.login(driver, Uname, Upass);
			logout = new Logout();
			logout = logout.logout(driver);

		}
		Thread.sleep(5000);
		driver.close();
	}

}
