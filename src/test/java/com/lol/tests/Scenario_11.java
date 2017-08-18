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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;

public class Scenario_11 extends TestExecutor {
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
	public static void Scenario_11() {
		dataUtils.setSheetName("Scenario_11");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 11");
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
            			
            			babyfunction.ObjectXpathavailable(PO1.ReturnToShopping, "Return to Shopping button", "");
            			babyfunction.clickbyxpath(PO1.ReturnToShopping, "ReturnToShopping", "");
            			Thread.sleep(1000);
            			
// PO_04 - Enter Requisition - Punch Out            			
            			
            			babyfunction.ObjectXpathavailable(PO4.PunchOutCatalog, "Punch out Catalog", "");
            			babyfunction.clickbyxpath(PO4.PunchOutCatalog, "Clicking on punch out catalog", "");
            			Thread.sleep(2000);

            			
            			babyfunction.ObjectXpathavailable(PO4.Fastenal, "Fastenal", "");
            			babyfunction.clickbyxpath(PO4.Fastenal, "Clicking on Fastenal", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO4.Fastenal_Input, "Fastenal_Input", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_Input, "Clicking on Fastenal_Input", "");
            			driver.findElement(By.xpath(PO4.Fastenal_Input)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO4.Fastenal_Input, "Entering Item on Fastenal_Input", getData("PO4_Line1_Description").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO4.Fastenal_Search1, "Fastenal_Search", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_Search1, "Clicking on Fastenal_Search", "");
            			Thread.sleep(2000);
            			

            			babyfunction.ObjectXpathavailable(PO4.Fastenal_Quantity, "Fastenal_Quantity", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_Quantity, "Clicking on Fastenal_Quantity", "");
            			driver.findElement(By.xpath(PO4.Fastenal_Quantity)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO4.Fastenal_Quantity, "Entering Item on Fastenal_Input", getData("PO4_Line1_Quantity").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO4.Fastenal_Add, "Fastenal_Add", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_Add, "Clicking on Fastenal_Add", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO4.Fastenal_MyCart, "Fastenal_MyCart", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_MyCart, "Clicking on Fastenal_MyCart", "");
            			Thread.sleep(2000); 
            			
            			babyfunction.ObjectXpathavailable(PO4.Fastenal_CheckOut, "Fastenal_CheckOut", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_CheckOut, "Clicking on Fastenal_CheckOut", "");
            			Thread.sleep(2000); 
            			

            			babyfunction.ObjectXpathavailable(PO4.Fastenal_Complete_CheckOut, "Fastenal_Complete_CheckOut", "");
            			babyfunction.clickbyxpath(PO4.Fastenal_Complete_CheckOut, "Clicking on Fastenal_Complete_CheckOut", "");
            			Thread.sleep(2000);

// PO_02 - Enter Requisition - non-catalog            			
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

    					// Line 3
            			babyfunction.ObjectXpathavailable(PO2.Row3, "Line 3", "");
            			babyfunction.clickbyxpath(PO2.Row3, "Line 3", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Clicking on deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO2_Line3_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line3_ChargeAccount").trim());
    					
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
    					
    					// Line 4
            			babyfunction.ObjectXpathavailable(PO2.Row4, "Line 4", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Line 4", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
    					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Clicking on deliver to location", "");
    					Thread.sleep(2000);
    					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
    					Thread.sleep(2000);
    					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO2_Line4_Location"));
    					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
    					Thread.sleep(2000);
            			
    					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
    					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
    					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
    					Thread.sleep(1000);
    					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line4_ChargeAccount").trim());
    					
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
