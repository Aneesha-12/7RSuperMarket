package testSript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.UserAdminPage;
import Pages.HomePage;
import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class UserAdminPageTest extends Base{
	HomePage homepage;
	UserAdminPage adminpage;
	FakerUtility faker = new FakerUtility();
	
  @Test(description = "Varify new user successfully added to admin page",retryAnalyzer = retry.Retry.class)//retry
  public void verify_Admin_MoreInfo() throws IOException {
	  LoginPage login = new LoginPage(driver);
	  String username=ExcelUtility.readStringData(1, 0, "AdminPageTest");
	  String password=ExcelUtility.readStringData(1, 1, "AdminPageTest");
	  login.enterUsernamePassword(username,password);
	  homepage=login.LoginButton();
	  adminpage=homepage.clickMoreInfo();
	  String newusername=faker.getFakeFirstName();
	  String newuserpassword = faker.getPassword();
	  adminpage.newButton().enter_UsernameAnd_PasswordFor_NewUser(newusername,newuserpassword).userType_Dropdown().saveButton();
	  boolean isnewuseralertdisplayed =adminpage.isNewUserAlertDisplayed();
	  Assert.assertTrue(isnewuseralertdisplayed,Constant.ERRORMESSAGEFORNEWUSER);
  }
}
