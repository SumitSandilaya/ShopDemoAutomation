package com.ShopDemoQA.solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout implements ILogout {

	public Logout logout(WebDriver driver) {
		System.out.println("In Logout Method");
		driver.findElement(By.linkText(Logout)).click();
		System.out.println("Clicked on Logout button");

		return new Logout();
	}

}
