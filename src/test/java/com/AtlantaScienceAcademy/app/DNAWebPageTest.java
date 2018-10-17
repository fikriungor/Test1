package com.AtlantaScienceAcademy.app;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DNAWebPageTest {
	
	
	
//	@BeforeClass
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver.manage().window().maximize();
//	}
//	
	@Test
	public void mainMenu() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://darunnoor.org/");
		List <WebElement> mainMenu = driver.findElements(By.xpath("//div[@class='tm-table']/nav/ul/li"));
		
		Actions action = new Actions(driver);
		
		for (int i =0; i<mainMenu.size(); i++) {
			action.moveToElement(mainMenu.get(i)).perform();
			Thread.sleep(1500);
						
		}
		
		driver.close();
	}
	
	

}
