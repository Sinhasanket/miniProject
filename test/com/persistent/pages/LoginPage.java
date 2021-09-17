package com.persistent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.persistent.base.TestBase;


public class LoginPage extends TestBase{

//	private static WebElement element = null;
	//private static By signin = By.className("signin");
	//private static By email = By.name("email");
	//private static By password = By.name("password");

	@FindBy(className="signin")
	WebElement signin;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement loginButton(WebDriver driver) {
//		element = driver.findElement(signin);
		return signin;
	}

	public WebElement getUserEmail(WebDriver driver) {
//		element =  driver.findElement(email);
		return email;
	}

	public WebElement getUserPassword(WebDriver driver) throws Exception{
//		element =  driver.findElement(password);
		return password;
	}
	
	public HomePage login(String e, String pwd) {
		email.sendKeys(e);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
	}

}
