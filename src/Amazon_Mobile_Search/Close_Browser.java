package Amazon_Mobile_Search;
import org.openqa.selenium.WebDriver;
public class Close_Browser 
{
	//Method for closing the application
	public static void closeBrowser(WebDriver driver) 
	{
		try
		{
			//Closing the application
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}