
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

public class Scenario_35 extends TestExecutor {
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
	public static void Scenario_35() {
		dataUtils.setSheetName("Scenario_35");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario - 35");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        
                        
// PO10 - Enter Purchase Order
                        
                        navigation.NavigateToPurchasing();
            			
            			babyfunction.ObjectXpathavailable(PO10.CrateOrder, "Create Order", "");
            			babyfunction.clickbyxpath(PO10.CrateOrder, "Clicking on create order ", "");
            			Thread.sleep(2000);

            			// Identify supplier Name
            			babyfunction.ObjectXpathavailable(PO10.Suppliers, "Suppliers", "");
            			babyfunction.clickbyxpath(PO10.Suppliers, "Clicking on Suppliers", "");
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

            			babyfunction.ObjectXpathavailable(PO10.Lines, "Lines", "");
            			babyfunction.clickbyxpath(PO10.Lines, "Click on Line Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.clickbyxpath(PO10.AddRow, "click on Add icon", "Nil");
            			Thread.sleep(8000);

            			// Enter Line Descriptions
            			babyfunction.ObjectXpathavailable(PO10.Description, "Description", "");
            			babyfunction.clickbyxpath(PO10.Description, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Description,"Enter the Line Description",getData("PO10_Line1_Description").trim());
            			Thread.sleep(2000);

            			// Enter the Line Category Name
            			babyfunction.ObjectXpathavailable(PO10.Category, "Category", "");
            			babyfunction.clickbyxpath(PO10.Category, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Category,
            					"Enter the Line Descriptionsdescription", getData("PO10_Line1_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			// Enter the values for UOM
            			babyfunction.ObjectXpathavailable(PO10.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO10.UOM, "clicking on UOM", "");
            			driver.findElement(By.xpath(PO10.UOM)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.UOM, "Select the UOM Type",getData("PO10_Line1_UOM").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected UOM", "");
            			Thread.sleep(2000);

            			// Enter QTY
            			babyfunction.ObjectXpathavailable(PO10.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO10.Quantity, "Clicking on Quantity", "");
            			babyfunction.inputbyxpath(PO10.Quantity, "Enter the Qty",getData("PO10_Line1_Quantity").trim());
            			Thread.sleep(2000);

            			// Enter the Price
            			babyfunction.ObjectXpathavailable(PO10.Price, "Price", "");
            			babyfunction.clickbyxpath(PO10.Price, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Price, "Enter the Price", getData("PO10_Line1_Price").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Location, "Location", "");
            			babyfunction.clickbyxpath(PO10.Location, "Click on Location", "");
            			babyfunction.inputbyxpath(PO10.Location, "Enter the Location", getData("PO10_Line1_Location").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Requestor, "Requestor", "");
            			babyfunction.clickbyxpath(PO10.Requestor, "Requestor", "");
            			babyfunction.inputbyxpath(PO10.Requestor, "Enter the Requestor", "Gurumoorthy, Devisri");
            			Thread.sleep(2000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("//div[text()='Need-by Date']/following::input[11]")));
            			
            			babyfunction.ObjectXpathavailable(PO10.NeedToDate, "NeedToDate", "");
            			babyfunction.clickbyxpath(PO10.NeedToDate, "", "");
            			babyfunction.inputbyxpath(PO10.NeedToDate, "Enter The Need of Date",
            					"08/30/2017");
            			Thread.sleep(2000);
            			
            			//Line 2
            			// Click on add icon in lines Tab
            			babyfunction.ObjectXpathavailable(PO10.AddRow, "AddRow", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO10.Lines, "Lines", "");
            			babyfunction.clickbyxpath(PO10.Lines, "Click on Line Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.clickbyxpath(PO10.AddRow, "click on Add icon", "Nil");
            			Thread.sleep(8000);

            			// Enter Line Descriptions
            			babyfunction.ObjectXpathavailable(PO10.Description, "Description", "");
            			babyfunction.clickbyxpath(PO10.Description, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Description,"Enter the Line Description",getData("PO10_Line2_Description").trim());
            			Thread.sleep(2000);

            			// Enter the Line Category Name
            			babyfunction.ObjectXpathavailable(PO10.Category, "Category", "");
            			babyfunction.clickbyxpath(PO10.Category, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Category,
            					"Enter the Line Descriptionsdescription", getData("PO10_Line2_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			// Enter the values for UOM
            			babyfunction.ObjectXpathavailable(PO10.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO10.UOM, "clicking on UOM", "");
            			driver.findElement(By.xpath(PO10.UOM)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.UOM, "Select the UOM Type",getData("PO10_Line2_UOM").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected UOM", "");
            			Thread.sleep(2000);

            			// Enter QTY
            			babyfunction.ObjectXpathavailable(PO10.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO10.Quantity, "Clicking on Quantity", "");
            			babyfunction.inputbyxpath(PO10.Quantity, "Enter the Qty",getData("PO10_Line2_Quantity").trim());
            			Thread.sleep(2000);

            			// Enter the Price
            			babyfunction.ObjectXpathavailable(PO10.Price, "Price", "");
            			babyfunction.clickbyxpath(PO10.Price, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Price, "Enter the Price", getData("PO10_Line2_Price").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Location, "Location", "");
            			babyfunction.clickbyxpath(PO10.Location, "Click on Location", "");
            			babyfunction.inputbyxpath(PO10.Location, "Enter the Location", getData("PO10_Line2_Location").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Requestor, "Requestor", "");
            			babyfunction.clickbyxpath(PO10.Requestor, "Requestor", "");
            			babyfunction.inputbyxpath(PO10.Requestor, "Enter the Requestor", "Gurumoorthy, Devisri");
            			Thread.sleep(2000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("//div[text()='Need-by Date']/following::input[11]")));
            			
            			babyfunction.ObjectXpathavailable(PO10.NeedToDate, "NeedToDate", "");
            			babyfunction.clickbyxpath(PO10.NeedToDate, "", "");
            			babyfunction.inputbyxpath(PO10.NeedToDate, "Enter The Need of Date",
            					"08/30/2017");
            			Thread.sleep(2000);
            			
            			
            			babyfunction.ObjectXpathavailable(PO10.Distributions, "Distributions", "");
            			babyfunction.clickbyxpath(PO10.Distributions, "Click on Distribution Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Row1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Row1", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.POChargeAmount, "POChargeAccountistributions", "");
            			babyfunction.clickbyxpath(PO10.POChargeAmount, "Click on POChargeAccount Tab", "");
            			babyfunction.inputbyxpath(PO10.POChargeAmount, "Entering POChargeAccount", getData("PO10_Line1_ChargeAccount").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Row2, "Row2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Click on Row2", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.POChargeAmount, "POChargeAccountistributions", "");
            			babyfunction.clickbyxpath(PO10.POChargeAmount, "Click on POChargeAccount Tab", "");
            			babyfunction.inputbyxpath(PO10.POChargeAmount, "Entering POChargeAccount", getData("PO10_Line2_ChargeAccount").trim());
            			Thread.sleep(2000);
            			
            			// clicking on final submit button
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Click on the Submit for create Purchase Order", "Nil");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumberLine = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
            			Thread.sleep(2000);
            			String PONumber[] = PurchaseNumberLine.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            			System.out.println("Purchase Order number = "+PONumber[1]);
            			logger.log(LogStatus.PASS,"Purchase Order Number "+PONumber[1]);
            			
            			babyfunction.ObjectXpathavailable(PO10.OkBtn, "", "");
            			babyfunction.clickbyxpath(PO10.OkBtn, "Click Ok confirmation button for PO creation", "NIL");
                        
// PO11 - Modify PO
            			

            			PO11.ManageAndSearchOrder(PONumber[1]);
            			
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Line 1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Line 1", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable("//a[text()='"+PONumber[1]+"']", "PO Nuumber", "");
            			babyfunction.clickbyxpath("//a[text()='"+PONumber[1]+"']", "Click on PO Nuumber", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable("(.//a[@class= 'xfn' and text()= 'Actions'])[1]", "Actions", "");
            			babyfunction.clickbyxpath("(.//a[@class= 'xfn' and text()= 'Actions'])[1]", "Click on Actions", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.Withdraw, "Withdraw", "");
            			babyfunction.clickbyxpath(PO11.Withdraw, "Click on Withdraw", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.WithDrawReason, "Withdraw Reason", "");
            			babyfunction.clickbyxpath(PO11.WithDrawReason, "Withdraw Reason", "");
            			driver.findElement(By.xpath(PO11.WithDrawReason)).clear();
            			babyfunction.inputbyxpath(PO11.WithDrawReason, "Withdraw reason", "Withdraw from automation code");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.OkBtn, "OkBtn", "");
            			babyfunction.clickbyxpath(PO11.OkBtn, "Click on OkBtn", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.confirmationOK, "confirmationOK", "");
            			babyfunction.clickbyxpath(PO11.confirmationOK, "Click on confirmationOK", "");
            			Thread.sleep(2000);
                        
            			babyfunction.ObjectXpathavailable(PO10.Lines, "Lines", "");
            			babyfunction.clickbyxpath(PO10.Lines, "Click on Line Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.Actions, "Actions", "");
            			babyfunction.clickbyxpath(PO11.Actions, "Click on Actions", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.EditOrder, "Edit", "");
            			babyfunction.clickbyxpath(PO11.EditOrder, "Click on Edit", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Lines, "Lines", "");
            			babyfunction.clickbyxpath(PO10.Lines, "Click on Line Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Row1, "Row1", "");
            			babyfunction.clickbyxpath(PO2.Row1, "Click on Row1", "NIL");
            			Thread.sleep(2000);
   
            			// Enter QTY
            			babyfunction.ObjectXpathavailable(PO10.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO10.Quantity, "Clicking on Quantity", "");
            			driver.findElement(By.xpath(PO11.Quantity)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.Quantity, "Enter the Qty",getData("PO11_Line1_Quantity").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO2.Row2, "Row2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Click on Row2", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.Actions, "Actions", "");
            			babyfunction.clickbyxpath(PO11.Actions, "Click on Actions", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.DeleteBtn, "Delete", "");
            			babyfunction.clickbyxpath(PO11.DeleteBtn, "Click on Delete", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO11.YesBtn, "YesBtn", "");
            			babyfunction.clickbyxpath(PO11.YesBtn, "Click on YesBtn", "");
            			Thread.sleep(2000);
            			
            			babyfunction.clickbyxpath(PO10.AddRow, "click on Add icon", "Nil");
            			Thread.sleep(8000);

            			// Enter Line Descriptions
            			babyfunction.ObjectXpathavailable(PO10.Description, "Description", "");
            			babyfunction.clickbyxpath(PO10.Description, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Description,"Enter the Line Description",getData("PO11_Line2_Description").trim());
            			Thread.sleep(2000);

            			// Enter the Line Category Name
            			babyfunction.ObjectXpathavailable(PO10.Category, "Category", "");
            			babyfunction.clickbyxpath(PO10.Category, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Category,
            					"Enter the Line Descriptionsdescription", getData("PO11_Line2_Category").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
            			Thread.sleep(2000);
            			
            			// Enter the values for UOM
            			babyfunction.ObjectXpathavailable(PO10.UOM, "UOM", "");
            			babyfunction.clickbyxpath(PO10.UOM, "clicking on UOM", "");
            			driver.findElement(By.xpath(PO10.UOM)).clear();
            			Thread.sleep(2000);
            			babyfunction.inputbyxpath(PO10.UOM, "Select the UOM Type",getData("PO11_Line2_UOM").trim());
            			babyfunction.clickbyxpath(PO2.Suggestion, " Selected UOM", "");
            			Thread.sleep(2000);

            			// Enter QTY
            			babyfunction.ObjectXpathavailable(PO10.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO10.Quantity, "Clicking on Quantity", "");
            			babyfunction.inputbyxpath(PO10.Quantity, "Enter the Qty",getData("PO11_Line2_Quantity").trim());
            			Thread.sleep(2000);

            			// Enter the Price
            			babyfunction.ObjectXpathavailable(PO10.Price, "Price", "");
            			babyfunction.clickbyxpath(PO10.Price, "clicking on Description", "");
            			babyfunction.inputbyxpath(PO10.Price, "Enter the Price", getData("PO11_Line2_Price").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Location, "Location", "");
            			babyfunction.clickbyxpath(PO10.Location, "Click on Location", "");
            			babyfunction.inputbyxpath(PO10.Location, "Enter the Location", getData("PO11_Line2_Location").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.Requestor, "Requestor", "");
            			babyfunction.clickbyxpath(PO10.Requestor, "Requestor", "");
            			babyfunction.inputbyxpath(PO10.Requestor, "Enter the Requestor", "Gurumoorthy, Devisri");
            			Thread.sleep(2000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("//div[text()='Need-by Date']/following::input[11]")));
            			
            			babyfunction.ObjectXpathavailable(PO10.NeedToDate, "NeedToDate", "");
            			babyfunction.clickbyxpath(PO10.NeedToDate, "", "");
            			babyfunction.inputbyxpath(PO10.NeedToDate, "Enter The Need of Date",
            					"08/30/2017");
            			Thread.sleep(2000);
            			
            			
            			babyfunction.ObjectXpathavailable(PO10.Distributions, "Distributions", "");
            			babyfunction.clickbyxpath(PO10.Distributions, "Click on Distribution Tab", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO2.Row2, "Row2", "");
            			babyfunction.clickbyxpath(PO2.Row2, "Click on Row2", "NIL");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(PO10.POChargeAmount, "POChargeAccountistributions", "");
            			babyfunction.clickbyxpath(PO10.POChargeAmount, "Click on POChargeAccount Tab", "");
            			babyfunction.inputbyxpath(PO10.POChargeAmount, "Entering POChargeAccount", getData("PO11_Line2_ChargeAccount").trim());
            			Thread.sleep(2000);
            			
            			// clicking on final submit button
            			babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
            			babyfunction.clickbyxpath(PO1.Submit, "Click on the Submit for create Purchase Order", "Nil");
            			Thread.sleep(5000);

            			babyfunction.ObjectXpathavailable(PO9.PurchaseOrderNumber, "PurchaseOrderNumber", "");
            			String PurchaseNumberLine2 = driver.findElement(By.xpath(PO9.PurchaseOrderNumber)).getText();
            			Thread.sleep(2000);
            			String PONumber1[] = PurchaseNumberLine2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            			System.out.println("Purchase Order number = "+PONumber1[1]);
            			logger.log(LogStatus.PASS,"Purchase Order Number "+PONumber1[1]);
            			
            			babyfunction.ObjectXpathavailable(PO10.OkBtn, "", "");
            			babyfunction.clickbyxpath(PO10.OkBtn, "Click Ok confirmation button for PO creation", "NIL");
            			
            			babyfunction.ObjectXpathavailable(PO11.Done, "Done", "");
            			babyfunction.clickbyxpath(PO1.Done, "Click on Done", "Nil");
            			Thread.sleep(3000);
            			
            			
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
            			
            			
            			// PO_13 - Approvals
    					PO13.Login("41419");
    					
    					babyfunction.ObjectXpathavailable(PO13.ProcurementWorklist, "ProcurementWorklist", "");
            			babyfunction.clickbyxpath(PO13.ProcurementWorklist, "Clicking on ProcurementWorklist", "");
            			Thread.sleep(5000);
            		//	driver.findElement(By.xpath("html/body")).sendKeys(Keys.CONTROL + "1");
            		//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
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
            			
            			
            			//PO25 - Centralized Receiving
            			
            			navigation.NavigateToWarehouseSupplier();

            			babyfunction.ObjectXpathavailable(PO25.Organization, "Organization", "");
            			babyfunction.clickbyxpath(PO25.Organization, "Clicking on Organization", "NIL");
            			babyfunction.inputbyxpath(PO25.Organization, "Entering organization", "LOL_USA_INV_ORG");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok Button ", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on ok button", "");
            			Thread.sleep(6000);

            			babyfunction.ObjectXpathavailable(PO25.ReceiveExpectedShipment, "ReceiveExpectedShipment ", "");
            			babyfunction.clickbyxpath(PO25.ReceiveExpectedShipment, "Clicking on ReceiveExpectedShipment", "");
            			Thread.sleep(2000);


            			babyfunction.ObjectXpathavailable(PO25.PurchaseOrder, "PurchaseOrder ", "");
            			babyfunction.clickbyxpath(PO25.PurchaseOrder, "Clicking on PurchaseOrder", "NIL");
            			babyfunction.inputbyxpath(PO25.PurchaseOrder, "Entering Purchase Order ", PONumber1[1]);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.DueDate, "DueDate ", "");
            			babyfunction.clickbyxpath(PO25.DueDate, "Clicking on DueDate", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.DueDateTime, "DueDateTime ", "");
            			babyfunction.clickbyxpath(PO25.DueDateTime, "Clicking on Today and the next 30 days", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.Search, "Search ", "");
            			babyfunction.clickbyxpath(PO25.Search, "Clicking on Search", "");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO6.Rowclick, "Rowclick", "");
            			driver.findElement(By.xpath(PO6.Rowclick)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.Receive, "Receive", "");
            			babyfunction.clickbyxpath(PO25.Receive, "Clicking on Receive", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
            			Thread.sleep(2000);

            			// enter the Qty
            			babyfunction.ObjectXpathavailable(PO1.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO1.Quantity, "clicking on quantity", "");
            			driver.findElement(By.xpath(PO1.Quantity)).clear();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO25_Line1_received qty").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.CreateReceipt, "CreateReceipt", "");
            			babyfunction.clickbyxpath(PO25.CreateReceipt, "Click on CreateReceipt", "NIL");
            			Thread.sleep(3000);

            			// click on the final submit button
            			babyfunction.ObjectXpathavailable(PO9.OKBtn, "Submit", "");
            			babyfunction.clickbyxpath(PO9.OKBtn, "Click on Submit", "NIL");
            			Thread.sleep(3000);

            			// Receipt number
            			babyfunction.ObjectXpathavailable(PO25.ReceiptNumber, "ReceiptNumber", "");
            			String WarehouseReceiptNumber = driver.findElement(By.xpath(PO25.ReceiptNumber)).getText();
            			System.out.println("Receipt number is  = " + WarehouseReceiptNumber);
            			Thread.sleep(2000);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");

            			
            			// Line 2
            			babyfunction.ObjectXpathavailable(PO6.Rowclick, "Rowclick", "");
            			driver.findElement(By.xpath(PO6.Rowclick)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.Receive, "Receive", "");
            			babyfunction.clickbyxpath(PO25.Receive, "Clicking on Receive", "NIL");
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO1.RowClick, "RowClick", "");
            			babyfunction.clickbyxpath(PO1.RowClick, "Click on row", "NIL");
            			Thread.sleep(2000);

            			// enter the Qty
            			babyfunction.ObjectXpathavailable(PO1.Quantity, "Quantity", "");
            			babyfunction.clickbyxpath(PO1.Quantity, "clicking on quantity", "");
            			driver.findElement(By.xpath(PO1.Quantity)).clear();
            			driver.findElement(By.xpath(PO1.Quantity)).sendKeys(getData("PO25_Line2_received qty").trim());
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(PO25.CreateReceipt, "CreateReceipt", "");
            			babyfunction.clickbyxpath(PO25.CreateReceipt, "Click on CreateReceipt", "NIL");
            			Thread.sleep(3000);

            			// click on the final submit button
            			babyfunction.ObjectXpathavailable(PO9.OKBtn, "Submit", "");
            			babyfunction.clickbyxpath(PO9.OKBtn, "Click on Submit", "NIL");
            			Thread.sleep(3000);

            			// Receipt number
            			babyfunction.ObjectXpathavailable(PO25.ReceiptNumber, "ReceiptNumber", "");
            			String WarehouseReceiptNumber1 = driver.findElement(By.xpath(PO25.ReceiptNumber)).getText();
            			System.out.println("Receipt number is  = " + WarehouseReceiptNumber1);
            			Thread.sleep(2000);

            			// click on the confirmation ok button
            			babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "OK", "");
            			babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Click on OK", "NIL");
          	
            			// AP_01 - Enter Invoice and 3-Way Match(Line 3) 
            			navigation.NavigatonToInvoices();
            			Thread.sleep(5000);


            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Clicking on Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(ap01.identifying_po, "identifying PO", "");
            			babyfunction.clickbyxpath(ap01.identifying_po, "Clicking on Create INvoice", "NIL");
            			babyfunction.inputbyxpath(ap01.identifying_po, "Entering PO Number",PONumber1[1] );
            			Thread.sleep(4000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Clicking on Invoice number", "NIL");
            			String InvoiceNumber_1_AP01 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Entering Supplier name", InvoiceNumber_1_AP01);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP01);
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Entering Amount", getData("AP-01_Line1_Invoice Amount"));
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.SupplierSite, " SupplierSite", "");
            			babyfunction.clickbyxpath(ap01.SupplierSite, "Clicking on SupplierSite", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SupplierSiteDrp, "SupplierSite option", "");
            			babyfunction.clickbyxpath(ap01.SupplierSiteDrp, "Clicking on SupplierSite option", "");
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
            			babyfunction.inputbyxpath(ap01.Quantity, "Entering Quantity", getData("AP-01_Line1_Match").trim());
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

            			babyfunction.ObjectXpathavailable(ap01.invoice_action_page, "Invoice Actions", "");
            			driver.findElement(By.xpath(ap01.invoice_action_page)).click();
            			Thread.sleep(2000);

            			babyfunction.ObjectXpathavailable(ap01.invoice_validate, " Validate", "");
            			babyfunction.clickbyxpath(ap01.invoice_validate, "Selecting Validate", "");
            			Thread.sleep(5000);
            			
            			babyfunction.ObjectXpathavailable(ap01.SystemHolds, "SystemHolds", "");
            			babyfunction.clickbyxpath(ap01.SystemHolds, "Selecting SystemHolds", "");
            			Thread.sleep(3000);

            			String Image2 = driver.findElement(By.xpath("//select[@title='LOL Image Hold']")).getText();
            			if(Image2.equalsIgnoreCase("LOL Image Hold")){
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
