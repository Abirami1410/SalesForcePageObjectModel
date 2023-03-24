package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.SalesForcePSM;

public class LoginPage extends SalesForcePSM {
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}

	public LoginPage enterUserName(String uname) throws IOException {
		try {
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
			reportStep(uname+"username is entered successfully","pass");
			
		} catch (Exception e) {
			reportStep("username is not entered successfully..."+e,"fail");
	
		}
		return this;
    }
	
	public LoginPage enterPassword(String pwd) throws IOException{
		try {
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	        reportStep(pwd+"password is entered successfully","pass");	
		} catch (Exception e) {
			reportStep("password is not entered successfully..."+e,"fail");
	
		}
		return this;
    }

	public HomePage clickLoginButton() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
        return new HomePage(driver);
	}
	
}
