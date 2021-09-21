package TestRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRegistration3 {
	private WebDriver driver;
	private String baseUrl = "http://127.0.0.1:8000/accounts/register";

	@DataProvider(name = "UserData")
	public Object[][] SendUserData() {
		Object[][] User = { {
				" Verify that in registration page Email must content Mail server address after @  Symbol validation is applied ",
				"Gatherly Social Network | Register", "rajika5@", "Raji5", "qwerty12345",
				"RegTest_09- failed - Registration successful",
				"RegTest_09 Failed : Registration failed : Error message is not displayed :Validation may applied but error pop up is not displayed" },
				{ "Verify that in registrationpage Email must content \" . \" Symbol validation is applied ",
						"Gatherly Social Network | Register", "rajika6@emailcom", "Raji6", "qwerty12345",
						"RegTest_10-failed - Registration successful",
						"RegTest_10 Failed : Registration failed : Error message is not displayed :Validation may applied but error pop up is not displayed" }

		};
		return (User);
	}

	@Test(dataProvider = "UserData")
	public void RegTest_09(String TestCase, String ExpectedTitle, String email, String userName, String password,
			String message, String message2) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Assert.assertEquals(driver.getTitle(), ExpectedTitle);
		Reporter.log("Test - " + TestCase + "|||");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password1")).clear();
		driver.findElement(By.name("password1")).sendKeys(password);
		driver.findElement(By.name("password2")).clear();
		driver.findElement(By.name("password2")).sendKeys(password);

		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[7]/button/span")).click();
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		Thread.sleep(3000);
		try {
			Assert.assertEquals(driver.getTitle(), "Django Social Network | Login");
			Reporter.log(message);
		} catch (Throwable t) {
			Reporter.log(message2);
			org.testng.Assert.fail("Failed to register");

		}
	}

	@Test()
	public void RegTest_11() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Assert.assertEquals(driver.getTitle(), "Gatherly Social Network | Register");
		Reporter.log(
				"Test -  Verify that error message is displayed when password and confirm password does not match|||");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("rajika11@gmail.com");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Raji11");
		driver.findElement(By.name("password1")).clear();
		driver.findElement(By.name("password1")).sendKeys("qwerty");
		driver.findElement(By.name("password2")).clear();
		driver.findElement(By.name("password2")).sendKeys("ytrewq");

		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[7]/button/span")).click();
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		Thread.sleep(3000);
		try {
			Assert.assertEquals(driver.getTitle(), "Django Social Network | Login");
			Reporter.log("RegTest_11 - Registration successful");
		} catch (Throwable t) {
			Reporter.log(
					"RegTest_10 Failed : Registration failed : Error message is not displayed :Validation may applied but error pop up is not displayed");
			org.testng.Assert.fail("Failed to register");

		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Setup Successful");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("Execution successful");
	}

}
