package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	
	public LoginPage enterUsernamePassword(String usernamefield,String passwordfield)
	{
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}
	public HomePage LoginButton()
	{
		wait.element_ToBe_Clicked(driver, login);//explicit wait using before the action to be performed
		login.click();
		return new HomePage(driver);
	}
	
	public boolean isHomePageDisplayed()
	{
		return dashboard.isDisplayed();//isDisplayed() method return true or false value.
	}

}
