package testSript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	HomePage homepage;
	
	//Data provider starts---------------------
  @Test(dataProvider = "credential")
  public void verifyValidCredential(String username,String password) 
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernamePassword(username, password);
	  homepage=login.LoginButton();
	  boolean homepageisdisplayed = login.isHomePageDisplayed();
	  Assert.assertTrue(homepageisdisplayed,Constant.ERRORMESSAGEFORLOGIN);//assertion using assertTrue() method
  }
	@DataProvider(name= "credential")
	public Object testData()
	{
		Object data[][]= {{"admin","admin"},{"admin","12345"},{"12345","admin"},{"qwert","asdfg"}};
		return data;
	}
	//Data provider ends--------------------
	
	//Parameter method starts---------------
	@Test
	@Parameters({"usernamefield","passwordfield"})//parameters can run only xml 
	public void varifyInvalidCredential(String username,String password)
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsernamePassword(username, password);
		homepage=login.LoginButton();
	}
	//parameter ends--------------------------
	@Test(groups = "smoke")
	public void varify_Valid_Username_Invalid_Password() throws IOException
	{
		LoginPage login = new LoginPage(driver);
		String username=ExcelUtility.readStringData(1, 0, "LoginPageTest");
		String password=ExcelUtility.readStringData(1, 1, "LoginPageTest");
		login.enterUsernamePassword(username,password);
		homepage=login.LoginButton();
	}
	@Test(groups = "smoke")
	  public void verifyCorrectUsernameAndIncorrectPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username=ExcelUtility.readStringData(3, 0, "LoginPageTest");
		String password=ExcelUtility.readStringData(3, 1, "LoginPageTest");
		login.enterUsernamePassword(username,password);
		homepage=login.LoginButton();
	  } 
}
