package test.java.com.lol.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import test.java.com.lol.pages.PO13;
import test.java.com.lol.utils.babyfunction;

import org.openqa.selenium.JavascriptExecutor;
public class Scenario_1 extends TestExecutor {
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
	public static void Scenario_01() {
		dataUtils.setSheetName("Scenario_1");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 01 - Goods - Multiple Suppliers");
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
            			
            			//Line 2

            			babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
            			babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
            			driver.findElement(By.xpath(PO2.Description)).clear();
            			babyfunction.inputbyxpath(PO2.Description, "Entering Description", getData("PO2_Line2_Description").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
            			babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
            			driver.findElement(By.xpath(PO2.CategoryName)).clear();
            			babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName", getData("PO2_Line2_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Supplier, "Supplier", "");
            			babyfunction.clickbyxpath(PO2.Supplier, "Click on Supplier", "NIL");
            			driver.findElement(By.xpath(PO2.Supplier)).clear();
            			babyfunction.inputbyxpath(PO2.Supplier, "Entering Supplier", getData("PO2_Line2_Supplier").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Supplier", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO2.Quantity, "Click on Quantity", "NIL");
            			driver.findElement(By.xpath(PO2.Quantity)).clear();
            			babyfunction.inputbyxpath(PO2.Quantity, "Entering Quantity", getData("PO2_Line2_Quantity").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO2.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO2.UOM, "Click on UOM", "NIL");
            			driver.findElement(By.xpath(PO2.UOM)).clear();
            			babyfunction.inputbyxpath(PO2.UOM, "Entering UOM", getData("PO2_Line2_UOM").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted UOM", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Price, "Price", "");
            			babyfunction.clickbyxpath(PO2.Price, "Click on Price", "NIL");
            			driver.findElement(By.xpath(PO2.Price)).clear();
            			babyfunction.inputbyxpath(PO2.Price, "Entering Price", getData("PO2_Line2_Price").trim());
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
    					
    					// Line 2
    					babyfunction.ObjectXpathavailable(PO2.Row2, "Line 2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Clickig on Line 2", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Clicking on deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO2_Line2_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line2_ChargeAccount").trim());
    					
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
    					
            			PO1.AddApprover();

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
            			
            			// PO_13 - Approvals
    					PO13.Logout();
    					PO13.Login("50909");
    					
    					babyfunction.ObjectXpathavailable(PO13.ProcurementWorklist, "ProcurementWorklist", "");
            			babyfunction.clickbyxpath(PO13.ProcurementWorklist, "Clicking on ProcurementWorklist", "");
            			Thread.sleep(5000);
            		//	driver.findElement(By.xpath("html/body")).sendKeys(Keys.CONTROL + "1");
            		//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
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
            			
            			
 // PO_09 - Process Requisition - create PO

            			navigation.NavigateToProcessRequsition();
            			
            			babyfunction.ObjectXpathavailable(PO9.RequsitionBU, "Requisition BU", "");
            			babyfunction.clickbyxpath(PO9.RequsitionBU, "Clicking on requisition BU", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.LOLUSA, "LOLUSA", "");
            			babyfunction.clickbyxpath(PO9.LOLUSA, "Clicking on LOLUSA", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Requisition, "Requisition", "");
            			babyfunction.clickbyxpath(PO9.Requisition, "Clicking on Requisition", "");
            			//babyfunction.inputbyxpath(PO9.Requisition, "Entering on Requisition", "371123");
            			babyfunction.inputbyxpath(PO9.Requisition, "Entering on Requisition", ReqNo[1]);
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Buyer, "Buyer", "");
            			babyfunction.clickbyxpath(PO9.Buyer, "Clicking on Buyer", "");
            			Thread.sleep(2000);
            			driver.findElement(By.xpath(PO9.Buyer)).clear();
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.SearchBtn, "SearchBtn", "");
            			babyfunction.clickbyxpath(PO9.SearchBtn, "Clicking on SearchBtn", "");
            			Thread.sleep(4000);
            			
            			java.util.List<WebElement> Row = driver.findElements(By.xpath(PO9.RowLineSize));
            			
            			//Line 1
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on RowClick", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.AddToDocumentBuilder, "AddToDocumentBuilder", "");
            			babyfunction.clickbyxpath(PO9.AddToDocumentBuilder, "Clicking on AddToDocumentBuilder", "");
            			Thread.sleep(4000);
            			
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "DocumentOKBtn", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on DocumentOKBtn", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Create, "Create", "");
            			babyfunction.clickbyxpath(PO9.Create, "Clicking on Create", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
            			babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
            			Thread.sleep(3000);
    					
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumberLine1 = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
    					Thread.sleep(2000);
    					String[] PONumberLine1 = PurchaseNumberLine1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    					logger.log(LogStatus.PASS, "PONumber  = "+PONumberLine1[1]);
    					System.out.println("PONumber  "+PONumberLine1[1]);
            			
            			babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
            			babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
            			Thread.sleep(3000);
            			
            			//Line 2
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on RowClick", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.AddToDocumentBuilder, "AddToDocumentBuilder", "");
            			babyfunction.clickbyxpath(PO9.AddToDocumentBuilder, "Clicking on AddToDocumentBuilder", "");
            			Thread.sleep(4000);
            			
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "DocumentOKBtn", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on DocumentOKBtn", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Create, "Create", "");
            			driver.findElement(By.xpath(PO9.Create)).click();
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
            			babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
            			Thread.sleep(3000);
    					
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumberLine2 = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
    					Thread.sleep(2000);
    					String[] PONumberLine2 = PurchaseNumberLine2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    					logger.log(LogStatus.PASS, "PONumber  = "+PONumberLine2[1]);
    					System.out.println("PONumber  "+PONumberLine2[1]);
            			
            			babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
            			babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
            			Thread.sleep(3000);
            			
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line1_ReceivedQty").trim());
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line2_ReceivedQty").trim());
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

            			
// AP_05 - Enter Invoice for Marketing item and 3-Way Match (Line 1)
            			
            			navigation.NavigatonToInvoices();
            			Thread.sleep(5000);
            			WebDriverWait wait = new WebDriverWait(driver, 100);


            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);


            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine1[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_1_AP05 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_1_AP05);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP05);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-05_Line1_Invoice Amount"));
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);

            			

            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-05_Line1_Match"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.VerifyPageTitle(ap01.invoice_page, "Verify Invoice page", "Invoices");
            			
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
            			Thread.sleep(5000);
            			}else{
            				
            				System.out.println("Exception found");
            				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                			Thread.sleep(5000);
            			}
            			
            			
            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			driver.findElement(By.xpath(PO35.SaveAndClose)).click();
            			//babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);

            			
            			

