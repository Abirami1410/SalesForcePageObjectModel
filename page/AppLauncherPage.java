package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SalesForcePSM;

public class AppLauncherPage extends SalesForcePSM{
	public AppLauncherPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public AppLauncherPage enterSales() {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales",Keys.ENTER);
        return this;
	}
	public TaskPage clickSales() {
		// Click Sales from App Launcher
	    driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
        return new TaskPage(driver);
	}

}
