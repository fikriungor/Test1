package com.AtlantaScienceAcademy.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest {
	
WebDriver driver;
	
	@BeforeMethod
    public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void doubleClickTest() {
		
		driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
		WebElement slides = driver.findElement(By.id("slide_header"));
		
		Actions action = new Actions(driver);
		
		action.doubleClick(slides).perform();
		
	}
	
	@Test
	public void hoverTest1() {
		driver.get("https://amazon.com");
		
		WebElement hover = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
	}
	
	@Test
	public void hoverTest2() {
		driver.get("https://amazon.com");
		
		WebElement hover2 = driver.findElement(By.xpath("//span[.='Back to top']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(hover2).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_UP).perform();
		
		driver.close();
		
}
	@Test
	public void dragDropTest2() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));
		action.dragAndDrop(source, target).perform();
	}
}
