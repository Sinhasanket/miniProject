package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;


public class LoginPage extends TestBase{

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
		return signin;
	}

	public WebElement getUserEmail(WebDriver driver) {
		return email;
	}

	public WebElement getUserPassword(WebDriver driver) throws Exception{
		return password;
	}
	
	public HomePage login(String e, String pwd) {
		email.sendKeys(e);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
	}

}
