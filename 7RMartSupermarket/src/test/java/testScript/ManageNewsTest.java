package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "Adding new news to the news list")
	public void verifyThatUserIsAbleToAddNewNewsInTheApplication() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnSignInButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		homepage.clickOnManageNewsTab();
		managenewspage.clickonNewButtonToAddNewNews().enterTheNewsInTheTextFieldDisplayed()
				.clickOnSaveButtonToSaveTheNewNewsAdded();

		// assertion
		boolean isManageNewsDisplayed = managenewspage.alertNewsCreatedSuccessfullyDisplayed();
		Assert.assertTrue(isManageNewsDisplayed, "User is unable to add news.");
		/*
		 * String actual=managenewspage.alertNewsCreatedSuccessfullyDisplayed(); String
		 * expected="News Created Successfully"; Assert.assertEquals(actual,
		 * expected,"User was not able to add the news");
		 */

	}

	@Test(description = "Searching newly added news from the news list")
	public void verifyThatUserIsAbleToSearchAndFindTheAddedNews() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnSignInButton();

		ManageNewsPage managenewspage;
		managenewspage = homepage.clickOnManageNewsTab();
		managenewspage.clickOnSearchButton().enterTheNewsToBeSearchedInTheTextFieldProvided()
				.clickOnSearchSubmitButton();
		String actual = managenewspage.manageNewsSearchPageDisplayed();
		String expected = "Heavy Rainfall Expected Tommorrow";
		Assert.assertEquals(actual, expected, "user was not able to find the searched result");

	}

}
