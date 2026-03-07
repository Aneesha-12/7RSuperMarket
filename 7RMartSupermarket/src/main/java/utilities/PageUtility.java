package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	//reused codes are write in this class.To help pages
	public void selectByIndex(WebElement element,int index)
	{
		 Select select = new Select(element);
		 select.selectByIndex(index);
	}
	public void scroll_Down()
	{
		WebDriver driver;
		driver= new ChromeDriver();
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("window.scrollBy(0,5000)","");
		
	}
	public void scroll_Down_Action()
	{
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.PAGE_DOWN).perform();
	}

}
