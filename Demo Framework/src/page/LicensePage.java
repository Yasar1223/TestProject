package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensePage {
	@FindBy(xpath = "//nobr[.='Issue Date:']/../../td[2]")
	private WebElement issueDate;

	@FindBy(id = "logoutlink")
	private WebElement logoutLink;
	
	@FindBy(xpath="//b[contains(.,'actiTime')]")
	private WebElement productEdition;

	public LicensePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductEdition(String expected) {
		String actual = productEdition.getText();
		Reporter.log("Actaul productEdition:" + actual, true);
		Reporter.log("expected productEdition:" + expected, true);
		Assert.assertEquals(actual, expected);
	}

	public void clickLogout() {
		logoutLink.click();
	}

	public void verifyIssueDate(String expected) {
		String actual = issueDate.getText();
		Reporter.log("Actaul IssueDate:" + actual, true);
		Reporter.log("expected IssueDate:" + expected, true);
		Assert.assertEquals(actual, expected);
	}

}
