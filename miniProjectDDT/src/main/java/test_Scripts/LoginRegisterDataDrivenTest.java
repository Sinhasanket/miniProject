package test_Scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RegisterPage;
import dataProvider.loginExcel;
import dataProvider.registerExcel;

public class LoginRegisterDataDrivenTest extends driverSuperClass{
	
@Test (dataProvider= "testdataForLogin" , dataProviderClass = loginExcel.class)
public void adminLogin(String UName, String pwd) throws InterruptedException, IOException {
	LoginPage login = new LoginPage(driver);
	
	login.loginGatherly(UName, pwd);
	
	login.clickLoginBtn();
	
	Thread.sleep(3000);
	
	String url=driver.getCurrentUrl();
	
	Assert.assertEquals(url, "http://127.0.0.1:8000/");
}

@Test (dataProvider= "testdataForRegister" , dataProviderClass = registerExcel.class)	
public void adminRegister(String email,String Uname, String pwd1, String pwd2, String gen) throws InterruptedException, IOException {
	RegisterPage register= new RegisterPage(driver);
	
	register.clickRegisterBtn1();
	
	register.registerGatherly(email, Uname, pwd1, pwd2, gen);
	
	register.clickRegisterBtn2();
		
	Thread.sleep(3000);
	
	String url=driver.getCurrentUrl();
	
	Assert.assertEquals(url, "http://127.0.0.1:8000/accounts/login");
	}	

            
}