package test.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	public  static WebDriver driver = new ChromeDriver();
    public  static String baseUrl = "http://127.0.0.1:8000/accounts/login";
    public  static String expectedTitle ="Django Social Network | Login";
    public  static String actualTitle;
    
    public  static int DriverManagers() {
    	driver.get(baseUrl);
    	actualTitle=driver.getTitle();
    	if(actualTitle.equals(expectedTitle))
    		return 1;
    	else
    		return 0;
    
    }
    public static void  quit() {driver.quit();
}
}