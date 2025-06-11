package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage 
{
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")private WebElement adminusersmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")private WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertypedropdown;
	@FindBy(xpath="//button[@name='Create']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement usercreatedsuccessfullyalert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement adminuserssearchbutton;
	@FindBy(xpath="//input[@id='un']")private WebElement searchusernamefield;
	@FindBy(xpath="//select[@id='ut']")private WebElement searchusertypedropdown;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchbutton;
	@FindBy(xpath="//td[text()='Akhil TR']")private WebElement searchmanageadminuserresult;
	
	public void clickOnAdminUsersMoreInfoTab() 
	{
		adminusersmoreinfo.click();
	}
	
	public void clickOnNewButtonToAddNewAdminUser()
	{
		newbutton.click();
	}
	
	public void enterTheAdminUserNameInTheUserNameField(String usernameadmin)
	{
		usernamefield.sendKeys(usernameadmin);
	}
	
	public void enterTheAdminPasswordInPasswordField(String passwordadmin)
	{
		passwordfield.sendKeys(passwordadmin);
	}
	
	public void selectTheAdminUserTypeFromTheDropDownList()
	{
		Select select=new Select(usertypedropdown);
		select.selectByVisibleText("Staff");
	}
	
	public void saveTheDetailsEnteredOfNewUser()
	{
		savebutton.click();
	}
	
	public String alertUserCreatedSuccessfullyDisplayed()
	{
		return usercreatedsuccessfullyalert.getText();
	}
	
	public void clickTheSearchButtonOnAdminUsersPage()
	{
		adminuserssearchbutton.click();
	}
	
	public void enterTheUsernameTobeSearchedInTheUsernameField()
	{
		searchusernamefield.sendKeys("Akhil TR");
	}
	
	public void selectTheUserTypeToBeSearchedFromTheUserTypeDropDown()
	{
		Select select=new Select(searchusertypedropdown);
		select.selectByVisibleText("Staff");
	}
	
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	
	public String manageUserSearchPageDisplayed()
	{
		return searchmanageadminuserresult.getText();
	}
	
	
	

}
