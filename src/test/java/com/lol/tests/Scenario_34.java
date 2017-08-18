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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.utils.babyfunction;

public class Scenario_34 extends TestExecutor {
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
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign Out')]")));
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
	public static void Scenario_34_PO_cancel() {
		dataUtils.setSheetName("Scenario_34");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 34");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        // PO10 - Enter Purchase Order
                        
                        navigation.NavigateToPurchasing();
            			
            			babyfunction.ObjectXpathavailable(PO10.CrateOrder, "Create Order", "");
            			babyfunction.clickbyxpath(PO10.CrateOrder, "Clicking on create order ", "");
            			Thread.sleep(2000);

            			// Identify supplier Name
            			babyfunction.ObjectXpathavailable(PO10.Suppliers, "Suppliers", "");
            			//babyfunction.clickbyxpath(PO10.Suppliers, "Clicking on Suppliers", "");
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.Suppliers, "Enter The Supplier Name", getData("PO10_Line1_Supplier").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Supplier", "");
            			Thread.sleep(3000);

            			// Buyer
            			babyfunction.ObjectXpathavailable(PO10.Buyer, "Buyer", "");
            			String BuyerName = driver.findElement(By.xpath(PO10.Buyer)).getText();
            			if (BuyerName != "") {
            				System.out.println("Buyer name Already exist");
            				System.out.println("Buyer name is " + BuyerName);

            			} else {
            				babyfunction.ObjectXpathavailable(PO10.Buyer, "Buyer", "");
            				babyfunction.clickbyxpath(PO10.Buyer, "Clicking on Buyer", "");
            				driver.findElement(By.xpath(PO10.Buyer)).clear();
            				Thread.sleep(1000);
            				babyfunction.inputbyxpath(PO10.Buyer, "Enter Buyer ", "Gurumoorthy, Devisri");
            				Thread.sleep(2000);
            			}

            			// Select the Delivery Location
            			babyfunction.ObjectXpathavailable(PO10.DeliverToLocation, "Default Ship-to Location", "");
            			babyfunction.clickbyxpath(PO10.DeliverToLocation, "Clicking on Deliver to location", "NIL");
            			driver.findElement(By.xpath(PO10.DeliverToLocation)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.DeliverToLocation, "Select the Location to Delivery", getData("PO10_Line1_Location").trim());
            			Thread.sleep(1000);
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected DeliverToLocation", "");
            			Thread.sleep(2000);

            			
            			
            			babyfunction.ObjectXpathavailable(PO10.CreateSupplier, "Create Supplier", "");
            			babyfunction.clickbyxpath(PO10.CreateSupplier, "Click on create button", "NIL");
            			Thread.sleep(5000);
            			
            			
            			
            			// Add notes
            			babyfunction.ObjectXpathavailable(PO10.NotesAndAttachement, "NotesAndAttachment", "");
            			babyfunction.clickbyxpath(PO10.NotesAndAttachement, "Clicking on notes and attachments", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO10.NotesForSupplier, "Notes For Supplier", "");
            			babyfunction.inputbyxpath(PO10.NotesForSupplier, "Enter The Notes Supplier", "Deliver to quality product");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO10.NotesForReceiver, "Notes For Receiver", "");
            			babyfunction.inputbyxpath(PO10.NotesForReceiver, "Enter The Notes Supplier",
            					"Let us know if product not receiving on time");
            			Thread.sleep(2000);

            			// Click on add icon in lines Tab
            			babyfunction.ObjectXpathavailable(PO10.AddRow, "AddRow", "");
            			Thread.sleep(2000);

            			PO10.addingRow();
            			
            			
            			// clicking on final submit button
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Click on the Submit for create Purchase Order", "Nil");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumber = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
            			Thread.sleep(2000);
            			String PONumber[] = PurchaseNumber.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            			System.out.println("Purchase Order number = "+PONumber[1]);
            			logger.log(LogStatus.PASS,"Purchase Order Number "+PONumber[1]);
            			
            			babyfunction.ObjectXpathavailable(PO10.OkBtn, "", "");
            			babyfunction.clickbyxpath(PO10.OkBtn, "Click Ok confirmation button for PO creation", "NIL");

            			// PO_13 - Approvals
    					PO13.Logout();
    					PO13.Login("50909");
    					
    					babyfunction.ObjectXpathavailable(PO13.ProcurementWorklist, "ProcurementWorklist", "");
            			babyfunction.clickbyxpath(PO13.ProcurementWorklist, "Clicking on ProcurementWorklist", "");
            			Thread.sleep(5000);
            			System.out.println(driver.getTitle());
            			logger.log(LogStatus.PASS, driver.getTitle());
            			
            			PO13.switchToNewWindow(1);
        	        	babyfunction.ObjectXpathavailable("//a[contains(text(),'(Purchase Order) "+PONumber[1]+"')]", "Purchase Order Number", "");
            			babyfunction.clickbyxpath("//a[contains(text(),'(Purchase Order) "+PONumber[1]+"')]", "Clicking on Purchase Order Number", "");
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
            			
            			
            			
    					            			
            			// PO - 12 Cancel Purchase Order
            			
            			navigation.NavigateToPurchasing();

            			PO11.ManageAndSearchOrder(PONumber[1]);

            			babyfunction.ObjectXpathavailable(PO11.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO11.RowClick, "Click on the row ", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.Actions, "Actions", "");
        				babyfunction.clickbyxpath(PO9.Actions, "Click on the Actions ", "");
        				Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO12.CancelDocument, "CancelDocument", "");
            			babyfunction.clickbyxpath(PO12.CancelDocument, "Click on the CancelDocument ", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO12.Reason, "Reason", "");
        				babyfunction.clickbyxpath(PO12.Reason, "Click on the Reason ", "");
        				babyfunction.inputbyxpath(PO12.Reason, "Entering reason for cancellation",
        						"Cancelling from automation script");
        				Thread.sleep(2000);

        				babyfunction.ObjectXpathavailable("(//button[@_afrpdo='ok'])[2]", "Ok", "");
        				babyfunction.clickbyxpath("(//button[@_afrpdo='ok'])[2]", "Click on the ok button ", "");
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(PO12.PurchaseCancelStatus, "Purchase Cancelllation status", "");
        				Thread.sleep(2000);
        				String Status = driver.findElement(By.xpath(PO12.PurchaseCancelStatus)).getText();
        				System.out.println("Cancel Status " + Status);
        				logger.log(LogStatus.INFO, "Cancel Status " + Status);
        				Thread.sleep(2000);
        				
        				babyfunction.ObjectXpathavailable(PO12.OKButton, "Ok", "");
        				driver.findElement(By.xpath(PO12.OKButton)).click();
        				//babyfunction.clickbyxpath(PO12.OKButton, "Click on the ok button ", "");
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
