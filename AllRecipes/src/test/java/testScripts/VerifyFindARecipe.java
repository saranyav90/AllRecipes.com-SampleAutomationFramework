package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class VerifyFindARecipe extends Base{

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
	
	
	@Test(description="Verifies search recipe functionality")
	@Parameters("browser")
	public void findARecipe(String browser) {
		
		LandingPage lp=new LandingPage(driver);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(lp.getSearchBlock())).sendKeys("Cookie");
		WebElement searchButton=lp.getSearchButton();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		log.info("Successfully navigated to Search Results.");
	}
	
	@AfterTest(description = "Closes your driver after each test")
	public void closeBrowser() throws InterruptedException {
		driver.close();
		log.info("Closed browser");
	}
}
