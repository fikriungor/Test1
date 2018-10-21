package suiteCRMTest;

import org.testng.annotations.Test;

import Utilities.ConfigLoader;
import suiteCRMPages.SuiteCRMCreateTaskPage;
import suiteCRMPages.SuiteCRMHomePage;
import suiteCRMPages.SuiteCRMLoginPage;
import suiteCRMPages.SuiteCRMTaskOverviewPage;


public class SuiteCRMTest extends TestBase{
	SuiteCRMLoginPage loginpage = new SuiteCRMLoginPage(driver);
	SuiteCRMCreateTaskPage taskpage = new SuiteCRMCreateTaskPage(driver);
	SuiteCRMHomePage homepage = new SuiteCRMHomePage(driver);
	SuiteCRMTaskOverviewPage taskoverview = new SuiteCRMTaskOverviewPage(driver);
	
	@Test
	public void createTaskInSuiteCRM() {
		driver.get(ConfigLoader.getProperty("suitecrm.url"));
	}

}
