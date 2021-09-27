package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailSignInPage {

public WebDriver driver;
	
	// Constructor
	public EmailSignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getUsernameTextBox() {
		return driver.findElement(By.id("userSigninForm_email"));
	}
	
	public WebElement getPasswordTextBox() {
		return driver.findElement(By.id("userSigninForm_password"));
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("userSigninForm_btnSignup"));
		
	}
}
