package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO32 extends TestExecutor{
	
	public String RetunReceipts = "//a[text()='Return Receipts']";
	public String ReceiptNo = "//*[text()='Receipt']//following::input[@class='x25']";
	public String RowClick = "//td[contains(@class,'xpf')]";
	public String Return = "//button[text()='Return']";
	public String Quantity = ".//*[contains(@id,'Qtyid')]/input";
}
