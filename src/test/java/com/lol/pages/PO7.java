package test.java.com.lol.pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO7 extends TestExecutor{
	public String CancelRequisition = ".//*[@class='x1af' and text()='Cancel Requisition']";
	public String ReasonCancel = "(.//*[@class='x25'])[3]";
	public String Action = "//a[text()='Actions']";
	
	public static void Login() {
		try {

			babyfunction.VerifyPageTitle(".//*[@id='appName']", "Verify the title", "Fusion Applications");
			driver.findElement(By.xpath(".//*[@id='userid']")).click();
			driver.findElement(By.xpath(".//*[@id='userid']")).clear();
			driver.findElement(By.xpath(".//*[@id='userid']")).sendKeys("560335");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).clear();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Welcome1!");
			driver.findElement(By.xpath(".//*[@type='submit']")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}
	
}
