package test.java.com.lol.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;

public class Scenario_20 extends TestExecutor {
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
	public static void Scenario_20() {
		dataUtils.setSheetName("Scenario_20");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 20");
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
            			
            			// Line 1 - 1
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Line 1", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.BillingRowClick, "Billing Line 1", "");
            			babyfunction.clickbyxpath(PO1.BillingRowClick, "Billing Line 1", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Deliver to location", getData("PO1_Line1_Location").trim());
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO1_Line1_ChargeAccount_Percentage1").trim());
    					
    					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
    					babyfunction.clickbyxpath(PO1.Percentage, "Percentage", "");
    					driver.findElement(By.xpath(PO1.Percentage)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.Percentage, "Percentage", "75");
    					
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
    					
    					babyfunction.ObjectXpathavailable(PO1.Split, "Split icon", "");
    					babyfunction.clickbyxpath(PO1.Split, "sPLIT", "");
    					Thread.sleep(2000);
    					
    					// Line 1 - 2
            			babyfunction.ObjectXpathavailable(PO1.BillingRowClick1, "Billing Line 2", "");
            			babyfunction.clickbyxpath(PO1.BillingRowClick1, "Billing Line 2", "");
            			Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO1_Line1_ChargeAccount_Percentage2").trim());
    					
    					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
    					babyfunction.clickbyxpath(PO1.Percentage, "Percentage", "");
    					driver.findElement(By.xpath(PO1.Percentage)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.Percentage, "Percentage", "25");
    					
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
    					
    					// Line 2
    					babyfunction.ObjectXpathavailable(PO2.Row2, "Line 2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Line 2", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Deliver to location", getData("PO1_Line2_Location").trim());
    					babyfunction.clickbyxpath(PO2.Suggestion, "Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.BillingRowClick, "Billing Line 2", "");
            			babyfunction.clickbyxpath(PO1.BillingRowClick, "Billing Line 2", "");
            			Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Charge amount ",getData("PO1_Line2_ChargeAccount").trim());
    					
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
            			PO13.Login("560335");
            			
            			PO1.navigation();
            			babyfunction.ObjectXpathavailable("(//td[@class='xdx']//a[@class='xge'])[3]", "Purchase Order Number", "");
            			String PurchaseNumber = driver.findElement(By.xpath("(//td[@class='xdx']//a[@class='xge'])[3]")).getText();
            			System.out.println("PurchaseNumber:"+PurchaseNumber);
            			logger.log(LogStatus.PASS, "text"+PurchaseNumber);
            			Thread.sleep(2000);
            			
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
            			babyfunction.clickbyxpath(PO14.Search, "Click on search", "NIL");
            			Thread.sleep(5000);

            			//Line 1
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
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
            			String ReceivedQty1 = driver.findElement(By.xpath(PO14.ShowReceiptQuantity)).getText();
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
            			
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 2", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Line 2", "NIL");
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

            			// Line 3
            			
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 3", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Line 3", "NIL");
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line3_received qty").trim());
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

            			// AP-39
            			
            			navigation.NavigatonToInvoices();
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PurchaseNumber );
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_1_AP01 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_1_AP01);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP01);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-01_Line1_Invoice Amount").trim());
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			
            			//  Lines 1
            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);


            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable("(//input[@class='xyt' and @type='checkbox'])[2]//following::input[1]", "Quantity", "");
            			babyfunction.clickbyxpath("(//input[@class='xyt' and @type='checkbox'])[2]//following::input[1]", "Clicking on Quantity", "");
            			driver.findElement(By.xpath("(//input[@class='xyt' and @type='checkbox'])[2]//following::input[1]")).clear();
            			babyfunction.inputbyxpath("(//input[@class='xyt' and @type='checkbox'])[2]//following::input[1]", "Entering Quantity", getData("AP-01_Line1_Match").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable("(//button[@_afrpdo='ok'])[2]", "Ok", "NIL");
            			driver.findElement(By.xpath("(//button[@_afrpdo='ok'])[2]")).click();
            			//babyfunction.clickbyxpath("(//button[@_afrpdo='ok'])[2]", "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            		//  Lines 2
            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox1, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox1, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable("(//input[@class='xyt' and @type='checkbox'])[3]//following::input[1]", "Quantity", "");
            			babyfunction.clickbyxpath("(//input[@class='xyt' and @type='checkbox'])[3]//following::input[1]", "Clicking on Quantity", "");
            			driver.findElement(By.xpath("(//input[@class='xyt' and @type='checkbox'])[3]//following::input[1]")).clear();
            			babyfunction.inputbyxpath("(//input[@class='xyt' and @type='checkbox'])[3]//following::input[1]", "Entering Quantity", getData("AP-01_Line2_Match").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			driver.findElement(By.xpath("//button[@accesskey='K']")).click();
            			Thread.sleep(2000);
            			
            			babyfunction.jsScrollToElement("//*[text()='Taxes']");
            			
            			babyfunction.ObjectXpathavailable(AP05.TransactionTaxes, " TransactionTaxes", "");
        				babyfunction.clickbyxpath(AP05.TransactionTaxes, "Clicking TransactionTaxes", "");
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(AP05.EditTaxes, " EditTaxes", "");
        				driver.findElement(By.xpath(AP05.EditTaxes)).click();
        				babyfunction.clickbyxpath(AP05.EditTaxes, "EditTaxes", "");
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(AP05.RateName, " RateName", "");
        				//babyfunction.clickbyxpath(AP05.RateName, "Clicking RateName", "");
        				driver.findElement(By.xpath(AP05.RateName)).clear();
        				Thread.sleep(2000);
        				babyfunction.inputbyxpath(AP05.RateName, "Entering Rate Name", "LOLUSE_WI_SPENCER");
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(AP05.RateName1, " RateName", "");
        				//babyfunction.clickbyxpath(AP05.RateName1, "Clicking RateName", "");
        				driver.findElement(By.xpath(AP05.RateName1)).clear();
        				Thread.sleep(2000);
        				babyfunction.inputbyxpath(AP05.RateName1, "Rate Name", "LOLUSE_WI_GREENBAY");
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(AP05.TaxAmount1, "TaxAmount", "");
        				babyfunction.clickbyxpath(AP05.TaxAmount1, "TaxAmount", "");
        				Thread.sleep(1000);
        				babyfunction.inputbyxpath(AP05.TaxAmount1, "TaxAmount", getData("AP-01_Line1_Tax").trim());
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(AP05.SaveAndClose, " SaveAndClose", "");
        				babyfunction.clickbyxpath(AP05.SaveAndClose, "SaveAndClose", "");
        				Thread.sleep(2000);
               			
            			// click on the Action Button
            			Thread.sleep(1000);
            			babyfunction.clickbyxpath(ap01.Action1, "Click on Action drop down", "Nil");
            			Thread.sleep(1000);
            			driver.findElement(By.xpath(AP05.ManageDistributions)).click();
            			Thread.sleep(3000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("(//*[@alt='Details' and @class='x1bi'])[2]")));

            			driver.findElement(By.xpath("//button[text()='ave and Close']")).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Actions", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image.equalsIgnoreCase("LOL Image Hold")){
            				babyfunction.ObjectXpathavailable(ap01.ImageHoldReason, "ImageHoldReason", "");
                			babyfunction.clickbyxpath(ap01.ImageHoldReason, "Selecting ImageHoldReason", "");
                			Thread.sleep(2000);
                			
                			babyfunction.ObjectXpathavailable(ap01.ImageRelesed, "ImageRelesed", "");
                			babyfunction.clickbyxpath(ap01.ImageRelesed, "Selecting ImageRelesed", "");
                			Thread.sleep(2000);
                			
                			babyfunction.ObjectXpathavailable(ap01.SaveAndClose, "SaveAndClose", "");
                			babyfunction.clickbyxpath(ap01.SaveAndClose, "Selecting SaveAndClose", "");
                			Thread.sleep(2000);
            			}
            			
            			String SystemHoldValidation = driver.findElement(By.xpath(ap01.SystemHolds)).getText();
            			System.out.println("System Hold = "+SystemHoldValidation);
            			String Validation = driver.findElement(By.xpath("//span[text()='Validation']//following::span[1]")).getText();
            			System.out.println("Validation Status = "+Validation);
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Actions", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Actions", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
            			Thread.sleep(5000);
            			}else{
            				
            				System.out.println("Exception found");
            				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Actions", "");
                			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                			Thread.sleep(5000);
            			}
            			

            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);                
                        

            			
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
