package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Signing in to the application using valid credentials", priority = 1, groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		// boolean isDashboardDisplayed=loginpage.dashboardDisplayed();
		// Assert.assertTrue(isDashboardDisplayed, "User was unable to login with valid
		// credentails");
		String actual = loginpage.dashboardDisplayed();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, "User was unable to login with valid credentails");
	}

	@Test(description = "Signing in to the application using valid username and invalid password", priority = 2, groups = {
			"smoke" })
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}

	@Test(description = "Signing in to the application using valid username and invalid password", priority = 3)
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}

	@Test(description = "Signing in to the application using invalid credentials", priority = 4, dataProvider = "logindata")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException {
		// String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		// String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String actual = loginpage.signInPageDisplayed();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "User was able to login with invalid credentials");
	}

	@DataProvider(name = "logindata")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Test1", "Test2" }, new Object[] { "Test3", "Test4" } };
		//or we can pass values through excel file
		//return new Object[][] { new Object[] {  ExcelUtility.getStringData(2, 0, "LoginPage")};
	}
}
