package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;

public class Base 
{
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws Exception
	{
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browsers.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		if(browsers.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
	ScreenShotUtility screenShot=new ScreenShotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName());
	}
	//driver.quit();

	}

}
