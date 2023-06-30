package Test;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import Amazon_Mobile_Search.DriverSetup;
import Amazon_Mobile_Search.Mobile_Search;
import Amazon_Mobile_Search.Validate_Message;
import Amazon_Mobile_Search.Newest_Arrival;
import Amazon_Mobile_Search.Close_Browser;
public class Main
{
	public static void main(String[] args)
	{
		try
		{
			WebDriver driver=null;
			//Opening the application in the desired browser
			driver=DriverSetup.getDriver();
			//Searching mobiles under 30000
			String result=Mobile_Search.mobileSearch(driver);
			//Validating the application displays the correct message 
			//on searching mobiles under 30000
			boolean bool=Validate_Message.validate_Message(result);
			Assert.assertEquals(true,bool);
			//Selecting the "Newest Arrivals" option
			int check=Newest_Arrival.newestArrival(driver);
			//Valdating the "Newest Arrivals" option gets selected correctly
			Assert.assertEquals(1,check);
			//Closing the application
			Close_Browser.closeBrowser(driver);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}