package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Add new news web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterthenewstextfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newscreatedsuccessfullyalert;

	// Search added news web elements
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchbutton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchtextfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchsubmitbutton;
	@FindBy(xpath = "//td[text()='Heavy Rainfall Expected Tommorrow']")
	private WebElement searchresult;

	public ManageNewsPage clickonNewButtonToAddNewNews() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage enterTheNewsInTheTextFieldDisplayed() {
		enterthenewstextfield.sendKeys(Constant.NEWSTOADD);
		return this;
	}

	public ManageNewsPage clickOnSaveButtonToSaveTheNewNewsAdded() {
		savebutton.click();
		return this;
	}

	// assertion
	public boolean alertNewsCreatedSuccessfullyDisplayed() {
		return newscreatedsuccessfullyalert.isDisplayed();
	}

	public ManageNewsPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public ManageNewsPage enterTheNewsToBeSearchedInTheTextFieldProvided() {
		searchtextfield.sendKeys(Constant.SEARCHNEWS);
		return this;
	}

	public ManageNewsPage clickOnSearchSubmitButton() {
		searchsubmitbutton.click();
		return this;
	}

	// assertion
	public String manageNewsSearchPageDisplayed() {
		return searchresult.getText();
	}

}
