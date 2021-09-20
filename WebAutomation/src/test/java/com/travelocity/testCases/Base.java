package com.travelocity.testCases;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base {

	
	public String baseURL = "https://www.travelocity.com";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	 
	
}
