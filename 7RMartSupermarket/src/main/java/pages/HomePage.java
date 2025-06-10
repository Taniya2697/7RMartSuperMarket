package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement adminnavigationlink;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")private WebElement logoutoption;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement signinbutton;
	
	public void clickOnAdminDropdownLink()
	{
		adminnavigationlink.click();
	}
	public void clickOnLogoutOption()
	{
		logoutoption.click();
	}
	public String signInPageDisplayed()
	{
		return signinbutton.getText();
	}

	

}
