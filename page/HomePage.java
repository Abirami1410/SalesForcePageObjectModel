package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SalesForcePSM;

public class HomePage extends SalesForcePSM{
	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	public HomePage clickAppLauncherIcon() {
		// Click on Global Actions SVG icon
        // Click on toggle menu button
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        return this;
	}
	public AppLauncherPage clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        return new AppLauncherPage(driver);
	}

}
