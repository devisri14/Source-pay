package test.java.com.lol.pages;

import org.openqa.selenium.By;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class AP05 extends TestExecutor{

	public String CreateInvoice = "//a[text()='Create Invoice']";
	public String IdentifyingPO = "//label[text()='Identifying PO']/following::input[1]";
	public String IdentifyingPOSuggestion = "//*[@id='pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:r2:0:ic1::_afrautosuggestpopup']/li[1]";
	public String Number = "//label[text()='Number']/following::input[1]";
	public String Amount = "//label[text()='Type']/preceding::input[1]";
	public String Lines = "//div/h2[text()='Lines']/following::select";
	public String GoBtn = "//img[@title='Go']";
	public String MatchChkBx ="//div[text()='Match']/following::input";
	public String MatchChkBx1 ="//div[text()='Match']/following::input[2]";
	public String Quantity ="//label[text()='Quantity']";
	public String QuantityTxtBox ="//label[text()='Quantity']/preceding::input[1]";
	public String UnitPrice ="//label[text()='Unit Price']/preceding::input[1]";
	public String ManageDistributions ="//td[contains(text(),'Manage Distributions')]";
	public String InvoiceActions ="//a[contains(text(),'Invoice Actions')]";
	public String Validate ="//td[contains(text(),'Validate')]";
	public String OkBtn ="//button[@_afrpdo='ok']";
	public String Approval ="//td[text()='Approval']";
	public String InitiateApproval ="//td[text()='Initiate Approval']";
	public String LineInvoiceAmount = "(//*[text()='Amount']//following::input[@class='x25'])[4]";
	public String TransactionTaxes = "//a[text()='Transaction Taxes']";
	public String EditTaxes = "//button[text()='Edit Taxes']";
	public String RateName = "(//*[text()='Rate Name']//following::input[@type='text' and @class='xng'])[1]";
	public String RateName1 = "(//*[text()='Rate Name']//following::input[@type='text' and @class='xng'])[2]";
	public String SaveAndClose = "//*[text()='Save and Close']";
	public String ExpandTaxes = "//a[@title='Expand Taxes']";
	public String TaxAmount = "//*[text()='Rate Name']//following::input[5]";
	public String TaxAmount1 = "(//*[text()='Rate Name']//following::input[6])[3]";
	
	public void CalculateTax(String RateName) throws InterruptedException{
		
		babyfunction.jsScrollToElement("//*[text()='Taxes']");
		
			int count= driver.findElements(By.xpath("//a[@title='Expand Taxes']")).size();
			if(count==1)
			{
			
				driver.findElement(By.xpath("//a[@title='Expand Taxes']")).click();
				Thread.sleep(2000);
				
				babyfunction.ObjectXpathavailable(AP05.TransactionTaxes, " TransactionTaxes", "");
				babyfunction.clickbyxpath(AP05.TransactionTaxes, "Clicking TransactionTaxes", "");
				Thread.sleep(2000);
				
				babyfunction.ObjectXpathavailable(AP05.EditTaxes, " EditTaxes", "");
				driver.findElement(By.xpath(AP05.EditTaxes)).click();
				//babyfunction.clickbyxpath(AP05.EditTaxes, "EditTaxes", "");
				Thread.sleep(2000);
				
				babyfunction.ObjectXpathavailable(AP05.RateName, " RateName", "");
				babyfunction.clickbyxpath(AP05.RateName, "Clicking RateName", "");
				driver.findElement(By.xpath(AP05.RateName)).clear();
				Thread.sleep(2000);
				babyfunction.inputbyxpath(AP05.RateName, "Entering Rate Name", RateName);
				Thread.sleep(2000);
				
				babyfunction.ObjectXpathavailable(AP05.SaveAndClose, " SaveAndClose", "");
				babyfunction.clickbyxpath(AP05.SaveAndClose, "SaveAndClose", "");
				Thread.sleep(2000);
				
			}
			else{
		
		
		babyfunction.ObjectXpathavailable(AP05.TransactionTaxes, " TransactionTaxes", "");
		babyfunction.clickbyxpath(AP05.TransactionTaxes, "Clicking TransactionTaxes", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(AP05.EditTaxes, " EditTaxes", "");
		babyfunction.clickbyxpath(AP05.EditTaxes, "Clicking EditTaxes", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(AP05.RateName, " RateName", "");
		babyfunction.clickbyxpath(AP05.RateName, "Clicking RateName", "");
		driver.findElement(By.xpath(AP05.RateName)).clear();
		Thread.sleep(2000);
		babyfunction.inputbyxpath(AP05.RateName, "Entering Rate Name", RateName);
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(AP05.SaveAndClose, " EditTaxes", "");
		babyfunction.clickbyxpath(AP05.SaveAndClose, "Clicking EditTaxes", "");
		Thread.sleep(2000);
		
			}
	}
}
