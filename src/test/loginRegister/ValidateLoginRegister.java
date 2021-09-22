package test.loginRegister;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dataProvider.loginExcel;
import dataProvider.registerExcel;

public class ValidateLoginRegister{
	WebDriver driver;
	
	@BeforeMethod
	public void preCond() {
		System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
    	driver = new ChromeDriver();

                driver.get("http://127.0.0.1:8000/accounts/login");

	}
	
	
	//Testing register 
	@Test (priority=0, dataProvider= "testdataForRegister", dataProviderClass=registerExcel.class)	
	public void adminRegister(String email,String Uname, String pwd1, String pwd2, String gen) {
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[4]/a/span")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("username")).sendKeys(Uname);
		driver.findElement(By.name("password1")).sendKeys(pwd1);
		driver.findElement(By.name("password2")).sendKeys(pwd2);
		driver.findElement(By.name("gender")).sendKeys(gen);
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[7]/button")).click();
		System.out.println("Verifying Registration for details : "+email+", "+Uname+", "+pwd1+", "+pwd2+", "+gen);
		String url=driver.getCurrentUrl();
		try {
		Assert.assertEquals(url, "http://127.0.0.1:8000/accounts/login");
		}catch(AssertionError e) {
			flag=true;
		}
		finally {
			if(!flag) {
				System.out.println("Registration Succesfully");
			}else
			{
				System.out.println("Registration failed");
			}
			System.out.println("__________________________________________________________________");
		}
	}	
	
	//Testing login
	@Test (priority=1,dataProvider= "testdataForLogin", dataProviderClass=loginExcel.class)
	public void adminLogin(String UName, String pwd) throws InterruptedException, IOException {
		driver.findElement(By.id("input")).sendKeys(UName);
		driver.findElement(By.name("password")).sendKeys(pwd);
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[4]/button/span")).click();
		Thread.sleep(3000);
		System.out.println("Verifying Login successful for details: "+UName+", "+pwd);
		String url=driver.getCurrentUrl();
		try {
		Assert.assertEquals(url, "http://127.0.0.1:8000/");}
		catch(AssertionError e) {
			flag=true;
		}
		finally {
			if(!flag) {
				System.out.println("Login Succesfully");
			}else
			{
				System.out.println("Login failed");
			}
			System.out.println("__________________________________________________________________");
		}
	}
	

	@AfterMethod
	public void postCon() throws InterruptedException {
        
        driver.close();


	}
}
