package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO33 extends TestExecutor{
	
	public String ManageReceipt = "//a[text()='Manage Receipts']";
	public String Correct = "//td[@class='x1af' and text()='Correct']";
	public String CorrectQuantity = "//label[text()='Correct Quantity']//preceding::input[@class='x25']";
}
