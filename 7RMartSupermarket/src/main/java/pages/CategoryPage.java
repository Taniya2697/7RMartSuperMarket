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

public class CategoryPage 
{
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")private WebElement managecategorytab;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")private WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")private WebElement categoryfield;
	@FindBy(xpath="//li[@id='134-selectable']")private WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")private WebElement choosefilebutton;
	@FindBy(xpath="//input[@wfd-id='id4']")private WebElement showontopmenunooption;
	@FindBy(xpath="//input[@wfd-id='id6']")private WebElement showonleftmenunooption;
	@FindBy(xpath="//button[@class='btn btn-danger']")private WebElement savebutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement listcategorysearchbutton;
	@FindBy(xpath="//input[@name='un']")private WebElement searchlistcategoriescategoryfield;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchlistcategoriessearchbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement categorycreatedsuccessfullyalert;
	@FindBy(xpath="//td[text()='Vouchers']")private WebElement searchcategoryresult;
	
	public void clickOnManageCategoryTab()
	{
		managecategorytab.click();
	}
	public void clickOnNewButtonToCreateNewCategory()
	{
		newbutton.click();
	}
	public void enterCategoryNameOnCategoryField()
	{
		 categoryfield.sendKeys("Subscription coupons");
	}
	public void clickOnDiscount()
	{
		discount.click();
	}
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)", "");
	}
	public void uploadImage()
	{
	 choosefilebutton.sendKeys(Constant.TESTIMAGEFILE);
	}
	public void selectTheRadioButtonOptionForShowOnTopMenu()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(showontopmenunooption));
		showontopmenunooption.click();
	}
	public void selectTheRadioButtonOptionForShowOnLeftMenu()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(showonleftmenunooption));
		showonleftmenunooption.click();
	}
	public void clickOnSaveButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)", "");
		savebutton.click();
		
	}
	
	public String CategoryCreatedSuccessfullyAlertDisplayed()
	{
		return CategoryCreatedSuccessfullyAlertDisplayed();
	}
	
	public void clickOntheSearchButtonFromListCategoriesPage()
	{
		listcategorysearchbutton.click();
	}
	public void enterTheKeywordToBeSearchedInTheCategoryTextField()
	{
		searchlistcategoriescategoryfield.sendKeys("Gifts And Vouchers");
	}
	public void clickOnSearchButtonToIntiliazeSearchingTheEnteredKeyword()
	{
		searchlistcategoriessearchbutton.click();
	}
	public String listCategoriesPageDisplayed()
	{
		return searchcategoryresult.getText();
	}
	
	
	

}
