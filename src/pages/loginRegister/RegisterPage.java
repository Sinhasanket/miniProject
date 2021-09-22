package pages.loginRegister;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.loginRegister.driverSuperClass;

public class RegisterPage extends driverSuperClass{
	
	@FindBy (xpath="/html/body/div/div/div/div[2]/div/div/form/div[4]/a/span")
	private WebElement registerBtn1;
	
    @FindBy (name="email")
    private WebElement emailIdField;
    //Locating password Text box

    @FindBy (name="username")
    private WebElement userName;
    
    @FindBy (name="password1")
    private WebElement password1;
    
    @FindBy (name ="password2")
    private WebElement password2;
    
    @FindBy (name="gender")
    private WebElement gender;
    

    //Locating Login button
    @FindBy (xpath="/html/body/div/div/div/div[2]/div/div/form/div[7]/button")
    private WebElement registerBtn2;
    
    //Initializing the Objects
    public RegisterPage(WebDriver driver)

    {
                PageFactory.initElements(driver, this);

    }

    //Specifiying email and psswd

    public void registerGatherly(String email, String uName, String pwd1, String pwd2, String gen )

    {

                emailIdField.sendKeys(email);
                userName.sendKeys(uName);
                password1.sendKeys(pwd1);
                password2.sendKeys(pwd2);
                gender.sendKeys(gen);


    }
    
    public void clickRegisterBtn1()
    {

                registerBtn1.click();

    }

    //Clicking on register button

    public void clickRegisterBtn2()
    {

                registerBtn2.click();

    }
    


}
