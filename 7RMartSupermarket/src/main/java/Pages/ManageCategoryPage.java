package Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;


public class ManageCategoryPage 
{
	WebDriver driver;
	FileUploadUtility file = new FileUploadUtility();
    WaitUtility wait = new WaitUtility();
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	
	@FindBy(xpath = "//div[@class='ms-selectable']")
	WebElement discount;
	
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	
	@FindBy(xpath = "(//input[@value='no'])[1]")
	WebElement topmenu_no;
	
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public ManageCategoryPage newButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageCategoryPage categoryBox(String entercategoryname)
	{
		category.sendKeys(entercategoryname);
		return this;
	}
	
	public ManageCategoryPage discountButton()
	{
		discount.click();
		return this;
	}
	
	public ManageCategoryPage chooseFileButton() throws IOException
	{
		file.sendkeysFor_FileUpload(choosefile, Constant.TESTIMAGE);
		return this;
	}
		
	public ManageCategoryPage topMenu_No_Button()
	{
		wait.element_ToBe_Visible(driver, topmenu_no);
		topmenu_no.click();
		return this;
	}
	
	public ManageCategoryPage save_Button()
	{
		save.click();
		return this;
	}
	
	public ManageCategoryPage scrollDown()
	{
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("window.scrollBy(0,5000)","");
		return this;
	}
	
	public ManageCategoryPage scrollDownActionToTopMenuButton()
	{
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("arguments[0].scrollIntoView(true);",topmenu_no);
		wait.element_ToBe_Clicked(driver, topmenu_no);
		return this;
	}
	
	public boolean isAlertDisplay()
	{
		return alert.isDisplayed();
	}

}