// AP_05 - Enter Invoice for Marketing item and 3-Way Match (Line 2)
            			
            			//navigation.NavigatonToInvoices();
            			Thread.sleep(3000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine2[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_2_AP05 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_2_AP05);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_2_AP05);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-05_Line2_Invoice Amount"));
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);

            			

            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-05_Line2_Match"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			AP05.CalculateTax("LOLUSE_MO_STJOSEPH");
            			
            			
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image1 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image1.equalsIgnoreCase("LOL Image Hold")){
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
            			
            			
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

                			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			Thread.sleep(5000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			Thread.sleep(5000);
                			}else{
                				
                				System.out.println("Exception found");
                				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                    			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                    			Thread.sleep(2000);

                    			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                    			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                    			Thread.sleep(5000);
                			}
            			
            			

            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);

            			
            			
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line1_ReceivedQty").trim());
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_Line2_ReceivedQty").trim());
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

            			
// AP_05 - Enter Invoice for Marketing item and 3-Way Match (Line 1)
            			
            			navigation.NavigatonToInvoices();
            			Thread.sleep(5000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine1[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_1_AP05_2 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_1_AP05_2);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP05_2);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-05_Line1_Invoice Amount"));
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);


            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-05_Line1_Match"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.VerifyPageTitle(ap01.invoice_page, "Verify Invoice page", "Invoices");
            			
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image3 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image3.equalsIgnoreCase("LOL Image Hold")){
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
            			
            			
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

                			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			Thread.sleep(5000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			Thread.sleep(5000);
                			}else{
                				
                				System.out.println("Exception found");
                				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                    			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                    			Thread.sleep(2000);

                    			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                    			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                    			Thread.sleep(5000);
                			}
            			
            			

            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);

            			
            			

// AP_05 - Enter Invoice for Marketing item and 3-Way Match (Line 2)
            			
