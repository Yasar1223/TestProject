package script;

import org.junit.Assert;
import org.junit.Test;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

public class TC2 {
	static int p = 0;
	static int f = 0;

	public void m1(ITestResult res) {
		String name = res.getName();
		int status = res.getStatus();

		if (status == 1) {
			p++;
		} else {
			f++;
		}
		Reporter.log(name + "staus:" + status, true);
	}

	@AfterSuite
	public void print() {
		Reporter.log("Pass:" + p, true);
		Reporter.log("Fail:" + f, true);

	}

	@Test
	public void testA() {
		Reporter.log("Run TestA...", true);
	}

	@Test
	public void testB() {
		Reporter.log("Run TestB...", true);
		Assert.fail();
	}

}
