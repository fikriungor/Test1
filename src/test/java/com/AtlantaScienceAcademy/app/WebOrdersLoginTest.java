package com.AtlantaScienceAcademy.app;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebOrdersLoginTest {
	WebDriver driver;
	WebOrdersLoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public  void loginUsingPOM() {
		
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	assertEquals(driver.getTitle(), "Web Orders Login", "Login page is not displayed");

	loginPage = new WebOrdersLoginPage(driver);
	loginPage.userName.sendKeys("Tester");
	loginPage.password.sendKeys("test");
	loginPage.loginButton.click();
	assertTrue(loginPage.userName.isDisplayed(), "You are in the correct page");
	assertTrue(!driver.findElement(By.linkText("View all orders")).isDisplayed(), "The Link is displayed");
	}
	
	@AfterMethod
	public void afterTest() {
	driver.close();
	}
	
}

	
	

