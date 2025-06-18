package pages;

import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements to add new admin user
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertypedropdown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement usercreatedsuccessfullyalert;

	// WebElements to search added admin user
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement adminuserssearchbutton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchusernamefield;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchusertypedropdown;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchbutton;
	@FindBy(xpath = "//td[text()='Akhil TR']")
	private WebElement searchmanageadminuserresult;

	

	public AdminUsersPage clickOnNewButtonToAddNewAdminUser() {
		newbutton.click();
		return this;
	}

	public AdminUsersPage enterTheAdminUserNameInTheUserNameField(String usernameadmin) {
		usernamefield.sendKeys(usernameadmin);
		return this;
	}

	public AdminUsersPage enterTheAdminPasswordInPasswordField(String passwordadmin) {
		passwordfield.sendKeys(passwordadmin);
		return this;
	}

	public AdminUsersPage selectTheAdminUserTypeFromTheDropDownList() {
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(usertypedropdown,Constant.USERTYPE);
		return this;
		
		//Select select = new Select(usertypedropdown);
		//select.selectByVisibleText("Staff");
	}

	public AdminUsersPage saveTheDetailsEnteredOfNewUser() {
		WaitUtility wait=new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	// assertion
	public boolean alertUserCreatedSuccessfullyDisplayed() {
		return usercreatedsuccessfullyalert.isDisplayed();
	}

	public AdminUsersPage clickTheSearchButtonOnAdminUsersPage() {
		adminuserssearchbutton.click();
		return this;
	}

	public AdminUsersPage enterTheUsernameTobeSearchedInTheUsernameField() {
		searchusernamefield.sendKeys(Constant.SEARCHADMINUSERNAME);
		return this;
	}

	public AdminUsersPage selectTheUserTypeToBeSearchedFromTheUserTypeDropDown() {
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(searchusertypedropdown, Constant.USERTYPE);
		//Select select = new Select(searchusertypedropdown);
		//select.selectByVisibleText("Staff");
		return this;
	}

	public AdminUsersPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public String manageUserSearchPageDisplayed() {
		return searchmanageadminuserresult.getText();
	}

}
