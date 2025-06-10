package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		//boolean isDashboardDisplayed=loginpage.dashboardDisplayed();
		//Assert.assertTrue(isDashboardDisplayed, "User was unable to login with valid credentails");
		String actual=loginpage.dashboardDisplayed();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, "User was unable to login with valid credentails");
	}
	
	@Test
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		String actual=loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}
	
		
	
	@Test
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		String actual=loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}
		
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		String actual=loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}
}
	

