package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO25 extends TestExecutor{
	
	public String Organization = "//input[contains(@name,'orgCodeId')]";
	public String ReceiveExpectedShipment = ".//a[text()='Receive Expected Shipments']";
	public String PurchaseOrder = "//label[text()='Purchase Order']/following::input[1]";
	public String DueDate = "//select[@class='x2h' and contains(@title,'Today')]";
	public String DueDateTime = "//option[@title='Today and the next 30 days']";
	public String Search = "//button[text()='Search']";
	public String Receive = "//button[text()='Receive']";
	public String ShowReceipt= "//button[text()='Show Receipt Quantity']";
	public String Quantity = "//span[contains(@id,'Quantityid')]";
	public String CreateReceipt = "//button[text()='Create Receipt']";
	public String ReceiptNumber = "//td[@class='x1o']/span";
	
}
