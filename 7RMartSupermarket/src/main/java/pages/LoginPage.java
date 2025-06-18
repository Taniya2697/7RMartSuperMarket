package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;

	public LoginPage enterUserNameOnUserNameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickOnSignInButton() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public String dashboardDisplayed() {
		return dashboard.getText();
	}

	public String signInPageDisplayed() {
		return signinbutton.getText();
	}

}
