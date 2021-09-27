package testScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import excelUtils.DataDriver_AllRecipes;
import pageObjects.EmailSignInPage;
import pageObjects.LandingPage;
import pageObjects.SignInPage;
import resources.Base;

public class VerifyLogin extends Base {

	ArrayList<String> data;
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	@Parameters("browser")
	public void initialise(String browser) throws IOException {
		driver=initializeDriver(browser);
		log.info("Driver is initialised");
		String urlName=prop.getProperty("url");
		driver.get(urlName);
		log.info("Navigated to Home Page ");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(description="Verifies login functionality")
	@Parameters("browser")
	public void verifyLogin(String browser) throws IOException {
		
		LandingPage lp=new LandingPage(driver);
		lp.getLoginTab().click();
		
		SignInPage sip=new SignInPage(driver);
		sip.getSignInWithEmailTab().click();
		
		EmailSignInPage esip=new EmailSignInPage(driver);
		
		DataDriver_AllRecipes dd=new DataDriver_AllRecipes();
		data=dd.getData("User1");
		
		esip.getUsernameTextBox().sendKeys(data.get(1));
		esip.getPasswordTextBox().sendKeys(data.get(2));
		esip.getSignInButton().click();
		
		String actualPageTitle=driver.getTitle(); 
		//
		String expectedPageTitle="Sign In";
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		log.info("Successfully validated title.");
		
	}
	
	@AfterTest(description = "Closes your driver after each test")
	public void closeBrowser() throws InterruptedException {
		driver.close();
		log.info("Closed browser");
	}
}
