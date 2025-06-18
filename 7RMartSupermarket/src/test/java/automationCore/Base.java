package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	Properties prop;
	FileInputStream file;
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws Exception {
		prop = new Properties();
		file = new FileInputStream(Constant.CONFIGFILE);
		prop.load(file);
		if (browsers.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browsers.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WaitUtility wait=new WaitUtility();
		wait.implicitWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility screenShot = new ScreenShotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}
