package com.AtlantaScienceAcademy.app;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {
	WebDriver driver;

	@BeforeMethod
    public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void endTest() throws InterruptedException {
		Thread.sleep(2500);
		driver.close();
	}

	@Test
	public void alertHandlesTest() {
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		driver.findElement(By.xpath("(//button)[1]")).click();
		alert.dismiss();
	}	
	
	@Test
	public void windowHandles() {
		
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		
		String firstWindow = driver.getWindowHandle();
		System.out.println(firstWindow);
		
		Set <String> windowHandles = driver.getWindowHandles();
		
		for (String windowID:windowHandles) {
			System.out.println(windowID);
			
			
			if(!firstWindow.equals(windowID)) {
				driver.switchTo().window(windowID);
			}
			
		}
		
		
	}
}
