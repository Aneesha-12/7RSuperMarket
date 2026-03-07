package testSript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import constants.Constant;

public class HomePageTest extends Base{
	HomePage homepage;
  @Test
  public void verifyLogOutButton() {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernamePassword("admin", "admin");
	  homepage=login.LoginButton();
	  homepage.adminButton().logOutButton();//page chaining
	 
	  
/*	  page.clickLoginButton();
	  HomePageSupermarket home = new HomePageSupermarket(driver);
	  home.adminClick();
	  home.logOutClick();  */
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected,Constant.ERRORMESSAGEFORHOMEPAGE);//Assertion using assertTrue() method
  }
}
