package Amazon_Mobile_Search;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Mobile_Search 
{
	//Method for searching mobiles under 30000
	public static String mobileSearch(WebDriver driver) 
	{
		String result="";
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
			//Locating the search box
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile smartphones under 30000");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
			//Clicking the search button
			driver.findElement(By.id("nav-search-submit-button")).click();
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			//Scrolling down the window
			jse.executeScript("window.scrollBy(0,550)", "");
			//Retrieving the message after searching mobiles under 30000
			String message1=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText();
			String message2=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[2]")).getText();
			String message3=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
			result=message1+message2+message3;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
}