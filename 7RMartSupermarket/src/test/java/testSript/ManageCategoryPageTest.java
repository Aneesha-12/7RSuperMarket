package testSript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageCategoryPage;
import constants.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class ManageCategoryPageTest extends Base{
	HomePage homepage;
	ManageCategoryPage managecategorypage;
	FakerUtility faker = new FakerUtility();
	
  @Test
  public void varify_A_New_Category_Added() throws IOException, AWTException {
	  LoginPage login = new LoginPage(driver);
	  String username=ExcelUtility.readStringData(2, 0, "LoginPageTest");
	  String password=ExcelUtility.readStringData(2, 1, "LoginPageTest");
	  login.enterUsernamePassword(username,password);
	  homepage=login.LoginButton();
	  managecategorypage=homepage.clickMoreInfoManageCategory();
	  String categoryname=faker.getFakeFirstName();
	  managecategorypage.newButton().categoryBox(categoryname)
	  .discountButton().chooseFileButton()
	  .scrollDown().scrollDownActionToTopMenuButton()
	  .topMenu_No_Button();
	  managecategorypage.save_Button();
	/*  boolean IsAlertDisplayed = managecategorypage.isAlertDisplay();
	  Assert.assertTrue(IsAlertDisplayed, Constant.ERRORMESSAGEFORMANAGECATEGORY);
	  System.out.println(driver.getCurrentUrl());
	
	  */
  }
}
