package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckProductEdition extends BaseTest
{
	@Test(priority=4)
	public void testCheckProductEdition() throws InterruptedException 
	{
		String un = FWUtil.getXlData(XL_PATH, "CheckProductEdition", 1, 0);
		String pw = FWUtil.getXlData(XL_PATH, "CheckProductEdition", 1, 1);
		String productEdition = FWUtil.getXlData(XL_PATH, "CheckProductEdition", 1, 2);
		//Enter valid User Name
		LoginPage l = new LoginPage(driver);
		l.setusername(un);
		//Enter valid Pass Word
		l.setPassword(pw);
		//Click Login
		l.clickLogin();
		Thread.sleep(1000);
		//Click settings
		EnterTimeTrackPage e  =  new EnterTimeTrackPage(driver);
		e.clickSettings();
		//Click Licenses 
		e.clickLicenses();
		//verify Product Edition 
		LicensePage c =  new LicensePage(driver);
		c.verifyProductEdition(productEdition);
		//Click logout
		c.clickLogout();
	}

}
