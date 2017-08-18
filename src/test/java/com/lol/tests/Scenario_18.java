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

public class Scenario_18 extends TestExecutor {
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
	public static void Scenario_18() {
		dataUtils.setSheetName("Scenario_18");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario_18");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        
                        	
                     // PO_02 - Enter Requisition - non-catalog

    					navigation.NavigateToPurchaseRequisite();
    					// PO2.ClearRequisition();
    					babyfunction.ObjectXpathavailable(PO2.NonCatalogRequest, "NonCatalogRequest", "");
    					babyfunction.clickbyxpath(PO2.NonCatalogRequest, "Click on NonCatalogRequest", "NIL");
    					Thread.sleep(3000);

    					// Line 1
    					babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
    					babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
    					driver.findElement(By.xpath(PO2.Description)).clear();
    					babyfunction.inputbyxpath(PO2.Description, "Entering Description",
    							getData("PO2_Line1_Description").trim());
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
    					babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
    					driver.findElement(By.xpath(PO2.CategoryName)).clear();
    					babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName",
    							getData("PO2_Line1_Category").trim());
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
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location",
    							getData("PO2_Line1_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",
    							getData("PO2_Line1_ChargeAccount").trim());
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
    					babyfunction.clickbyxpath(PO2.LegacySubLedger, "clicking on LegacySubLedger", "");
    					Thread.sleep(1000);
    					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
    					Thread.sleep(2000);

    					babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ","10");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
    					babyfunction.clickbyxpath(PO2.AllocadiaID, "Clicking on AllocadiaID", "");
    					driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID is 100", "100");
    					Thread.sleep(4000);

    					babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
    					babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
    					Thread.sleep(3000);

    					babyfunction.ObjectXpathavailable(PO1.ReqNo, "RequisitionNumber", "");
    					String RequisitionNumber = driver.findElement(By.xpath(PO1.ReqNo)).getText();
    					Thread.sleep(2000);

    					String[] ReqNo = RequisitionNumber.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

    					logger.log(LogStatus.PASS, "Requisition Number = " + ReqNo[1]);
    					System.out.println("Requisition Number " + ReqNo[1]);

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
    					// babyfunction.inputbyxpath(PO9.Requisition, "Entering on
    					// Requisition", "371123");
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

    					// Line 1
    					babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
    					babyfunction.clickbyxpath(PO1.RowClick, "Clicking on RowClick", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO9.AddToDocumentBuilder, "AddToDocumentBuilder", "");
    					babyfunction.clickbyxpath(PO9.AddToDocumentBuilder, "Clicking on AddToDocumentBuilder", "");
    					Thread.sleep(3000);
    					
    					WebDriverWait wait = new WebDriverWait(driver, 120);
    					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PO9.DocumentOKBtn)));
    					
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "DocumentOKBtn", "");
    					babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on DocumentOKBtn", "");
    					Thread.sleep(3000);
    					
    					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PO9.Create)));
    					
    					babyfunction.ObjectXpathavailable(PO9.Create, "Create", "");
    					babyfunction.clickbyxpath(PO9.Create, "Clicking on Create", "");
    					Thread.sleep(3000);

    					babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
    					//babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
    					babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
    					Thread.sleep(3000);

    					babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
    					String PurchaseNumberLine1 = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
    					Thread.sleep(2000);
    					String[] PONumberLine1 = PurchaseNumberLine1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    					logger.log(LogStatus.PASS, "PONumber  = " + PONumberLine1[1]);
    					System.out.println("PONumber  " + PONumberLine1[1]);

    					babyfunction.ObjectXpathavailable("(//button[@_afrpdo='cancel'])[1]", "OKBtn", "");
    					babyfunction.clickbyxpath("(//button[@_afrpdo='cancel'])[1]", "Clicking on OKBtn", "");
    					Thread.sleep(3000);
    					                  
                  
// PO07 -  Cancel Requisition
    					

    					PO1.navigation();

    					babyfunction.ObjectXpathavailable(PO6.ManageRequisition, "ManageRequisition", "");
    					babyfunction.clickbyxpath(PO6.ManageRequisition, "Clicking on ManageRequisition", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO6.RequsitionNum, "RequsitionNum", "");
    					babyfunction.clickbyxpath(PO6.RequsitionNum, "Clicking on RequsitionNum", "");
    					babyfunction.inputbyxpath(PO6.RequsitionNum, "Entering Requisition Number", ReqNo[1]);
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO6.Search, "Search Button", "");
    					babyfunction.clickbyxpath(PO6.Search, "Clicking on Search", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO6.Rowclick, "Rowclick", "");
    					babyfunction.clickbyxpath(PO6.Rowclick, "Clicking on Rowclick", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO7.Action, "Action button", "");
    					babyfunction.clickbyxpath(PO7.Action, "Clicking on Rowclick", "");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO7.CancelRequisition, "Cancel Requisition button", "");
    					babyfunction.clickbyxpath(PO7.CancelRequisition, "Clicking on Cancel Requisition Button", "");
    					Thread.sleep(1000);
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO7.ReasonCancel, "Reason for Cancellation", "");
    					babyfunction.clickbyxpath(PO7.ReasonCancel, "Clicking on ReasonCancel", "");
    					driver.findElement(By.xpath(PO7.ReasonCancel)).clear();
    					babyfunction.inputbyxpath(PO7.ReasonCancel, "Entering cancel reason", "Cancelled through automation code");
    					Thread.sleep(2000);

    					babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok button", "");
    					babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on DocumentOKBtn", "");
    					Thread.sleep(2000);
                  
    					babyfunction.ObjectXpathavailable("//button[@_afrpdo= 'cancel' and text()='OK']", "Ok button", "");
    					babyfunction.clickbyxpath("//button[@_afrpdo= 'cancel' and text()='OK']", "Clicking on DocumentOKBtn", "");
    					Thread.sleep(2000);
    					
    					babyfunction.ObjectXpathavailable(PO11.Done, "Done", "");
            			babyfunction.clickbyxpath(PO1.Done, "Click on Done", "Nil");
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
