package test.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2Registration {
	private WebDriver driver;
	private String baseUrl = "http://127.0.0.1:8000/accounts/register";

	@Parameters({ "TestCase5", "ExpectedTitle5", "email5", "userName5", "password5", "message5", "message25" })

	@Test()
	public void RegTest_05(String TestCase, String ExpectedTitle, String email, String userName, String password,
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

	@Parameters({ "TestCase6", "ExpectedTitle6", "email6", "userName6", "password6", "message6", "message26" })

	@Test()
	public void RegTest_06(String TestCase, String ExpectedTitle, String email, String userName, String password,
			String message, String message2) throws InterruptedException {
		RegTest_05(TestCase, ExpectedTitle, email, userName, password, message, message2);

	}

	@Parameters({ "TestCase7", "ExpectedTitle7", "email7", "userName7", "password7", "message7", "message27" })

	@Test()
	public void RegTest_07(String TestCase, String ExpectedTitle, String email, String userName, String password,
			String message, String message2) throws InterruptedException {
		RegTest_05(TestCase, ExpectedTitle, email, userName, password, message, message2);

	}

	@Parameters({ "TestCase8", "ExpectedTitle8", "email8", "userName8", "password8", "message8", "message28" })

	@Test()
	public void RegTest_08(String TestCase, String ExpectedTitle, String email, String userName, String password,
			String message, String message2) throws InterruptedException {
		RegTest_05(TestCase, ExpectedTitle, email, userName, password, message, message2);

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
