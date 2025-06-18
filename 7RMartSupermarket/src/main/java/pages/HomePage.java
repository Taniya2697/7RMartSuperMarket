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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminusersmoreinfo;

	
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
	public AdminUsersPage clickOnAdminUsersMoreInfoTab() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}

}