//            			navigation.NavigatonToInvoices();
            			Thread.sleep(3000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine2[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_2_AP05_2 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_2_AP05_2);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP05);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-05_Line2_Invoice Amount"));
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);

            			

            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-05_Line2_Match"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);

            			AP05.CalculateTax("LOLUSE_MO_STJOSEPH");
            			
            			babyfunction.VerifyPageTitle(ap01.invoice_page, "Verify Invoice page", "Invoices");
            			
            			// click on the Action Button
            			Thread.sleep(2000);
            			babyfunction.clickbyxpath(ap01.Action1, "Click on Action drop down", "");
            			Thread.sleep(1000);
            			driver.findElement(By.xpath(AP05.ManageDistributions)).click();
            			Thread.sleep(3000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("(//*[@alt='Details' and @class='x1bi'])[2]")));

            			driver.findElement(By.xpath("//button[text()='ave and Close']")).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image4 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image4.equalsIgnoreCase("LOL Image Hold")){
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
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

                			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			Thread.sleep(5000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			Thread.sleep(5000);
                			}else{
                				
                				System.out.println("Exception found");
                				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                    			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                    			Thread.sleep(2000);

                    			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                    			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                    			Thread.sleep(5000);
                			}
            			
            			
            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);

            			
            			
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
            			babyfunction.clickbyxpath(PO14.Search, "Click on search", "");
            			Thread.sleep(5000);

            			//Line 1
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "");
            			Thread.sleep(2000);

            			// click on the Receive Button.
            			babyfunction.ObjectXpathavailable(PO14.Receive, "Receive", "");
            			babyfunction.clickbyxpath(PO14.Receive, "Click on Receive button", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Line 1", "");
            			Thread.sleep(2000);
            			
            			// enter the Qty
            			babyfunction.ObjectXpathavailable(PO1.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO1.Quantity, "clicking on quantity", "");
            			driver.findElement(By.xpath(PO1.Quantity)).clear();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_2_Line1_ReceivedQty").trim());
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
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO14_2_Line2_ReceivedQty").trim());
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

            			            			
// AP_30 - Enter Invoice against a PO with Short Variance, but within Matching Tolerance (Line 1)
            			
            			navigation.NavigatonToInvoices();
            			Thread.sleep(5000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine1[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_1_AP30 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_1_AP30);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP30);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-30_Line1_Invoice Amount").trim());
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(4000);

            			

            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			//babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-30_Line1_Match").trim());
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", "4598.85");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.VerifyPageTitle(ap01.invoice_page, "Verify Invoice page", "Invoices");
            			
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image5 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image5.equalsIgnoreCase("LOL Image Hold")){
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
            			
            			
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

                			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			Thread.sleep(5000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			Thread.sleep(5000);
                			}else{
                				
                				System.out.println("Exception found");
                				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                    			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                    			Thread.sleep(2000);

                    			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                    			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                    			Thread.sleep(5000);
                			}
            			
            			

            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(AP30.ManageInvoice, "Manage Invoice", "");
            			babyfunction.clickbyxpath(AP30.ManageInvoice, "Selecting Manage Invoice", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(AP30.InvoiceQuery, "InvoiceQuery", "");
            			babyfunction.clickbyxpath(AP30.InvoiceQuery, "", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.QueryEquals, "QueryEquals", "");
            			babyfunction.clickbyxpath(AP30.QueryEquals, "", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.InvoiceNumber, "InvoiceNumber", "");
            			babyfunction.clickbyxpath(AP30.InvoiceNumber, "clicking on invoice number", "");
            			driver.findElement(By.xpath(AP30.InvoiceNumber)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(AP30.InvoiceNumber, "Entering Invoice Number", InvoiceNumber_1_AP30);
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Search, "Search", "");
            			babyfunction.clickbyxpath(AP30.Search, "Clicking on Search", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Lines, "Lines", "");
            			babyfunction.clickbyxpath(AP30.Search, "Clicking on Lines", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Status, "Status", "");
            			String POStatus = driver.findElement(By.xpath(AP30.Status)).getText();
            			System.out.println("PO Status = "+POStatus);
            			logger.log(LogStatus.PASS, "PO Status = "+POStatus);
            			Thread.sleep(2000);
            			
            			
            			
            			

// AP_30 - Enter Invoice against a PO with Short Variance, but within Matching Tolerance (Line 2)            			
//            			navigation.NavigatonToInvoices();
            			Thread.sleep(3000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumberLine2[1] );
            			//babyfunction.inputbyxpath(ap01.identifying_po, "Entering Supplier name","10307714");
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_2_AP30 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_2_AP30);
            			System.out.println("Invoice Number Line 2 = "+InvoiceNumber_2_AP30);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-30_Line2_Invoice Amount").trim());
            			Thread.sleep(2000);

            			// selecting match to receipt charges
            			babyfunction.ObjectXpathavailable(ap01.match_invoice, "Lines", "Match Invoice Lines");
            			babyfunction.DropSelectbyID(ap01.match_invoice, "Lines", "Match Invoice Lines");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_lines_dropdown_go, "Clicking GO", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//td/div[text()='Match Invoice Lines']", "Verify Match Invoice Lines page",
            					"Match Invoice Lines");

            			System.out.println(driver.findElement(By.xpath("//td/div[text()='Match Invoice Lines']")).getText());

            			babyfunction.ObjectXpathavailable(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			babyfunction.clickbyxpath(ap01.invoice_select_match_checkbox, "Selecting Match Chechbox", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(ap01.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(ap01.Quantity)).clear();
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-30_Line2_Match").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);

            			AP05.CalculateTax("LOLUSE_MO_STJOSEPH");
            			
            			babyfunction.VerifyPageTitle(ap01.invoice_page, "Verify Invoice page", "Invoices");
            			
            			// click on the Action Button
            			Thread.sleep(2000);
            			babyfunction.clickbyxpath(ap01.Action1, "Click on Action drop down", "");
            			Thread.sleep(1000);
            			driver.findElement(By.xpath(AP05.ManageDistributions)).click();
            			Thread.sleep(3000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("(//*[@alt='Details' and @class='x1bi'])[2]")));

            			driver.findElement(By.xpath("//button[text()='ave and Close']")).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image6 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image6.equalsIgnoreCase("LOL Image Hold")){
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
            			
            			if(SystemHoldValidation.equalsIgnoreCase("0") || Validation.equalsIgnoreCase("Validated")){

                			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_action_page, "Selecting Invoice Action1", "NIL");
                			Thread.sleep(2000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_approvel, "Selecting Approval", "NIL");
                			Thread.sleep(5000);

                			babyfunction.ObjectXpathavailable(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			babyfunction.clickbyxpath(ap01.invoice_initial_approvel, "Selecting Initiate Approval", "NIL");
                			Thread.sleep(5000);
                			}else{
                				
                				System.out.println("Exception found");
                				babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Action1", "");
                    			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
                    			Thread.sleep(2000);

                    			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
                    			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
                    			Thread.sleep(5000);
                			}
            			
            			
            			babyfunction.ObjectXpathavailable(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			babyfunction.clickbyxpath(PO35.SaveAndClose, "Selecting Save and close", "NIL");
            			Thread.sleep(5000);
            			
            			
            			babyfunction.ObjectXpathavailable(AP30.ManageInvoice, "Manage Invoice", "");
            			babyfunction.clickbyxpath(AP30.ManageInvoice, "Selecting Manage Invoice", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(AP30.InvoiceQuery, "InvoiceQuery", "");
            			babyfunction.clickbyxpath(AP30.InvoiceQuery, "", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.QueryEquals, "QueryEquals", "");
            			babyfunction.clickbyxpath(AP30.QueryEquals, "", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.InvoiceNumber, "InvoiceNumber", "");
            			babyfunction.clickbyxpath(AP30.InvoiceNumber, "clicking on invoice number", "");
            			driver.findElement(By.xpath(AP30.InvoiceNumber)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(AP30.InvoiceNumber, "Entering Invoice Number", InvoiceNumber_2_AP30);
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Search, "Search", "");
            			babyfunction.clickbyxpath(AP30.Search, "Clicking on Search", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Lines, "Lines", "");
            			babyfunction.clickbyxpath(AP30.Search, "Clicking on Lines", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP30.Status, "Status", "");
            			String POStatus1 = driver.findElement(By.xpath(AP30.Status)).getText();
            			System.out.println("PO Status = "+POStatus1);
            			logger.log(LogStatus.PASS, "PO Status = "+POStatus1);
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