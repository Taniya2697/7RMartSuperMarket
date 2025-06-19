package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	@Test(description = "Adding new category to the category list")
	public void verifyThatTheUSerIsAbleToAddNewCategory() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnSignInButton();

		CategoryPage categorypage = new CategoryPage(driver);
		homepage.clickOnManageCategoryTab();
		categorypage.clickOnNewButtonToCreateNewCategory().enterCategoryNameOnCategoryField().clickOnDiscount()
				.scrollDown().uploadImage().selectTheRadioButtonOptionForShowOnTopMenu()
				.selectTheRadioButtonOptionForShowOnLeftMenu().clickOnSaveButton();

		boolean isAddCategoryPageDisplayed = categorypage.CategoryCreatedSuccessfullyAlertDisplayed();
		Assert.assertTrue(isAddCategoryPageDisplayed, "User is unable to add the category.");
		/*
		 * String actual=categorypage.CategoryCreatedSuccessfullyAlertDisplayed();
		 * String expected="Category Created Successfully"; Assert.assertEquals(actual,
		 * expected,"User was not able to add the new category");
		 */
	}

	@Test(description = "Searching the newly added category from the category list")
	public void verifyThatTheUserIsAbleToSearchAndFindAddedCategories() throws IOException {
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnSignInButton();

		CategoryPage categorypage;
		categorypage=homepage.clickOnManageCategoryTab();
		categorypage.clickOntheSearchButtonFromListCategoriesPage().enterTheKeywordToBeSearchedInTheCategoryTextField()
				.clickOnSearchButtonToIntiliazeSearchingTheEnteredKeyword();
		String actual = categorypage.listCategoriesPageDisplayed();
		String expected = "Couponss";
		Assert.assertEquals(actual, expected, "user was not able to find the searched result");

	}

}
