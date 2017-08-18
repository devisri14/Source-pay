package test.java.com.lol.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;

public class Scenario_14 extends TestExecutor {
	static ExtentReports report;
	FileInputStream fis = null;
	@BeforeClass(enabled = true)
	public static ExtentReports launch() {
		
		String destFile = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		destFile = userDir + "\\test-output\\extentreports\\ecom";
		String destDir = dateFormat.format(new Date()) + ".html";
		report = new ExtentReports(destFile + "\\" + destDir, true);
		report.loadConfig(new File(userDir + "\\src\\test\\java\\com\\usfoods\\ecom\\config\\reports.xml"));
		return report;
	}

	@AfterMethod(enabled = true)
	public void reportclosewindows() throws IOException, InterruptedException {
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
		report.endTest(logger);
		report.flush();
	}

	
	@AfterClass(enabled = true)
	public void result() {
		driver.close();
	}

	@BeforeMethod(enabled = true)
	public void startTest(Method method) throws IOException 
	{
		try{
		initialize();
		driver.get(prop.getProperty("URL"));
		System.out.println("Successfully Opened Fusion application ");
		driver.manage().window().maximize();
		// pass the sheet name corresponding to the test case
		//dataUtils.setSheetName("TestData");
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

	
	@Test(enabled = true)
	public static void Scenario_14() {
		dataUtils.setSheetName("Scenario_14");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 14");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        
//PO_02 - Enter Requisition - non-catalog
                        
                        navigation.NavigateToPurchaseRequisite();
           			
            			babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
            			babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
            			Thread.sleep(3000);
            			
            			//Line 1
            			babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
            			babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
            			driver.findElement(By.xpath(PO2.Description)).clear();
            			babyfunction.inputbyxpath(PO2.Description, "Entering Description", getData("PO2_Line1_Description").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
            			babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
            			driver.findElement(By.xpath(PO2.CategoryName)).clear();
            			babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName", getData("PO2_Line1_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Supplier, "Supplier", "");
            			babyfunction.clickbyxpath(PO2.Supplier, "Click on Supplier", "NIL");
            			driver.findElement(By.xpath(PO2.Supplier)).clear();
            			babyfunction.inputbyxpath(PO2.Supplier, "Entering Supplier", getData("PO2_Line1_Supplier").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Supplier", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO2.Quantity, "Click on Quantity", "NIL");
            			driver.findElement(By.xpath(PO2.Quantity)).clear();
            			babyfunction.inputbyxpath(PO2.Quantity, "Entering Quantity", getData("PO2_Line1_Quantity").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO2.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO2.UOM, "Click on UOM", "NIL");
            			driver.findElement(By.xpath(PO2.UOM)).clear();
            			babyfunction.inputbyxpath(PO2.UOM, "Entering UOM", getData("PO2_Line1_UOM").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted UOM", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Price, "Price", "");
            			babyfunction.clickbyxpath(PO2.Price, "Click on Price", "NIL");
            			driver.findElement(By.xpath(PO2.Price)).clear();
            			babyfunction.inputbyxpath(PO2.Price, "Entering Price", getData("PO2_Line1_Price").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.AddToRequisition, "AddToRequisition", "");
            			babyfunction.clickbyxpath(PO2.AddToRequisition, "Click on AddToRequisition", "NIL");
            			Thread.sleep(2000);
            			
            			PO1.EditAndSubmit();
            			
            			// Line 1
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Clickig on Line 1", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Clicking on deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO2_Line1_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line1_ChargeAccount").trim());
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubLedger, "clicking on LegacySubLedger", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
    					Thread.sleep(1000);

    					babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ", "10");
    					Thread.sleep(1000);
    					
    					babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.AllocadiaID, "Clicking on AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID is 100", "100");
    					Thread.sleep(1000);

    					babyfunction.ObjectXpathavailable(PO1.ManageApprovals, "Manage Approvals ", "");
    					babyfunction.clickbyxpath(PO1.ManageApprovals, "Clicking on ManageApprovals button", "");
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable("//*[contains(text(),'Header Hierarchy')]//preceding::td[1]", "Approver ", "");
    					babyfunction.clickbyxpath("//*[contains(text(),'Header Hierarchy')]//preceding::td[1]", "", "Approver");
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO2.AddApprover, "Add Approver ", "");
    					babyfunction.clickbyxpath(PO2.AddApprover, "", "Add Approver");
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO2.User, "User ", "");
    					babyfunction.clickbyxpath(PO2.User, "clicking on User", "");
    					Thread.sleep(1000);
    					driver.findElement(By.xpath(PO2.User)).clear();
    					Thread.sleep(1000);

    					babyfunction.inputbyxpath(PO2.User, "User ", getData("PO2_Line1_additional approver").trim());
    					Thread.sleep(1000);
    					

    					babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
    					//babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
    					Thread.sleep(3000);
    					
            			babyfunction.ObjectXpathavailable(PO1.ReqNo, "RequisitionNumber", "");
    					String RequisitionNumber = driver.findElement(By.xpath(PO1.ReqNo)).getText();
    					Thread.sleep(2000);
    					
    					String[] ReqNo = RequisitionNumber.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    					
    					logger.log(LogStatus.PASS, "Requisition Number = "+ReqNo[1]);
    					System.out.println("Requisition Number "+ReqNo[1]);
    					System.out.println("Requisition"+ReqNo);
    					
    					babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok Button ", "");
    					babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on ok button", "");
    					Thread.sleep(2000);

            			
    					
    					
                  } 
                   else{
                        logger.log(LogStatus.FAIL, "Home page is not displayed");
                        logger.log(LogStatus.INFO, "=======End Execution Report======");
                        
                  } i++;
            }
      }catch (Exception e) {
            common.captureSS("Error found", LogStatus.FAIL);
           
      }


	
}
}
