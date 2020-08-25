package com.ShopDemoQA.solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home implements IHome {

	public Home home(WebDriver driver) {
		// TODO Auto-generated constructor stub

		System.out.println("Inside the Home method");
		driver.findElement(By.linkText(linkTextDismiss)).click();
		System.out.println("Dismiss link clicked");
		driver.findElement(By.linkText(linkTextMyAccount)).click();
		System.out.println("My Account link clicked");

		return new Home();

	}
}
