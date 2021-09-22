package test.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1Registration {
	private WebDriver driver;
	private String baseUrl = "http://127.0.0.1:8000/accounts/register";

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Setup Successful");
	}

	@Test
	public void RegTest_01() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Reporter.log("RegTest_01-Verify the registration page title.|||");
		String expectedTitle = "Gatherly Social Network | Register";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		Reporter.log("Test Case Output: " + driver.getTitle());

	}

	@Test
	public void RegTest_02() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Reporter.log("Verify that Gatherly background color is blue||||");
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div"));
		Assert.assertEquals(element.getCssValue("background-color"), "rgb(31, 182, 255)");
		Reporter.log("Test Case Output :" + element.getCssValue("background-color"));

	}

	@Test
	public void RegTest_03() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Reporter.log("Verify the registration frame title |||");
		String expectedTitle = "Register";
		String actualTitle = driver.findElement(By.className("log-title")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Registration frame title is : " + actualTitle);

	}

	@Test
	public void RegTest_04() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Reporter.log(
				"Verify that Already have an account hyperlink is present and it is redirected to the login page.|||");
		String expectedTitle = "Already have an account";
		String actualResult = driver.findElement(By.linkText(expectedTitle)).getText();
		Assert.assertEquals(expectedTitle, actualResult);
		Reporter.log("Test Case Output: " + actualResult);
		driver.findElement(By.linkText(expectedTitle)).click();
		Assert.assertEquals(driver.getTitle(), "Django Social Network | Login");
		Reporter.log(" |||RegTest_04 Link is present and redirected to correct url");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("Execution successful");
	}

}
