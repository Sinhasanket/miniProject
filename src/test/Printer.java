package TestLogin;

public class Printer {

	public void printTestCase(String testcase){
		System.out.println("________________________________________________");
		System.out.println(testcase);
	}
	public void printResult(String title, String status) {
		System.out.println("Component under test: " +title);
    	System.out.println("Test case status: "+status);
    	System.out.println("__________________________________________________");
	}
	public void printResult(String title, String status,String message) {
		System.out.println("Component under test: " +title);
    	System.out.println("Test case status: "+status);
    	System.out.println("Message :"+message);
	}
	public void printMessage(String message)
	{
		System.out.println(message);
	}
	public void quit()
	{
		System.out.println("Please check the url");
	}
}
