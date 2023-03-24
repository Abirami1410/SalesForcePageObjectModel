package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcel;

public class SalesForcePSM {
	public ChromeDriver driver;
	public ChromeOptions ch;
	public String sheet;//sheet is a local variable name
	
	public static ExtentReports extent;
	public ExtentTest test, node;
	public String testName,testDescription,testCategory,testAuthor;
	
	@BeforeSuite
	public void startReport() {
		//common for all testcases
		//step 1: setup physical report path
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		//To keep the report history
		reporter.setAppendExisting(true);
		//step 2:Create object for extent report
		extent=new ExtentReports();
		//step 3:attach the data with the physical path
		extent.attachReporter(reporter);
		}
	
	@BeforeClass
	public void setTestCaseDetails() {
		//step4: create a test case and assign test details
		test=extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
				
	}
	
	public int takeSnap() throws IOException {
	int ranNum=(int) (Math.random() * 999999 + 1000000);
	File source = driver.getScreenshotAs(OutputType.FILE);
	File target=new File("./snaps/img"+ranNum+".png");
	FileUtils.copyFile(source, target);
	return ranNum;
	}
	
	//Step5:Step level status
	public void reportStep(String stepDesc, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")){
			node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
	        throw new RuntimeException("Please look into the report for failure details");	
		}
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
    @BeforeMethod
	public void launchBrowser() {
    	//step5:step level status .....below one line code.... 
    	node=test.createNode(testName);
	    ch = new ChromeOptions();
		ch.addArguments("--disable-notifications", "--remote-allow-origins=*");
		driver = new ChromeDriver(ch);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        System.out.println("base driver"+driver);
	}
    
    @AfterMethod
    public void close() {
	    driver.close();

	}
    
	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		String[][] rdata = ReadExcel.readData(sheet);
		{
			return rdata;

		}

}
}