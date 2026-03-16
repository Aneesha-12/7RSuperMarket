package testSript;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsPageTest extends Base{
	HomePage homepage;
	ManageNewsPage newspage;
	
  @Test(description = "To verify add new news in Manage News page")
  public void varify_News_Message_Added() throws IOException {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.readStringData(2, 0, "LoginPageTest");
	  String password=ExcelUtility.readStringData(2, 1, "LoginPageTest");
	  loginpage.enterUsernamePassword(username,password);
	  homepage=loginpage.LoginButton();
	  newspage = homepage.clockMoreInfoManageNews();
	  newspage.newButton().enterNews(".....Hai All.......").saveButton();
  }
}
