package com.AtlantaScienceAcademy.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTests {
	
	WebDriver driver;
	
	@BeforeMethod
    public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void fileUpload() {
		
		
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement input = driver.findElement(By.id("file-upload"));
		String filePath = "C:\\Users\\meral\\Desktop\\kilim\\IMG_4550.jpg";
		input.sendKeys(filePath);
		
		
//		WebElement upload = driver.findElement(By.id("file-submit"));
//		upload.click();
		
	}

}
