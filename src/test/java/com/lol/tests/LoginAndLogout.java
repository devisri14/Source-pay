package test.java.com.lol.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;


public class LoginAndLogout extends TestExecutor{

	public void Login(){
	try {

		babyfunction.VerifyPageTitle(".//*[@id='appName']", "Verify the title", "Fusion Applications");
		
		/*babyfunction.ObjectXpathavailable(, "NonCatalogRequest", "");
		babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
		Thread.sleep(3000);
		
		babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
		babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
		Thread.sleep(3000);
		
		babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
		babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
		Thread.sleep(3000);
		
		*/
		
		
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
	
	public void Logout(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			Thread.sleep(3000);
			System.out.println("Calling the Logout function");
			Thread.sleep(3000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(@id,'_UIScmil1u')]")).click();
			Thread.sleep(5000);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign Out')]")));
				babyfunction.clickbyxpath("//a[contains(text(),'Sign Out')]", "Click on SignOut Button", "NIL");
			} catch (Exception e) {
				babyfunction.clickbyxpath("//button[text()='Yes']", "", "");
				Thread.sleep(2000);
				babyfunction.inputbyxpath("//button[text()='Yes']", "Imprper exit", "Nil");
			}
			Thread.sleep(1000);
			// confirmation close button
			WebElement btn_signout_confirm = driver.findElement(By.cssSelector("#Confirm"));
			btn_signout_confirm.click();
			Thread.sleep(5000);
			driver.close();
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}

	}
		
	}

