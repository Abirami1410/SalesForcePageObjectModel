package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SalesForcePSM;

public class TaskCreatedPage extends SalesForcePSM{
	public TaskCreatedPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public TaskCreatedPage verifyTask() {
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(text);
		return this;
    }

}
