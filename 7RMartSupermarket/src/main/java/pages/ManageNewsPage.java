package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and  @class='small-box-footer']")private WebElement Managenewsmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enterthenewstextfield;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	@FindBy(xpath="class=\"alert alert-success alert-dismissible\"")private WebElement newscreatedsuccessfullyalert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchbutton;
	@FindBy(xpath="//input[@class='form-control']")private WebElement searchtextfield;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement searchsubmitbutton;
	@FindBy(xpath="//h4[text()='Search Manage News']")private WebElement searchmanagenewsresult;
	
	
	public void clickOnManageNewsTab()
	{
		Managenewsmoreinfo.click();
	}
	public void clickonNewButtonToAddNewNews()
	{
		newbutton.click();
	}
	public void enterTheNewsInTheTextFieldDisplayed()
	{
		enterthenewstextfield.sendKeys("Heavy Rainfall Expected Tommorrow");
	}
	public void clickOnSaveButtonToSaveTheNewNewsAdded()
	{
		savebutton.click();
	}
	public String alertNewsCreatedSuccessfullyDisplayed()
	{
		return newscreatedsuccessfullyalert.getText();
	}
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	public void enterTheNewsToBeSearchedInTheTextFieldProvided()
	{
		searchtextfield.sendKeys("Heavy Rainfall Expected Tommorrow");
	}
	public void clickOnSearchSubmitButton()
	{
		searchsubmitbutton.click();
	}
	
	public String manageNewsSearchPageDisplayed()
	{
		return searchmanagenewsresult.getText();
	}
	
	

}
