package com.ShopDemoQA.Infra;

//import ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InitateBrowser {

//	 public static String driverpath =
//	 "D://Selenium Projects//ShopDemoQA//src//Lib//";
//	 // public static String crdriverpath =
//	 // "D://Selenium Projects//ShopDemoQA//src//Lib//";
//	
//	 ApplicationProperties ap = new ApplicationProperties();
//	
//	 public WebDriver StartFireFox(WebDriver driver) {
//	 String URL = ap.AppURL;
//	 System.setProperty("webdriver.gecko.driver", driverpath
//	 + "geckodriver.exe");
//	 System.out.println("GekoDrviver Called");
//	 driver = new FirefoxDriver();
//	 System.out.println("driver = new FirefoxDriver();");
//	 driver.get("http://shop.demoqa.com/");
//	 System.out.println("driver.get(baseUrl);");
//	 driver.get(URL);
//	 driver.get("http://shop.demoqa.com/");
//	 return driver;
//	
//	 }
//	
//	 public WebDriver StartChrome(WebDriver driver) {
//	
//	 String URL = ap.AppURL;
//	 System.setProperty("webdriver.chrome.driver", driverpath
//	 + "chromedriver.exe");
//	 System.out.println("ChromeDrviver Called");
//	 driver = new ChromeDriver();
//	 System.out.println("driver = new ChromeDriver();");
//	 System.out.println("driver.get(baseUrl);");
//	 driver.get(URL);
//	
//	 // driver.get("http://shop.demoqa.com/");
//	 return driver;
//	
//	 }

	
	
//	New Method to Start Browser
	
	
	private WebDriver driver;
	private File file;

	public WebDriver startDriverForTest(String driverVer) {
		WebDriver driver1 = null;
		if (driverVer.equals("ie"))
			driver1 = startInternetExplorerDriver(driver);
		else if (driverVer.equals("chrome"))
			driver1 = startChromeDriver(driver);
		else if (driverVer.equals("ff"))
			driver1 = startFirefoxDriver(driver);
		return driver1;
	}

	private WebDriver startFirefoxDriver(WebDriver driver) {
		file = new File(
				"D://Selenium Projects//ShopDemoQA//src//Lib//geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	private WebDriver startChromeDriver(WebDriver driver) {
		file = new File(
				"D://Selenium Projects//ShopDemoQA//src//Lib//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver startInternetExplorerDriver(WebDriver driver) {
		file = new File(
				"D://Selenium Projects//ShopDemoQA//src//Lib//IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver = new org.openqa.selenium.ie.InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void intselenium(String browser, String version, String baseURL,String rURL) 
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		if (browser.equalsIgnoreCase("firefox"))
			capability.setBrowserName(browser);
		if (browser.equalsIgnoreCase("internet explorer")) {
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setBrowserName(browser);
			capability.setVersion(version);
		}
		if (browser.equalsIgnoreCase("chrome")) {
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			capability.setBrowserName(browser);
		}
		try {
			// URL hubUrl = new URL("http://localhost:4444/wd/hub");
			URL hubUrl = new URL(rURL);
			driver = new RemoteWebDriver(hubUrl, capability);
			driver.get(baseURL);
		} finally {
		}

	}

}
