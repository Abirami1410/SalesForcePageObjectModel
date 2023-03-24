package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SalesForcePSM;

public class NewTaskPage extends SalesForcePSM {
	public NewTaskPage(ChromeDriver driver) {
		this.driver=driver;
	}
    public NewTaskPage enterStatus() {
    	//select status button as waiting on someone else
        WebElement status = driver.findElement(By.xpath("(//a[@class='select'])[1]"));
        driver.executeScript("arguments[0].click();", status);
        WebElement status1 = driver.findElement(By.xpath("//a[@title='Waiting on someone else']"));
	    driver.executeScript("arguments[0].click();",status1);
	    return this;
    }
    public NewTaskPage enterSubject(String sub) {
    	driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys(sub);
        return this;
    }
    public TaskCreatedPage clickSave() {
    	driver.findElement(By.xpath("(//span[@class=' label bBody'])[3]")).click();
    return new TaskCreatedPage(driver);    
	
    }
}
