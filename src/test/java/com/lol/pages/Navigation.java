package test.java.com.lol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class Navigation extends TestExecutor{

	public String Navigator = "//img[@title='Navigator']";
	public String Purchasing = ".//*[@id='pt1:nv_itemNode_procurement_purchasing']";
	public String ProcessRequisition = "//a[text()='Process Requisitions']";
	public String Procurement ="//td[@class='x19w']//a[@class='xfn' and text()='Procurement']";
	public String PurchaseRequisite = "//td[text()='Purchase Requisitions']";
	public String NavigatorHeader = "//h1[text()='Navigator']";
	public String Receipt = ".//*[@class='x1af' and text()='Receipts']";
	public String Invoice = "//a[text()= 'Invoices']";
	public String Suppliers = "//a[text()='Suppliers']";
	public String WarehouseReceipt = ".//*[contains(@id,'warehouse_operations_receipts')]";
	public String Home = ".//img[@alt='Home']";

	public static void NavigatonToInvoices() throws InterruptedException {
			
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.Invoice, "Invoice", "");
		babyfunction.clickbyxpath(navigation.Invoice, "Clicking on Invoice", "");
		Thread.sleep(2000);
		
		}
	
	
	public static void NavigateToPurchaseRequisite() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.Procurement, "Procurement", "");
		babyfunction.clickbyxpath(navigation.Procurement, "Clicking on Procurement", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.PurchaseRequisite, "PurchaseRequisite", "");
		babyfunction.clickbyxpath(navigation.PurchaseRequisite, "Clicking on PurchaseRequisite", "");
		Thread.sleep(2000);
	}
	
	public static void NavigateToPurchasing() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.Purchasing, "Purchasing", "");
		babyfunction.clickbyxpath(navigation.Purchasing, "Clicking on Purchasing", "");
		Thread.sleep(2000);
		
	}
	
	public void NavigateToProcessRequsition() throws InterruptedException{
	
	NavigateToPurchasing();
	babyfunction.ObjectXpathavailable(navigation.ProcessRequisition, "ProcessRequisition", "");
	babyfunction.clickbyxpath(navigation.ProcessRequisition, "Clicking on ProcessRequisition", "NIL");
	Thread.sleep(2000);
	
	}
	
	public  void NavigateToSupplier() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "NIL");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.Suppliers, "Suppliers", "");
		babyfunction.clickbyxpath(navigation.Suppliers, "Clicking on Suppliers", "NIL");
		Thread.sleep(2000);
		
	}
	
	public  void NavigateToWarehouseSupplier() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "NIL");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.WarehouseReceipt, "WarehouseReceipt", "");
		babyfunction.clickbyxpath(navigation.WarehouseReceipt, "Clicking on WarehouseReceipt", "NIL");
		Thread.sleep(2000);
		
		
	}
	
	public  void NavigatonToReceipt() {
		try {
			babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigator", "");
			babyfunction.clickbyxpath(navigation.Navigator, "Clicking on Navigator", "NIL");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(navigation.Procurement, "Procurement", "");
			babyfunction.clickbyxpath(navigation.Procurement, "Clicking on Procurement", "NIL");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(navigation.Receipt, "Receipt", "");
			babyfunction.clickbyxpath(navigation.Receipt, "Clicking on Receipt", "NIL");
			Thread.sleep(2000);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
}
}