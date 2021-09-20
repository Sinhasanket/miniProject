package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_Scripts.driverSuperClass;

public class LoginPage extends driverSuperClass{
	
    @FindBy (id="input")
    private WebElement emailIdField;
    //Locating password Text box

    @FindBy (name ="password")
    private WebElement psswd;

    //Locating Login button
//    @FindBy (xpath="/html/body/div/div/div/div[2]/div/div/form/div[4]/a/span")
//    private WebElement loginBtn;
    @FindBy (xpath="/html/body/div/div/div/div[2]/div/div/form/div[4]/button/span")
    private WebElement loginBtn;
    
    
    @FindBy (xpath="/html/body/div[1]/section/div/div/div/div/div/div[1]/aside/div/ul/li[6]/a")
    private WebElement logoutBtn;
    
    //Initializing the Objects
    public LoginPage(WebDriver driver)

    {
                PageFactory.initElements(driver, this);

    }

    //Specifiying email and psswd

    public void loginGatherly(String userName, String pwd)

    {

                emailIdField.sendKeys(userName);

                psswd.sendKeys(pwd);

    }

    //Clicking on Login button

    public void clickLoginBtn()
    {

                loginBtn.click();

    }
    public void clickLogoutBtn()
    {
    	logoutBtn.click();
    }
	
}
