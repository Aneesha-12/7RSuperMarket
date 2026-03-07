package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	
	public ManageNewsPage newButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String messagefield)
	{
		news.sendKeys(messagefield);
		return this;
	}
	
	public ManageNewsPage saveButton()
	{
		save.click();
		return this;
	}
	

}
