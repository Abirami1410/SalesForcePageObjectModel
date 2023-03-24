package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.SalesForcePSM;
import page.LoginPage;

public class LoginTest extends SalesForcePSM {
	@BeforeTest
	public void setup() {

		sheet="Login";
		//step 4 connectivity: create a test cases and assign test details
		testName="LoginTest";
		testDescription="Login for salesforce application";
		testCategory="smoke";
		testAuthor="Abirami";
	}

@Test(dataProvider="fetchData")
	public void runLoginTest(String uname,String pwd) throws IOException {
	LoginPage lp=new LoginPage(driver,node);
	lp.enterUserName(uname)
	.enterPassword(pwd)
	.clickLoginButton();
}
}
