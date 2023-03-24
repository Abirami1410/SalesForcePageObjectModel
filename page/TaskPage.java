package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SalesForcePSM;

public class TaskPage extends SalesForcePSM {
	public TaskPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public TaskPage clickTask() {
		 WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
	     driver.executeScript("arguments[0].click();",task);
	     return this;   
	}
	public TaskPage clickNewTaskIcon() {
		WebElement newtaskicon = driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
	    driver.executeScript("arguments[0].click();",newtaskicon);
	    return this;   	
	}
	public NewTaskPage clickNewTaskbutton() {
		WebElement newtaskbutton = driver.findElement(By.xpath("//a[@title='New Task']"));
	    driver.executeScript("arguments[0].click();",newtaskbutton);
	    return new NewTaskPage(driver);
	}
	 
	

}
