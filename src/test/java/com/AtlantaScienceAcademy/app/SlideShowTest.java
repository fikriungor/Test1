package com.AtlantaScienceAcademy.app;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SlideShowTest {

	
	
//	@BeforeMethod
//	public void setUp() {
//		
//		System.out.println("this is before class");
//	}
	
	@Test
		
	public void homePageTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	driver.get("https://www.hbloom.com/Gifts/flower-delivery");
	
	List<WebElement> images = driver.findElements(By.tagName("img"));
	
	List <String> srcs = new ArrayList<>();
	
	for (WebElement flower : images) {
		
		srcs.add(flower.getAttribute("src"));
	}
		for (String link : srcs) {
			driver.get(link);
		
	}

	}}
