package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class UserAdminPage {
	WebDriver driver;
	PageUtility utility = new PageUtility();
	
	public UserAdminPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement typefield;
	
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertclose;
	
	public UserAdminPage enter_UsernameAnd_PasswordFor_NewUser(String usernamefield,String passwordfield)
	{
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}
	
	public UserAdminPage newButton()
	{
		newbutton.click();
		return this;
	}
	
	public UserAdminPage userType_Dropdown()
	{
		utility.selectByIndex(typefield, 1);
		return this;
		//Select select= new Select(typefield);
		//select.selectByIndex(1);
	}
	
	public UserAdminPage  saveButton()
	{
		save.click();
		return this;
	}
	
	public boolean isNewUserAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
	public void alertClose()
	{
		alertclose.click();
	}

}
