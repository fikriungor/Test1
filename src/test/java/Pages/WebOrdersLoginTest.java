package Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebOrdersLoginTest {
	WebDriver driver;
	WebOrdersLoginPage loginPage;
	ProductsPage productsPage;
	String userID = "Tester";
	String password = "test";
			
	
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
//	loginPage.userName.sendKeys("Tester");
//	loginPage.password.sendKeys("test");
//	loginPage.loginButton.click();
	
	loginPage.login(userID, password);
	
	assertTrue(!loginPage.userName.isDisplayed(), "You are in the correct page");
	assertTrue(!driver.findElement(By.linkText("View all orders")).isDisplayed(), "The Link is displayed");
	
	}
	
	@Test(description="Verify default proucts and prices")
	public void availableProductsTest() {
		
		loginPage = new WebOrdersLoginPage(driver);
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage.login(userID, password);
		driver.findElement(By.linkText("View all products")).click();
		productsPage = new ProductsPage(driver);
				
		List <String> expProducts = Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver");
		List <String> actProducts = new ArrayList<>();
		 for (WebElement product: productsPage.productNames) {
			 actProducts.add(product.getText());
			 assertEquals(actProducts,expProducts);
			 
			 loginPage.logOut();
				driver.close();
		 }
		
	}
	
//	//@AfterMethod
//	public void afterTest() {
//	
//	}
}	


	
	

