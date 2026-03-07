package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement admin;
	
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logout;
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	WebElement moreinfoadmin;
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	WebElement moreinfomanagecategory;
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[7]")
	WebElement moreinfomanagenews;
	
	public HomePage adminButton()
	{
		admin.click();
		return this;
	}
	
	public HomePage logOutButton()
	{
		logout.click();
		return this;
	}
	
	public UserAdminPage clickMoreInfo()
	{
		moreinfoadmin.click();
		return new UserAdminPage(driver);
	}
	
	public ManageCategoryPage clickMoreInfoManageCategory()
	{
		moreinfomanagecategory.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageNewsPage clockMoreInfoManageNews()
	{
		moreinfomanagenews.click();
		return new ManageNewsPage(driver);
	}

}
