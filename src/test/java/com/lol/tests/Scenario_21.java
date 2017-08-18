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
public class Scenario_21 extends TestExecutor{
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
	public static void Scenario_01_Goods_Multiple_Suppliers() {
		dataUtils.setSheetName("Scenario_21");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario_21");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");

  // PO_01 - Enter Requisition - internal catalog
                        
            			PO1.navigation();
            			
            			babyfunction.ObjectXpathavailable(PO1.InternalCatalog, "Internal Catalog", "");
            			babyfunction.clickbyxpath(PO1.InternalCatalog, "Internal Catalog", "");
            			Thread.sleep(1000);
            			
            			babyfunction.ObjectXpathavailable(PO1.ExpandSearchCatalog, "ExpandSearchCatalog", "");
            			babyfunction.clickbyxpath(PO1.ExpandSearchCatalog, "ExpandSearchCatalog", "");
            			Thread.sleep(1000);
            			
            			//Line 1
            			babyfunction.ObjectXpathavailable(PO1.Search, "Search", "");
            			babyfunction.clickbyxpath(PO1.Search, "Search", "");
            			driver.findElement(By.xpath(PO1.Search)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(PO1.Search, "Search", getData("PO1_Line1_Description").trim());
            			Thread.sleep(1000);
            			
            			babyfunction.ObjectXpathavailable(PO1.SearchGo, "Go button", "");
            			babyfunction.clickbyxpath(PO1.SearchGo, "Go button", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.QtyTxtBx, "Quantity text box", "");
            			babyfunction.clickbyxpath(PO1.QtyTxtBx, "Quantity", "");
            			driver.findElement(By.xpath(PO1.QtyTxtBx)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(PO1.QtyTxtBx, "Quantity", getData("PO1_Line1_Quantity").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO1.AddToRequisitionIC, "Add To Requisition", "");
            			babyfunction.clickbyxpath(PO1.AddToRequisitionIC, "AddToRequisition", "");
            			Thread.sleep(2000);
            			
            			//Line 2
            			babyfunction.ObjectXpathavailable(PO1.Search, "Search", "");
            			babyfunction.clickbyxpath(PO1.Search, "Search", "");
            			driver.findElement(By.xpath(PO1.Search)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(PO1.Search, "Search", getData("PO1_Line2_Description").trim());
            			Thread.sleep(1000);
            			
            			babyfunction.ObjectXpathavailable(PO1.SearchGo, "Go button", "");
            			babyfunction.clickbyxpath(PO1.SearchGo, "Go button", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.QtyTxtBx, "Quantity text box", "");
            			babyfunction.clickbyxpath(PO1.QtyTxtBx, "Quantity", "");
            			driver.findElement(By.xpath(PO1.QtyTxtBx)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(PO1.QtyTxtBx, "Quantity", getData("PO1_Line2_Quantity").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO1.AddToRequisitionIC, "Add To Requisition", "");
            			babyfunction.clickbyxpath(PO1.AddToRequisitionIC, "AddToRequisition", "");
            			Thread.sleep(2000);
            			

            			PO1.EditAndSubmit();
            			
            			// Line 1
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Line 1", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Deliver to location", getData("PO1_Line1_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO1_Line1_ChargeAccount").trim());
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubLedger, "LegacySubLedger", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ", "10");
    					Thread.sleep(1000);
    					
    					babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.AllocadiaID, "AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID", "100");
    					Thread.sleep(1000);
    					
    					//Line 2 
    					babyfunction.ObjectXpathavailable(PO2.Row2, "Line 2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Line 2", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.BillingRowClick, "Billing Line 1", "");
            			babyfunction.clickbyxpath(PO1.BillingRowClick, "Billing Line 1", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Deliver to location", getData("PO1_Line2_Location").trim());
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO1_Line2_ChargeAccount").trim());
    					
    					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
    					babyfunction.clickbyxpath(PO1.Percentage, "Percentage", "");
    					driver.findElement(By.xpath(PO1.Percentage)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.Percentage, "Percentage", "50");
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubledger, "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubledger, "LegacySubLedger", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO2.LegacySubledger)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.LegacySubledger, "LegacySubLedger ", "10");
    					Thread.sleep(1000);
    					
    					babyfunction.ObjectXpathavailable(PO2.AllocadiaId, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.AllocadiaId, "AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.AllocadiaId)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.AllocadiaId, "AllocadiaID", "100");
    					Thread.sleep(1000);
    					

    					WebDriverWait wait = new WebDriverWait(driver, 30);
    					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/procurement/images/split_ena.png']")));
    					driver.findElement(By.xpath("//img[@src='/procurement/images/split_ena.png']")).click();
    					Thread.sleep(1000);
    					
    					// Line 1 - 2
            			babyfunction.ObjectXpathavailable(PO1.BillingRowClick1, "Billing Line 2", "");
            			babyfunction.clickbyxpath(PO1.BillingRowClick1, "Billing Line 2", "");
            			Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO41_Line1_ChargeAccount_Percentage2").trim());
    					
    					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
    					babyfunction.clickbyxpath(PO1.Percentage, "Percentage", "");
    					driver.findElement(By.xpath(PO1.Percentage)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.Percentage, "Percentage", "50");
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubledger, "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubledger, "LegacySubLedger", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO2.LegacySubledger)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.LegacySubledger, "LegacySubLedger ", "10");
    					Thread.sleep(1000);
    					
    					babyfunction.ObjectXpathavailable(PO2.AllocadiaId, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.AllocadiaId, "AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.AllocadiaId)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.AllocadiaId, "AllocadiaID", "100");
    					Thread.sleep(1000);
    					
    					PO1.AddApprover();

            			babyfunction.ObjectXpathavailable(PO1.ReqNo, "RequisitionNumber", "");
    					String RequisitionNumber = driver.findElement(By.xpath(PO1.ReqNo)).getText();
    					Thread.sleep(2000);
    					
    					String[] ReqNo = RequisitionNumber.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    					
    					logger.log(LogStatus.PASS, "Requisition Number = "+ReqNo[1]);
    					System.out.println("Requisition Number "+ReqNo[1]);
    					
    					babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok Button ", "");
    					babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Ok button", "");
    					Thread.sleep(2000);
    					

    					// PO_13 - Approvals
    					PO13.Logout();
    					PO13.Login("50909");
    					
    					babyfunction.ObjectXpathavailable(PO13.ProcurementWorklist, "ProcurementWorklist", "");
            			babyfunction.clickbyxpath(PO13.ProcurementWorklist, "Clicking on ProcurementWorklist", "");
            			Thread.sleep(5000);
            			System.out.println(driver.getTitle());
            			logger.log(LogStatus.PASS, driver.getTitle());
            			
            			PO13.switchToNewWindow(1);
        	        	babyfunction.ObjectXpathavailable("//a[contains(text(),'Requisition "+ReqNo[1]+"')]", "Requisition", "");
            			babyfunction.clickbyxpath("//a[contains(text(),'Requisition "+ReqNo[1]+"')]", "Clicking on Requisition", "");
            			Thread.sleep(5000);
            			
            			System.out.println(driver.getTitle());
            			logger.log(LogStatus.PASS, driver.getTitle());
            			
            			PO13.switchToNewWindow(2);
            			babyfunction.ObjectXpathavailable(PO13.Approve, "Approve", "");
            			babyfunction.clickbyxpath(PO13.Approve, "Clicking on Approve", "");
            			Thread.sleep(5000);
            			
            			PO13.switchToNewWindow(1);
            			PO13.PO13Logout();
            			
            			
            			// PO_13 - Approvals
    					PO13.Login("41419");
    					
    					babyfunction.ObjectXpathavailable(PO13.ProcurementWorklist, "ProcurementWorklist", "");
            			babyfunction.clickbyxpath(PO13.ProcurementWorklist, "Clicking on ProcurementWorklist", "");
            			Thread.sleep(5000);
            			System.out.println(driver.getTitle());
            			logger.log(LogStatus.PASS, driver.getTitle());
            			
            			PO13.switchToNewWindow(1);
        	        	babyfunction.ObjectXpathavailable("//a[contains(text(),'Requisition "+ReqNo[1]+"')]", "Requisition", "");
            			babyfunction.clickbyxpath("//a[contains(text(),'Requisition "+ReqNo[1]+"')]", "Clicking on Requisition", "");
            			Thread.sleep(5000);
            			
            			System.out.println(driver.getTitle());
            			logger.log(LogStatus.PASS, driver.getTitle());
            			
            			PO13.switchToNewWindow(2);
            			babyfunction.ObjectXpathavailable(PO13.Approve, "Approve", "");
            			babyfunction.clickbyxpath(PO13.Approve, "Clicking on Approve", "");
            			Thread.sleep(5000);
            			
            			PO13.switchToNewWindow(1);
            			PO13.PO13Logout();
            			
            			
// PO_14 - Receive Purchase Order
            			
            			navigation.NavigatonToReceipt();

            			// Enter the requisition number
            			babyfunction.ObjectXpathavailable(PO14.RequsitionNumber, "RequsitionNumber", "");
            			babyfunction.clickbyxpath(PO14.RequsitionNumber, "Click on the RequsitionNumber  ", "");
            			babyfunction.inputbyxpath("//label[text()='Requisition']//following::input[1][@type='text']","Enter the requisition number", ReqNo[1]);
            			Thread.sleep(2000);

            			// Select Items Due
            			babyfunction.ObjectXpathavailable(PO14.ItemNumber, "ItemNumber", "");
            			babyfunction.clickbyxpath(PO14.ItemNumber, "", "");
            			Thread.sleep(2000);
            			babyfunction.ObjectXpathavailable(PO14.Anytime, "Anytime", "");
            			babyfunction.clickbyxpath(PO14.Anytime, "Picking Anytime from the list", "");
            			Thread.sleep(3000);

            			// Click on the search
            			babyfunction.ObjectXpathavailable(PO14.Search, "Search", "");
            			driver.findElement(By.xpath(PO14.Search)).click();
            			//babyfunction.clickbyxpath(PO14.Search, "Search", "NIL");
            			Thread.sleep(5000);

            			//Line 1
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Line 1", "NIL");
            			Thread.sleep(2000);

            			// click on the Receive Button.
            			babyfunction.ObjectXpathavailable(PO14.Receive, "Receive", "");
            			babyfunction.clickbyxpath(PO14.Receive, "Click on Receive button", "NIL");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Line 1", "NIL");
            			Thread.sleep(2000);
            			
            			// enter the Qty
            			babyfunction.ObjectXpathavailable(PO1.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO1.Quantity, "clicking on quantity", "");
            			driver.findElement(By.xpath(PO1.Quantity)).clear();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line1_received qty").trim());
            			Thread.sleep(2000);

            			// click on note icon
            			babyfunction.ObjectXpathavailable(PO14.AddNote, "AddNote", "");
            			babyfunction.clickbyxpath(PO14.AddNote, "Click on AddNote button", "NIL");
            			Thread.sleep(2000);

            			// Enter the Text in NOte
            			babyfunction.ObjectXpathavailable(PO14.Note, "Note", "");
            			babyfunction.clickbyxpath(PO14.Note, "Click on Note ", "NIL");
            			babyfunction.inputbyxpath(PO14.Note, "Entering notes", "This is from automation");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			Thread.sleep(3000);

            			// click on the final submit button
            			babyfunction.ObjectXpathavailable(PO9.OKBtn, "Submit", "");
            			babyfunction.clickbyxpath(PO9.OKBtn, "Click on Submit", "NIL");
            			Thread.sleep(3000);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			Thread.sleep(3000);
            			
            			// Line 2
            			
            			babyfunction.ObjectXpathavailable(PO2.Row2, "Line 2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Click on Line 2", "NIL");
            			Thread.sleep(2000);

            			// click on the Receive Button.
            			babyfunction.ObjectXpathavailable(PO14.Receive, "Receive", "");
            			babyfunction.clickbyxpath(PO14.Receive, "Click on Receive button", "NIL");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
            			Thread.sleep(2000);

            			// enter the Qty
            			babyfunction.ObjectXpathavailable(PO1.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO1.Quantity, "clicking on quantity", "");
            			driver.findElement(By.xpath(PO1.Quantity)).clear();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line2_received qty").trim());
            			Thread.sleep(2000);

            			// click on note icon
            			babyfunction.ObjectXpathavailable(PO14.AddNote, "AddNote", "");
            			babyfunction.clickbyxpath(PO14.AddNote, "Click on AddNote button", "NIL");
            			Thread.sleep(2000);

            			// Enter the Text in NOte
            			babyfunction.ObjectXpathavailable(PO14.Note, "Note", "");
            			babyfunction.clickbyxpath(PO14.Note, "Click on Note ", "NIL");
            			babyfunction.inputbyxpath(PO14.Note, "Entering notes", "This is from automation");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			Thread.sleep(3000);

            			// click on the final submit button
            			babyfunction.ObjectXpathavailable(PO9.OKBtn, "Submit", "");
            			babyfunction.clickbyxpath(PO9.OKBtn, "Click on Submit", "NIL");
            			Thread.sleep(3000);


            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			Thread.sleep(3000);
            			

    
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
