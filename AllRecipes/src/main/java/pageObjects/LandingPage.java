package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	// Constructor
		public LandingPage(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement getLoginTab() {
			return driver.findElement(By.cssSelector("a[data-tracking-label='login']"));
		}
	
		public WebElement getSearchBlock() {
			return driver.findElement(By.xpath("//input[@id='search-block']"));
		}
		
		public WebElement getSearchButton() {
			return driver.findElement(By.xpath("//body/main[1]/section[1]/div[1]/div[1]/form[1]/button[1]"));
		}
	
}
