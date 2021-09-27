package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomeBackHomepage {

public WebDriver driver;
	
	// Constructor
	public WelcomeBackHomepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSearchBlock() {
		return driver.findElement(By.xpath("//input[@id='search-block']"));
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(By.xpath("//body/main[1]/section[1]/div[1]/div[1]/form[1]/button[1]"));
	}
	
}
