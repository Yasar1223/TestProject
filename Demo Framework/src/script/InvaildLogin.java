package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.LoginPage;

public class InvaildLogin extends BaseTest {
	@Test(priority = 2)
	public void testInvaildLogin() throws InterruptedException {
		int rc = FWUtil.getXlRowCount(XL_PATH, "InvalidLogin");
		Reporter.log("RC:" + rc, true);
		for (int i = 1; i <= rc; i++) {
			String un = FWUtil.getXlData(XL_PATH, "InvaildLogin", i, 0);
			String pw = FWUtil.getXlData(XL_PATH, "InvaildLogin", i, 1);
			// Enter invaild user name
			LoginPage l = new LoginPage(driver);
			l.setusername(un);
			// Enter invaild password
			l.setPassword(pw);
			// Click login button
			l.clickLogin();
			Thread.sleep(1000);
			// Verify Err MSG is Displayed
			l.verifymsgDisplayed();
		}
	}
}