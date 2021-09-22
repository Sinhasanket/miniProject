package test.loginRegister;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



import dataProvider.loginExcel;
import dataProvider.registerExcel;
import pages.loginRegister.LoginPage;
import pages.loginRegister.RegisterPage;

public class LoginRegisterDataDrivenTest extends driverSuperClass{
	
@Test (dataProvider= "testdataForLogin" , dataProviderClass = loginExcel.class)
public void adminLogin(String UName, String pwd) throws InterruptedException, IOException {
	LoginPage login = new LoginPage(driver);
	
	login.loginGatherly(UName, pwd);
	
	login.clickLoginBtn();
	
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

@Test (dataProvider= "testdataForRegister" , dataProviderClass = registerExcel.class)	
public void adminRegister(String email,String Uname, String pwd1, String pwd2, String gen) throws InterruptedException, IOException {
	RegisterPage register= new RegisterPage(driver);
	
	register.clickRegisterBtn1();
	
	register.registerGatherly(email, Uname, pwd1, pwd2, gen);
	
	register.clickRegisterBtn2();
		
	Thread.sleep(3000);
	
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

            
}