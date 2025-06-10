package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base
{
	@Test
	public void verifyThatTheUSerIsAbleToAddNewCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnManageCategoryTab();
		categorypage.clickOnNewButtonToCreateNewCategory();
		categorypage.enterCategoryNameOnCategoryField();
		categorypage.clickOnDiscount();
		categorypage.scrollDown();
		categorypage.uploadImage();
		categorypage.selectTheRadioButtonOptionForShowOnTopMenu();
		categorypage.selectTheRadioButtonOptionForShowOnLeftMenu();
		categorypage.clickOnSaveButton();
		String actual=categorypage.CategoryCreatedSuccessfullyAlertDisplayed();
		String expected="Category Created Successfully";
		Assert.assertEquals(actual, expected,"User was not able to add the new category");
	}
	
	@Test
	public void verifyThatTheUserIsAbleToSearchAndFindAddedCategories() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		

		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnManageCategoryTab();
		categorypage.clickOntheSearchButtonFromListCategoriesPage();
		categorypage.enterTheKeywordToBeSearchedInTheCategoryTextField();
		categorypage.clickOnSearchButtonToIntiliazeSearchingTheEnteredKeyword();
		String actual=categorypage.listCategoriesPageDisplayed();
		String expected="Vouchers";
		Assert.assertEquals(actual, expected,"user was not able to find the searched result");
		
	}


}
