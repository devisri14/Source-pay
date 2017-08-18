package test.java.com.lol.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO13 extends TestExecutor{
	
	public String ApprovalRequisite = "//a[contains(text(),'350138')]";
	public String ReassignRequisite = "//a[contains(text(),'350139')]";
	public String Approve = "//span[text()='Approve']";
	public String Reassign = ".//td[@class='x1af' and text()='Reassign...']";
	public String ApproverSearch = ".//*[contains(@id,'SearchStringField::content')]";
	public String SearchBtn = ".//*[contains(@id,'idSearchButton')]";
	public String CheckBox = ".//*[contains(@id,'selIdCB::content')]";
	public String OkBtn = ".//button[@id='reAsDg::ok' and text()='OK']";
	public String Refresh = "(//img[@alt='Refresh'])[2]";
	public String ProcurementWorklist = "//a[text()='Procurement - Worklist App']";
	public String Logout = "//a[text()='Logout']";
	public String LogoutConfirm = ".//*[@id='Confirm']";
	
	
	public void PO13Logout(){
		try{
			babyfunction.ObjectXpathavailable(PO13.Logout, "Logout", "");
			babyfunction.clickbyxpath(PO13.Logout, "Clicking on Logout", "");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO13.LogoutConfirm, "LogoutConfirm", "");
			babyfunction.clickbyxpath(PO13.LogoutConfirm, "Clicking on LogoutConfirm", "");
			Thread.sleep(2000);
			
		}catch(Exception e){
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
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}

	}

	
	public static void Login(String Username) {
		try {
			driver.get(prop.getProperty("URL"));
			System.out.println("Successfully Opened Fusion application ");
			driver.manage().window().maximize();

			babyfunction.VerifyPageTitle(".//*[@id='appName']", "Verify the title", "Fusion Applications");
			driver.findElement(By.xpath(".//*[@id='userid']")).click();
			driver.findElement(By.xpath(".//*[@id='userid']")).clear();
			driver.findElement(By.xpath(".//*[@id='userid']")).sendKeys(Username);
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
	public static void switchToNewWindow(int windowNumber) {
	    Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i < 10) {
	        String popupHandle = ite.next().toString();
	        driver.switchTo().window(popupHandle);
	        System.out.println("Window title is : "+driver.getTitle());
	        if (i == 10) break;
	        i++;
	    }
	}

}
