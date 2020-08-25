package com.ShopDemoQA.Infra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

	// Current Day Date Method

	// private static final int i = 0;

	public String CurDate() {

		// getting current date and time using Date class
		DateFormat df = new SimpleDateFormat("MMddyyhhmmss");
		Calendar calobj = Calendar.getInstance();
		String Date = df.format(calobj.getTime());
		System.out.println(Date);
		return Date;
	}
	
	public boolean isElementPresent(WebDriver dr, String pathType,
			String elePath) {
		boolean elemPresent = false;
		try {
			if (pathType.equals("css")) {

				dr.findElement(By.cssSelector(elePath));
				elemPresent = true;

			} else if (pathType.equals("link")) {

				dr.findElement(By.linkText(elePath));
				elemPresent = true;
			}

			else if (pathType.equals("xpath")) {

				dr.findElement(By.xpath(elePath));
				elemPresent = true;
			} else if (pathType.equals("id")) {

				dr.findElement(By.id(elePath));
				elemPresent = true;
			}
		} catch (NoSuchElementException e) {
			elemPresent = false;
			e.printStackTrace();
		}

		return elemPresent;
	}
}
