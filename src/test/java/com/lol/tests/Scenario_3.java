
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

public class Scenario_3 extends TestExecutor {
	static ExtentReports report;
	FileInputStream fis = null;
	Scenario_1  Scenario1 = new Scenario_1();
	
	
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
	public static void main(String args[]) {
		dataUtils.setSheetName("Scenario_3");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario - 3 Non Catalog Requisition - multiple suppliers - duplicate existing requisition");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        System.out.println("Scenario 1 = "+Scenario1.ReqNo[1]);

 // PO_34 - Enter Requisition - duplicate req
                        navigation.NavigateToPurchaseRequisite();
                       
            			babyfunction.ObjectXpathavailable(PO34.ManageRequisition, "ManageRequisition", "");
            			babyfunction.clickbyxpath(PO34.ManageRequisition, "Click on ManageRequisition", "NIL");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO9.RequsitionBU, "Requisition BU", "");
            			babyfunction.clickbyxpath(PO9.RequsitionBU, "Clicking on requisition BU", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.LOLUSA, "LOLUSA", "");
            			babyfunction.clickbyxpath(PO9.LOLUSA, "Clicking on LOLUSA", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Requisition, "Requisition", "");
            			babyfunction.clickbyxpath(PO9.Requisition, "Clicking on Requisition", "");
            			babyfunction.inputbyxpath(PO9.Requisition, "Entering on Requisition", "371131");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.SearchBtn, "SearchBtn", "");
            			babyfunction.clickbyxpath(PO9.SearchBtn, "Clicking on SearchBtn", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on Row", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.Duplicate, "Duplicate", "");
            			babyfunction.clickbyxpath(PO1.Duplicate, "Clicking on Duplicate button", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.RowClick, "Row Click", "");
            			driver.findElement(By.xpath(PO1.RowClick)).click();
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO2.Quantity, "Click on Quantity", "NIL");
            			driver.findElement(By.xpath(PO2.Quantity)).clear();
            			babyfunction.inputbyxpath(PO2.Quantity, "Entering Quantity", "10");
            			Thread.sleep(2000);
            			

            			PO1.DuplicateLine();

            			PO1.DeleteLine();

            			PO1.EditLineDeliveryInfo();

            			PO1.EditLineBillingInfo();

            			// PO1.NotesAndAttachements();

            			PO1.ChargeAmountVerification();

            			PO1.AddApprover();
            			
            			
            			// PO_13 - Approvals
            			
            			
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
            			babyfunction.inputbyxpath(PO9.Requisition, "Entering on Requisition", "371131");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Buyer, "Buyer", "");
            			babyfunction.clickbyxpath(PO9.Buyer, "Clicking on Buyer", "");
            			driver.findElement(By.xpath(PO9.Buyer)).clear();
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.SearchBtn, "SearchBtn", "");
            			babyfunction.clickbyxpath(PO9.SearchBtn, "Clicking on SearchBtn", "");
            			Thread.sleep(4000);
            			
            			java.util.List<WebElement> Row = driver.findElements(By.xpath(PO9.RowLineSize));
            			System.out.println("No of rows "+Row.size());
            			for(int ii=0;ii<=Row.size();i++){
            			
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on RowClick", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.AddToDocumentBuilder, "AddToDocumentBuilder", "");
            			babyfunction.clickbyxpath(PO9.AddToDocumentBuilder, "Clicking on AddToDocumentBuilder", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "DocumentOKBtn", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on DocumentOKBtn", "");
            			Thread.sleep(2000);
            			
            			}
            			
            			babyfunction.ObjectXpathavailable(PO9.DocumentEdit, "DocumentEdit", "");
            			babyfunction.clickbyxpath(PO9.DocumentEdit, "Clicking on DocumentEdit", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on RowClick", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Delete, "Delete", "");
            			babyfunction.clickbyxpath(PO9.Delete, "Clicking on Delete", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Create, "Create", "");
            			babyfunction.clickbyxpath(PO9.Create, "Clicking on Create", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO9.Ok, "Ok", "");
            			babyfunction.clickbyxpath(PO9.Ok, "Clicking on Ok button", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumber = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
            			babyfunction.SplitString(PurchaseNumber);
            			System.out.println("Purchase Order Number "+PurchaseNumber);

            			
            			// PO_14 - Receive Purchase Order
            			
            			navigation.NavigatonToReceipt();

            			// Enter the requisition number
            			babyfunction.ObjectXpathavailable(PO14.RequsitionNumber, "RequsitionNumber", "");
            			babyfunction.clickbyxpath(PO14.RequsitionNumber, "Click on the RequsitionNumber  ", "");
            			babyfunction.inputbyxpath("//label[text()='Requisition']//following::input[1][@type='text']",
            					"Enter the requisition number", "371131");
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

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
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
            			driver.findElement(By.xpath(PO1.Quantity)).click();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys("1");
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

            			// Receipt number
            			babyfunction.ObjectXpathavailable(PO14.ReceiptNumber, "Receipt Number", "");
            			String ReceiptNumber = driver.findElement(By.xpath(PO14.RequsitionNumber)).getText();
            			System.out.println("Receipt number is  =" + ReceiptNumber);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			
            			
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
            			
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
            			
            			// PO_14 - Receive Purchase Order
            			
            			navigation.NavigatonToReceipt();

            			// Enter the requisition number
            			babyfunction.ObjectXpathavailable(PO14.RequsitionNumber, "RequsitionNumber", "");
            			babyfunction.clickbyxpath(PO14.RequsitionNumber, "Click on the RequsitionNumber  ", "");
            			babyfunction.inputbyxpath("//label[text()='Requisition']//following::input[1][@type='text']",
            					"Enter the requisition number", "370974");
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

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
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
            			driver.findElement(By.xpath(PO1.Quantity)).click();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys("1");
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

            			// Receipt number
            			babyfunction.ObjectXpathavailable(PO14.ReceiptNumber, "Receipt Number", "");
            			String ReceiptNumber1 = driver.findElement(By.xpath(PO14.RequsitionNumber)).getText();
            			System.out.println("Receipt number is  =" + ReceiptNumber1);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
            			
            			
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
            			
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
            			
            			// PO_14 - Receive Purchase Order
            			
            			navigation.NavigatonToReceipt();

            			// Enter the requisition number
            			babyfunction.ObjectXpathavailable(PO14.RequsitionNumber, "RequsitionNumber", "");
            			babyfunction.clickbyxpath(PO14.RequsitionNumber, "Click on the RequsitionNumber  ", "");
            			babyfunction.inputbyxpath("//label[text()='Requisition']//following::input[1][@type='text']",
            					"Enter the requisition number", "370974");
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

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
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
            			driver.findElement(By.xpath(PO1.Quantity)).click();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys("1");
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

            			// Receipt number
            			babyfunction.ObjectXpathavailable(PO14.ReceiptNumber, "Receipt Number", "");
            			String ReceiptNumber2 = driver.findElement(By.xpath(PO14.RequsitionNumber)).getText();
            			System.out.println("Receipt number is  =" + ReceiptNumber2);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
                        
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
            			
            			// AP_05 - Enter Invoice for Marketing item and 3-Way Match
            			
            			
                        
                        
                        // PO_06 - Modify Requisition
            			

            			PO1.navigation();
            			babyfunction.ObjectXpathavailable(PO6.ManageRequisition, "ManageRequisition", "");
            			babyfunction.clickbyxpath(PO6.ManageRequisition, "Clicking on ManageRequisition ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.RequsitionNum, "RequsitionNum", "");
            			babyfunction.clickbyxpath(PO6.RequsitionNum, "Clicking on RequsitionNum ", "");
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(PO6.RequsitionNum, "Entering requisition number", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.Search, "Search Button", "");
            			babyfunction.clickbyxpath(PO6.Search, "Clicking on Search ", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO6.Rowclick, "Rowclick", "");
            			babyfunction.clickbyxpath(PO6.Rowclick, "Clicking on Rowclick ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO11.Actions, "Action button", "");
            			babyfunction.clickbyxpath(PO11.Actions, "Clicking on Action ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.ActionEdit, "Edit button", "");
            			babyfunction.clickbyxpath(PO6.ActionEdit, "Clicking on ActionEdit ", "");
            			Thread.sleep(2000);

            			if (driver.findElement(By.xpath(PO6.OkBtn)).equals(null)) {
            				System.out.println("Ok button not available");
            			} else {
            				babyfunction.ObjectXpathavailable(PO6.OkBtn, "OK button", "");
            				babyfunction.clickbyxpath(PO6.OkBtn, "Clicking on OkBtn ", "");
            				Thread.sleep(2000);
            				System.out.println("Else Loop");

            			}

            			// To edit an existing line

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on Row ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO6.Quantity, "Clicking on Quantity ", "");
            			babyfunction.inputbyxpath(PO6.Quantity, "Entering Quantity", "");
            			Thread.sleep(3000);

            			babyfunction.ObjectXpathavailable(PO1.SaveBtn, "Save Button", "");
            			babyfunction.clickbyxpath(PO1.SaveBtn, "Clicking on SaveBtn ", "");
            			Thread.sleep(2000);

            			// To delete an existing line (PO has not yet been created)

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Clicking on Row Click ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.Delete, "Delete ", "");
            			babyfunction.clickbyxpath(PO6.Delete, "Clicking on Delete ", "");
            			Thread.sleep(3000);

            			/*
            			 * if(driver.findElement(By.xpath(PO11.AlertYes)).isDisplayed()){
            			 * babyfunction.ObjectXpathavailable(PO11.AlertYes, "Yes button ",
            			 * ""); driver.findElement(By.xpath(PO11.AlertYes)).click();
            			 * Report.pass("Clicking on yes button", "Clicking on yes button",
            			 * ""); Thread.sleep(3000); }else{
            			 * System.out.println("Pop up not available"); }
            			 */
            			// To cancel an existing line (PO has been created)

            			/*
            			 * babyfunction.ObjectXpathavailable(PO11.Actions, "Action button",
            			 * ""); driver.findElement(By.xpath(PO11.Actions)).click();
            			 * Thread.sleep(1000); Report.pass("Clicking on Action Button ",
            			 * "Clicking on Action Button ", ""); Thread.sleep(2000);
            			 * 
            			 * WebElement Category = driver.findElement(By.xpath(PO11.Actions));
            			 * org.openqa.selenium.support.ui.Select Categor = new
            			 * org.openqa.selenium.support.ui.Select(Category);
            			 * Categor.selectByVisibleText("Cancel Requisition");
            			 * Report.pass("Selecting from category dropdown",
            			 * "Selecting from category dropdown", "");
            			 * 
            			 * babyfunction.ObjectXpathavailable(PO7.ReasonCancel,
            			 * "Reason for Cancellatio", "");
            			 * driver.findElement(By.xpath(PO7.ReasonCancel)).click();
            			 * Thread.sleep(1000);
            			 * driver.findElement(By.xpath(PO7.ReasonCancel)).
            			 * sendKeys("Cancelled through automation code");
            			 * Report.pass("Entering reason for cancellation  ",
            			 * "Entering reason for cancellation ", ""); Thread.sleep(2000);
            			 * 
            			 * babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok button",
            			 * ""); driver.findElement(By.xpath(PO9.DocumentOKBtn)).click();
            			 * Report.pass("Entering reason for cancellation  ",
            			 * "Entering reason for cancellation ", ""); Thread.sleep(2000);
            			 */

            			// To add a line to the req (PO has not yet been created)

            			babyfunction.ObjectXpathavailable(PO1.SaveBtn, "Save Button", "");
            			babyfunction.clickbyxpath(PO1.SaveBtn, "Saving the line item", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.Shop, "Shop Button", "");
            			babyfunction.clickbyxpath(PO6.Shop, "Clicking on shop button", "");
            			Thread.sleep(2000);

            			PO1.navigation();
            			
            			babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
            			babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
            			Thread.sleep(3000);
            			
            			
            			//Line 1
            			babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
            			babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
            			driver.findElement(By.xpath(PO2.Description)).clear();
            			babyfunction.inputbyxpath(PO2.Description, "Entering Description", getData("PO2_Line1_Description"));
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
            			babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
            			driver.findElement(By.xpath(PO2.CategoryName)).clear();
            			babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName", getData("PO2_Line1_Category"));
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Supplier, "Supplier", "");
            			babyfunction.clickbyxpath(PO2.Supplier, "Click on Supplier", "NIL");
            			driver.findElement(By.xpath(PO2.Supplier)).clear();
            			babyfunction.inputbyxpath(PO2.Supplier, "Entering Supplier", getData("PO2_Line1_Supplier"));
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Supplier", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO2.Quantity, "Click on Quantity", "NIL");
            			driver.findElement(By.xpath(PO2.Quantity)).clear();
            			babyfunction.inputbyxpath(PO2.Quantity, "Entering Quantity", getData("PO2_Line1_Quantity"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO2.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO2.UOM, "Click on UOM", "NIL");
            			driver.findElement(By.xpath(PO2.UOM)).clear();
            			babyfunction.inputbyxpath(PO2.UOM, "Entering UOM", getData("PO2_Line1_UOM"));
            			babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted UOM", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Price, "Price", "");
            			babyfunction.clickbyxpath(PO2.Price, "Click on Price", "NIL");
            			driver.findElement(By.xpath(PO2.Price)).clear();
            			babyfunction.inputbyxpath(PO2.Price, "Entering Price", getData("PO2_Line1_Price"));
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.AddToRequisition, "AddToRequisition", "");
            			babyfunction.clickbyxpath(PO2.AddToRequisition, "Click on AddToRequisition", "NIL");
            			Thread.sleep(2000);
            			
            			PO1.EditAndSubmit();
            			
            			PO1.ChargeAmountVerification();
            			
            			PO1.AddApprover();
            			
            			
            			
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
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
