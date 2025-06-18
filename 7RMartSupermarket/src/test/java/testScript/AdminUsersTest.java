package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {

	@Test(description = "adding new user to the users list", retryAnalyzer = retry.Retry.class)
	public void verifyThatTheUserIsAbleToAddNewAdminUSer() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnSignInButton();

		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		homepage.clickOnAdminUsersMoreInfoTab();
		RandomDataUtility random = new RandomDataUtility();
		String usernameadmin = random.createRandomUserName();
		String passwordadmin = random.createRandomPassword();
		adminuserspage.clickOnNewButtonToAddNewAdminUser().enterTheAdminUserNameInTheUserNameField(usernameadmin)
				.enterTheAdminPasswordInPasswordField(passwordadmin).selectTheAdminUserTypeFromTheDropDownList()
				.saveTheDetailsEnteredOfNewUser();

		// adminuserspage.enterTheAdminUserNameInTheUserNameField(usernameadmin);

		// adminuserspage.enterTheAdminPasswordInPasswordField(passwordadmin);
		// adminuserspage.selectTheAdminUserTypeFromTheDropDownList();
		// adminuserspage.saveTheDetailsEnteredOfNewUser();
		boolean isAdminUsersDisplayed = adminuserspage.alertUserCreatedSuccessfullyDisplayed();
		Assert.assertTrue(isAdminUsersDisplayed, "User is unable to add new admin user.");
		/*
		 * String actual=adminuserspage.alertUserCreatedSuccessfullyDisplayed(); String
		 * expected="User Created Successfully"; Assert.assertEquals(actual,
		 * expected,"User was not able to add the new admin user");
		 */
	}

	@Test(description = "searching the newly added admin user from the users list")
	public void verifyThatTheUserIsAbleToSearchAndFindTheNewlyAddedUser() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();

		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
	    homepage.clickOnAdminUsersMoreInfoTab();
		adminuserspage.clickTheSearchButtonOnAdminUsersPage().enterTheUsernameTobeSearchedInTheUsernameField()
		.selectTheUserTypeToBeSearchedFromTheUserTypeDropDown()
		.clickOnSearchButton();
		
		String actual = adminuserspage.manageUserSearchPageDisplayed();
		String expected = "Akhil TR";
		Assert.assertEquals(actual, expected, "user was not able to find the searched result");

	}

}
