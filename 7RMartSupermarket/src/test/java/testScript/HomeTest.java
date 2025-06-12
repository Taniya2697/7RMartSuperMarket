package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	@Test(description="logging out the user from the application")
	public void verifyThatUserIsAbleToLogoutFromTheApplication() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminDropdownLink();
		homepage.clickOnLogoutOption();
		String actual=homepage.signInPageDisplayed();
		String expected="Sign In";
		Assert.assertEquals(actual, expected,"User has not logged out from the application");
	}
	
	

}
