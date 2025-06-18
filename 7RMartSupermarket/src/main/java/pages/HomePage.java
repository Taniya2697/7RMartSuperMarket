package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminnavigationlink;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutoption;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinbutton;
	
	//chaining
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminusersmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
	private WebElement managecategorytab;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and  @class='small-box-footer']")
	private WebElement Managenewsmoreinfo;

	
	public HomePage clickOnAdminDropdownLink() {
		adminnavigationlink.click();
		return this;
	}
	public LoginPage clickOnLogoutOption() {
		logoutoption.click();
		return new LoginPage(driver);
	}

	public String signInPageDisplayed() {
		return signinbutton.getText();
	}
	
	//Chaining of adminusersmodule
	
	public AdminUsersPage clickOnAdminUsersMoreInfoTab() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	//chaining of managecategorymodule
	public CategoryPage clickOnManageCategoryTab() {
		managecategorytab.click();
		return new CategoryPage(driver);
	}
	
	//chaining of managenewsmodule
	public ManageNewsPage clickOnManageNewsTab() {
		Managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

}
