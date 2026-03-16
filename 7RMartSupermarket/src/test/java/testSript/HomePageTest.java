package testSript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtility;

public class HomePageTest extends Base{
	HomePage homepage;
  @Test(description = "Varify the Logout button is work properly")
  public void verifyLogOutButton() throws IOException {
	  LoginPage login = new LoginPage(driver);
	  String username=ExcelUtility.readStringData(2, 0, "LoginPageTest");
	  String password=ExcelUtility.readStringData(2, 1, "LoginPageTest");
	  login.enterUsernamePassword(username,password);
	  homepage=login.LoginButton();
	  homepage.adminButton().logOutButton();//page chaining
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORHOMEPAGE);//Assertion using assertTrue() method
  }
}
