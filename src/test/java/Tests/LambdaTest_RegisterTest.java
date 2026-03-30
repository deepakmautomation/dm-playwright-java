package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import baseTest.TestBase;
import pages.Lt_RegisterPage;

public class LambdaTest_RegisterTest {
	
	TestBase testbase;	
	Page page;
	Lt_RegisterPage lambdaTest_RegisterPage;  

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();
		page = testbase.launchBrowser(TestBase.prop.getProperty("browser"));
		lambdaTest_RegisterPage = new Lt_RegisterPage(page);
	}
	
	@Test
	public void verify_lambdaTest_Register() {
		lambdaTest_RegisterPage.enterFirstName("John");
		lambdaTest_RegisterPage.enterLastName("Smith");
		lambdaTest_RegisterPage.clickContinue();
	}

	@AfterMethod
	public void tearDown() {
		page.context().browser().close();
	}

}
