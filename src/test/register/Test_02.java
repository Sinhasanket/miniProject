package test.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02 extends DriverManager{
	String title;
	String expectedFrameTitle;

	public String Tests_02() {
		title= driver.findElement(By.className("log-title")).getText();
		return title;
	}
	    
	    public String Status(String passedTitle) {
	    expectedFrameTitle=passedTitle;
        if(title.equals(expectedFrameTitle)) 
        	return "Passed";
        else 
            return "Failed";	
        }
	    
	    public String Tests_04() {
	        title = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/h1")).getText();
			return title;
		}
	    
	    public String FindElementbylink(String hyperlink) {
	        title =driver.findElement(By.linkText(hyperlink)).getText();
	        return title;

	    }
	    
	    public void redirect(String getText, String hyperlink) {
	    	 driver.findElement(By.linkText(getText)).click();
	         if(driver.getTitle().equals(hyperlink)) {
	      	   System.out.println(getText+" url redirected to correct page");
	         }
	         else System.out.println("Test case Status failed : Redirected to wrong url/ Redirected link is not present");
	    }
	    
	    public void test_01(String email,String password) {
	    	driver.findElement(By.id("input")).clear();
        	driver.findElement(By.id("input")).sendKeys(email);
        	driver.findElement(By.name("password")).clear();
        	driver.findElement(By.name("password")).sendKeys(password);
        	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/form/div[4]/button")).click();
        	if (driver.getTitle().equals("Gatherly Social Network Toolkit")) {
        		System.out.println("Login Test case passed and it is redirected to Home page");
        	}
        	else
        		System.out.println("Login failed");

	    }
	    

}
