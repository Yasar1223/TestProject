package script;


import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckIssueDate extends BaseTest {
	@Test(priority = 3)
	public void testCheckIssueDate() throws Exception {
		String un = FWUtil.getXlData(XL_PATH, "checkIssueDate", 1, 0);
		String pw = FWUtil.getXlData(XL_PATH, "checkIssueDate", 1, 1);
		String issueDate = FWUtil.getXlData(XL_PATH, "checkIssueDate", 1, 2);
		// Enter vaild User Name
		LoginPage l = new LoginPage(driver);
		l.setusername(un);
		// Enter vaild Password
		l.setPassword(pw);
		// click login
		l.clickLogin();
		Thread.sleep(2000);
		// click settings
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickSettings();
		// click Lisenses
		e.clickLicenses();
		// verify Issue Date
		LicensePage c = new LicensePage(driver);
		c.verifyIssueDate(issueDate);
		// click logout
		c.clickLogout();

	}
}
