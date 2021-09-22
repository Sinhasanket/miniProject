package test.loginRegister;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class driverSuperClass {

    public WebDriver driver;

    @BeforeClass

    public void preCondition()
    {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	driver = new ChromeDriver();

                driver.get("http://127.0.0.1:8000/");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @AfterClass

    public void postCondition() throws InterruptedException

    {

                Thread.sleep(5000);
                driver.quit();

    }

}
