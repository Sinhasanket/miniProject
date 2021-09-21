package TestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainMethod {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int flag = DriverManager.DriverManagers();
  	  Printer print1 = new Printer();
      Test_02 test = new Test_02();

      if(flag ==1) {
    	//Test_02
    	print1.printTestCase("Test_02 -Verify the login frame title");
        String title =test.Tests_02();
        String status = test.Status("Login");
        print1.printResult(title, status);
        
        //Test_03
        print1.printTestCase("Test_03-Verify the login page title");
        print1.printResult(DriverManager.actualTitle, "Test_03 passed");
        
        //Test_04
        print1.printTestCase("Test_04-Verify the company logo is present");
        String title4=test.Tests_04();
        String status4= test.Status("Gatherly");
        print1.printResult(title4, status4);
        //Test_05
        print1.printTestCase("Test_05 Verify that forgot password hyperlink is present and it is redirected to the forgot password page");
        String title5=test.FindElementbylink("Forgot Password?");
        String status5=test.Status( "Forgot Password?");
        print1.printResult(title5, status5,"Forgot password link is present");
        test.redirect("Forgot Password?","Forgot Password?");
        
        //Test_06
        print1.printTestCase("Test_06- Verify that Follow us on hyperlink is present and it is redirected to the Gatherly facebook page");
        String title6=test.FindElementbylink("Follow Us on");
        String status6=test.Status("Follow Us on");
        print1.printResult(title6, status6,"Follow Us on hyperlink is present");
        test.redirect("Follow Us on","Facebook-Login Page");
        
        //Test_07
        print1.printTestCase("Test_07- Verify that take the tour hyper link is present and it is redirected to the Gatherly tour page");
        String title7=test.FindElementbylink("Take the tour");
        String status7=test.Status("Take the tour");
        print1.printResult(title7, status7,"Take the tour hyperlink is present");
        test.redirect("Take the tour","Gatherly- Take the tour");
        
        //Test_08
        print1.printTestCase("Test-08 Verify that Join now hyperlink is present and it is redirected to the Gatherly subscription page");
        String title8= test.FindElementbylink("Join now");
        String status8= test.Status("Join now");
        print1.printResult(title8, status8,"Join now hyperlink is present");
        test.redirect("Join now","Gatherly-Join now");
        
        //Test-09
        print1.printTestCase("Test_09- Verify the invalid login");
        test.test_01("test12345@gmail.com","123456");
        //Test_01
        print1.printTestCase("Test_01- Verify the valid login");
        test.test_01("test@gmail.com","123456");
        DriverManager.quit();
        
      }
      else
      {   DriverManager.quit();
          print1.quit();
      
       }
  
    	 // print1.printTestCase("Test_01- Verify the invalid login");
         // test.test_01("test12345@gmail.com","123456");
          

	}

}
