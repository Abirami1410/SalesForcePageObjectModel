 package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.SalesForcePSM;
import page.LoginPage;

public class CreateTaskTest extends SalesForcePSM {

	@BeforeTest
	public void setup() {

		sheet="NewTask";
		//step 4 connectivity: create a test cases and assign test details
		testName="CreateTaskTest";
		testDescription="Create task with mandatory information";
		testCategory="functional testing";
		testAuthor="Abirami";
		}

	@Test(dataProvider="fetchData")
      public void runCreateTask(String uname,String pwd,String sub) throws IOException {
	      LoginPage lp=new LoginPage(driver,node);
	      lp.enterUserName(uname)
	      .enterPassword(pwd)
	      .clickLoginButton()
	      .clickAppLauncherIcon()
	      .clickViewAll()
	      .enterSales()
	      .clickSales()
	      .clickTask()
	      .clickNewTaskIcon()
	      .clickNewTaskbutton()
	      .enterStatus()
	      .enterSubject(sub)
	      .clickSave()
	      .verifyTask();

	}
}
