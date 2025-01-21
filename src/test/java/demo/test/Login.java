package demo.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import demo.pageobject.Demo_LoginLocators;
import demo.utilities.Demo_BaseClass;


public class Login extends Demo_BaseClass {
	

	@Test (priority = 1)
	public void LoginWithvalidCredentials() {
		Demo_LoginLocators parabank_loginLocators = new Demo_LoginLocators(driver);
		parabank_loginLocators.enterCredentails("Amila@12", "Amila@12");
		String WelcomeUserName = parabank_loginLocators.getUserName();
		System.out.println(WelcomeUserName);
		assertThat(WelcomeUserName.equals("Jack Gomez"));
	}

//	@Test (priority = 2)
//	public void LoginWithInvalidCredentials() {
//		Demo_LoginLocators parabank_loginLocators = new Demo_LoginLocators(driver);
//		parabank_loginLocators.enterCredentails("John@1323", "John@123");
////		String ErrorMessage = parabank_loginLocators.getErrorMessage();
////		assertThat(ErrorMessage.equals("The username and password could not be verified."));
//	}


}
