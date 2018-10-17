package com.AtlantaScienceAcademy.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.Job;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CTTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://dice.com";
		Faker faker = new Faker();
		driver.get(url);
		
		
		String jobTitle = faker.job().position();
		driver.findElement(By.cssSelector("#search-field-keyword")).sendKeys("automation");
		String location = faker.address().zipCode();
		driver.findElement(By.cssSelector("#search-field-location")).clear();
		driver.findElement(By.cssSelector("#search-field-location")).sendKeys("30080");
		driver.findElement(By.cssSelector("#findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		int countResult = Integer.parseInt(count.replace(",", ""));
		
		if (countResult>0) {
			System.out.println("Keyword: "+ jobTitle + "search returned "+ countResult + " results in location "+ location );
		}

	}

}
