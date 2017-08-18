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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;

public class Scenario_68 extends TestExecutor {
	
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
	public static void Scenario_68() {
		dataUtils.setSheetName("Scenario_68");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 68");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");

// PO41 - Enter Requisition - Service non-catalog 2-way
                        
                        navigation.NavigateToPurchaseRequisite();
            			
            			babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
            			babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO2.ItemType, "ItemType", "");
            			babyfunction.clickbyxpath(PO2.ItemType, "Click on ItemType", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Services, "Services", "");
            			babyfunction.clickbyxpath(PO2.Services, "Click on Services", "NIL");
            			Thread.sleep(3000);
            			
            			
            			babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
            			babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
            			babyfunction.inputbyxpath(PO2.Description, "Entering Description", getData("PO41_Line1_Description").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
            			babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
            			babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName", getData("PO41_Line1_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, "", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Amount, "Price", "");
            			babyfunction.clickbyxpath(PO2.Amount, "Click on Price", "NIL");
            			babyfunction.inputbyxpath(PO2.Amount, "Entering Price", getData("PO41_Line1_Price").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Supplier, "Supplier", "");
            			babyfunction.clickbyxpath(PO2.Supplier, "Click on Supplier", "NIL");
            			babyfunction.inputbyxpath(PO2.Supplier, "Entering Supplier", getData("PO41_Line1_Supplier").trim());
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
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO41_Line1_Location"));
    					Thread.sleep(1000);
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge Account ","200.01.1300500.734100000.000");
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(".//span[text()='LEGACY SUBLEDGER']/following::input[4]", "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(".//span[text()='LEGACY SUBLEDGER']/following::input[4]", "clicking on LegacySubLedger", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(".//span[text()='LEGACY SUBLEDGER']/following::input[4]")).clear();
    					Thread.sleep(1000);

    					babyfunction.inputbyxpath(".//span[text()='LEGACY SUBLEDGER']/following::input[4]", "LegacySubLedger ", "10");
    					Thread.sleep(1000);
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubLedger, "Clicking on AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO2.LegacySubLedger, "AllocadiaID is 100", "100");
    					Thread.sleep(2000);

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
            			
 //         AP - 45 
            			navigation.NavigatonToInvoices();
            			Thread.sleep(3000);

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
            			String InvoiceNumber_2_AP05 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_2_AP05);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_2_AP05);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-41_Line1_Invoice Amount").trim());
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
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-41_Line1_Invoice Amount").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok", "NIL");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Selecting Ok", "NIL");
            			Thread.sleep(2000);
            			
            			
            			
            			// click on the Action Button
            			Thread.sleep(1000);
            			
            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Actions", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			String Warning = driver.findElement(By.xpath(ap01.Warning)).getText();
            			System.out.println("Waning Message" +Warning);
            			logger.log(LogStatus.PASS, "Warning Message: "+Warning);
            			
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(ap01.warning_Ok, " warning_Ok", "");
            			babyfunction.clickbyxpath(ap01.warning_Ok, "Click Ok", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Actions", "");
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

                        
            				}else{
                              logger.log(LogStatus.FAIL, "Home page is not displayed");
                              logger.log(LogStatus.INFO, "=======End Execution Report======");
                              
                        } i++;
                  }
            }catch (Exception e) {
                  common.captureSS("Error found", LogStatus.FAIL);
                 
            }


		
}


}
