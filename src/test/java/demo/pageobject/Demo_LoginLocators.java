package demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo_LoginLocators {

	static WebDriver driver;

	public Demo_LoginLocators(WebDriver driver) {
		super();
		this.driver = driver;
	}
	private By username = By.id("username");
	private By password = By.id("password");
	private By submit = By.id("log-in");
	private By LoggeduserName = By.cssSelector("div[class='logged-user-name']");

	public void enterCredentails(String UserName, String Password) {
		driver.findElement(username).sendKeys(UserName);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(submit).click();

	}

	public String getUserName() {
		WebElement welcometext = driver.findElement(By.cssSelector("div[class='logged-user-name']"));
		String WelcomeUserName = welcometext.getText();
		return WelcomeUserName;
	}
}
