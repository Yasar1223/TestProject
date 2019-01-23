package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst {
	public WebDriver driver;

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);

	}

	public static int passCount = 0, failCount = 0;

	@AfterMethod
	public void closeApp(ITestResult res) {
		String testname = res.getName();
		int status = res.getStatus();
		if (status == 1) {
			passCount++;
		} else {
			failCount++;
			String path = PHOTO_PATH + testname + ".png";
			Reporter.log("PhotoPath:" + path, true);
			FWUtil.getPhoto(driver, path);

		}
		driver.close();
	}

	@AfterSuite
	public void print() {
		FWUtil.setXlData(REPORT_PATH, "sheet1", 1, 0, passCount);
		FWUtil.setXlData(REPORT_PATH, "sheet1", 1, 1, failCount);
	}
}
