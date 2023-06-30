package Amazon_Mobile_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
public class Newest_Arrival 
{
	//Method for displaying the mobiles which are newly arrived 
	public static int newestArrival(WebDriver driver) 
	{
		int flag=0;
		try
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-button-text a-declarative']")));
			driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
			//Locating the "Sort by list" listbox
			Select select=new Select(driver.findElement(By.name("s")));
			//Validating the number of options displayed in the "Sort by list" listbox is correct
			List<WebElement> element=select.getOptions();
			int count=element.size();
			Assert.assertEquals(5,count);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("s-result-sort-select_4")));
			//Selecting the "Newest Arrivals" option from "Sort by list" listbox
			if(flag==0)
			{
				driver.findElement(By.id("s-result-sort-select_4")).click();
				flag=1;
			}
			//Scrolling down the screen
			Thread.sleep(1000);		
			jse.executeScript("window.scrollBy(0,150)", "");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}
}