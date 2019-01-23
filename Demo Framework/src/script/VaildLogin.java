
package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class VaildLogin extends BaseTest {
	@Test(priority=1)
	public void testValidLogin(){
		String un=FWUtil.getXlData(XL_PATH,"ValidLogin",1,0);
		String pw=FWUtil.getXlData(XL_PATH,"ValidLogin",1,1);
		String title=FWUtil.getXlData(XL_PATH,"ValidLogin",1,2);
		//Enter Valid User Name
		LoginPage l=new LoginPage(driver);
		l.setusername(un);
		//Enter Valid password
		l.setPassword(pw);
		//Click on login button
		l.clickLogin();
		Assert.fail();
		//Verify Home Page is Disaplayed...
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyHomePageISDisplayed(driver,ETO,title);
	}
}
