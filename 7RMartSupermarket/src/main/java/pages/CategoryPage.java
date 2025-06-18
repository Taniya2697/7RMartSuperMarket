package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements to create category

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefilebutton;
	@FindBy(xpath = "//input[@wfd-id='id4']")
	private WebElement showontopmenunooption;
	@FindBy(xpath = "//input[@wfd-id='id6']")
	private WebElement showonleftmenunooption;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement categorycreatedsuccessfullyalert;

	// WebElements to search added category
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement listcategorysearchbutton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchlistcategoriescategoryfield;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchlistcategoriessearchbutton;
	@FindBy(xpath = "//td[text()='Couponss']")
	private WebElement searchcategoryresult;

	public CategoryPage clickOnNewButtonToCreateNewCategory() {
		newbutton.click();
		return this;
	}

	public CategoryPage enterCategoryNameOnCategoryField() {
		categoryfield.sendKeys(Constant.NEWCATEGORYNAME);
		return this;
	}

	public CategoryPage clickOnDiscount() {
		discount.click();
		return this;
	}

	public CategoryPage scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		return this;
	}

	public CategoryPage uploadImage() {
		choosefilebutton.sendKeys(Constant.TESTIMAGEFILE);
		return this;
	}

	public CategoryPage selectTheRadioButtonOptionForShowOnTopMenu() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, showontopmenunooption);
		PageUtility page = new PageUtility();
		page.selectRadioButton(showontopmenunooption);
		return this;

		/*
		 * showontopmenunooption.click(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.elementToBeClickable(showontopmenunooption));
		 * showontopmenunooption.click();
		 */

	}

	public CategoryPage selectTheRadioButtonOptionForShowOnLeftMenu() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, showonleftmenunooption);
		PageUtility page = new PageUtility();
		page.selectRadioButton(showonleftmenunooption);
		return this;

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.elementToBeClickable(showonleftmenunooption));
		 * showonleftmenunooption.click();
		 */
	}

	public CategoryPage clickOnSaveButton() {
		PageUtility page = new PageUtility();
		page.scrollDown(driver);
		savebutton.click();
		return this;
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,300)", "");
		 */

	}

	// assertion
	public boolean CategoryCreatedSuccessfullyAlertDisplayed() {
		return categorycreatedsuccessfullyalert.isDisplayed();
	}

	public CategoryPage clickOntheSearchButtonFromListCategoriesPage() {
		listcategorysearchbutton.click();
		return this;
	}

	public CategoryPage enterTheKeywordToBeSearchedInTheCategoryTextField() {
		searchlistcategoriescategoryfield.sendKeys(Constant.SEARCHCATEGORYNAME);
		return this;
	}

	public CategoryPage clickOnSearchButtonToIntiliazeSearchingTheEnteredKeyword() {
		searchlistcategoriessearchbutton.click();
		return this;
	}

	// asssertion
	public String listCategoriesPageDisplayed() {
		return searchcategoryresult.getText();
	}

}
