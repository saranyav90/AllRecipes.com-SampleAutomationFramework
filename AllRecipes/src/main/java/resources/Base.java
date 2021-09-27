package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

public class Base {

	
	public  WebDriver driver; 
	public  Properties prop;
	
	//method to initialize and return WebDriver Object as per which browser is being used
	@Parameters("browser")
	public WebDriver initializeDriver(String browser) throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/saranya.vazhampatta/eclipse-workspace/AllRecipes/src/main/java/resources/data.properties");
		prop.load(fis);
		String urlName=prop.getProperty("url");
		System.out.println(urlName);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//saranya.vazhampatta//Downloads//chromedriver");
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			//Safari initialization
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	//changed to testMethodName from testCaseName
	public String getScreenShotPath(String testMethodName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty(("user.dir")+ "//reports//"+testMethodName+".png");
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
