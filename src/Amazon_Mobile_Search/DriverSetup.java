package Amazon_Mobile_Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.*;
import java.io.*;
public class DriverSetup 
{
	static WebDriver driver=null;
	//Method for getting the driver for the desired browser
	public static WebDriver getDriver() 
	{	
		try
		{
			Properties property=new Properties();
			FileInputStream fis=new FileInputStream("./resources/config.properties");
			property.load(fis);
			String bname=property.getProperty("browser");
			String url=property.getProperty("url");
			if(bname.equalsIgnoreCase("chrome"))
			{
				//Driver for Chrome browser
				System.setProperty("webdriver.chrome.driver","C:\\Users\\2271264\\OneDrive - Cognizant\\Desktop\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(bname.equalsIgnoreCase("edge"))
			{
				//Driver for Edge browser
				driver=new EdgeDriver();
			}
			//Maximizing the window
			driver.manage().window().maximize();
			//Method for opening the application
			driver.get(url);
		}
		catch(Exception e)
		{
			Close_Browser.closeBrowser(driver);
			System.out.println("Application failed to open....."+"\n"+e.getMessage());
		}
		return driver;
	}
}