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

public class Scenario_44 extends TestExecutor {
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
	public static void Scenario_44() {
		dataUtils.setSheetName("Scenario_44");
        try {
        	System.out.println("No of Rows = "+dataUtils.noOfRows());
            int i = 1;
            while (i <= dataUtils.noOfRows()) {
                  dataUtils.getRowData(i);
                  if (getData("RunThis").toLowerCase().equals("yes")) {
                        logger = report.startTest("Scenario 44");
                        logger.log(LogStatus.INFO, "=======Start Execution Report========");
                        
                        // AP_25 - Enter Non-PO Invoice for Marketing item 
                        
                        
                        navigation.NavigatonToInvoices();
            			Thread.sleep(5000);

            			babyfunction.VerifyPageTitle(ap01.overview_title, "Verify OverView page", "Overview");

            			babyfunction.ObjectXpathavailable(ap01.create_invoices, "Create Invoice", "");
            			babyfunction.clickbyxpath(ap01.create_invoices, "Create INvoice", "NIL");
            			Thread.sleep(2000);

            			babyfunction.VerifyPageTitle("//a[text()='Invoices']", "Verify Invoice page", "Invoices");

            			babyfunction.ObjectXpathavailable(AP25.BU, "BU", "");
            			babyfunction.clickbyxpath(AP25.BU, "BU", "NIL");
            			babyfunction.inputbyxpath(AP25.BU, "BU" , getData("AP25_BU").trim());
            			Thread.sleep(2000);
            			babyfunction.clickbyxpath(PO2.Suggestion, "BU Suggestion", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.Supplier, "Supplier", "");
            			babyfunction.clickbyxpath(AP25.Supplier, "Supplier", "");
            			babyfunction.inputbyxpath(AP25.Supplier, "Supplier", getData("AP25_Supplier").trim());
            			Thread.sleep(2000);
            			babyfunction.clickbyxpath(PO2.Suggestion, "Supplier Suggestion", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(ap01.invoice_number, "Invoice NUmber", "");
            			babyfunction.clickbyxpath(ap01.invoice_number, "Invoice number", "NIL");
            			String InvoiceNumber_1_AP25 = "1-Team1-"+babyfunction.GetRandomNumber();
            			babyfunction.inputbyxpath(ap01.invoice_number, "Invoice Number ", InvoiceNumber_1_AP25);
            			System.out.println("Invoice Number Line 1 = "+InvoiceNumber_1_AP25);
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(ap01.invoice_amount, "Invoice Amoount", "");
            			babyfunction.clickbyxpath(ap01.invoice_amount, "Clicking on Amount", "NIL");
            			babyfunction.inputbyxpath(ap01.invoice_amount, "Amount", getData("AP25_Amount").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.TermDate, "TermDate", "");
            			babyfunction.clickbyxpath(AP25.TermDate, "TermDate", "");
            			driver.findElement(By.xpath(AP25.TermDate)).clear();
            			Thread.sleep(1000);
            			babyfunction.inputbyxpath(AP25.TermDate, "TermDate", babyfunction.DateDecrement("MM/dd/yy", -2));
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.Requester, "Requester", "");
            			babyfunction.clickbyxpath(AP25.Requester, "Requester", "");
            			babyfunction.inputbyxpath(AP25.Requester, "Requester", getData("AP25_Requester").trim());
            			Thread.sleep(2000);
            			babyfunction.clickbyxpath(PO2.Suggestion, "Supplier Suggestion", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.AddRow, "AddRow", "");
            			babyfunction.clickbyxpath(AP25.AddRow, "AddRow", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.Amount, "Amount", "");
            			babyfunction.clickbyxpath(AP25.Amount, "Amount", "");
            			babyfunction.inputbyxpath(AP25.Amount, "Amount", getData("AP25_MatchLine_Amount").trim());
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.Distribution, "Distribution", "");
            			babyfunction.clickbyxpath(AP25.Distribution, "Distribution", "");
            			Thread.sleep(2000);
            			
            			babyfunction.ObjectXpathavailable(AP25.DistributionCombination, "DistributionCombination", "");
            			babyfunction.clickbyxpath(AP25.DistributionCombination, "DistributionCombination", "");
            			babyfunction.inputbyxpath(AP25.DistributionCombination, "DistributionCombination", getData("AP25_ChargeAccount").trim());
            			Thread.sleep(2000);
            			
            			// click on the Action Button
            			Thread.sleep(1000);
            			babyfunction.clickbyxpath(ap01.Action1, "Click on Action drop down", "Nil");
            			Thread.sleep(1000);
            			driver.findElement(By.xpath(AP05.ManageDistributions)).click();
            			Thread.sleep(3000);
            			
            			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            					driver.findElement(By.xpath("(//*[@alt='Details' and @class='x1bi'])[2]")));

            			babyfunction.ObjectXpathavailable(AP25.Details, "Details", "");
            			babyfunction.clickbyxpath(AP25.Details, "Details", "");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(AP25.LegacySubLedger, "LegacySubLedger", "");
            			babyfunction.clickbyxpath(AP25.LegacySubLedger, "LegacySubLedger", "");
            			babyfunction.inputbyxpath(AP25.LegacySubLedger, "DistributionCombination", "10");
            			Thread.sleep(3000);
            			
            			babyfunction.ObjectXpathavailable(PO9.OkButton, "OK Button", "");
            			babyfunction.clickbyxpath(PO9.OkButton, "OK Button", "");
            			Thread.sleep(3000);
            			
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

