package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;
	
	// Constructor
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSignInWithEmailTab() {
		return driver.findElement(By.cssSelector("div.loginRegistration__email"));
		
	}
}
