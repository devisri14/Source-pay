package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class AP12 extends TestExecutor{
	public String Invoices = "//span[text()='Payables']/following::a[3]";
	public String createInvoice = ".//a[text() = 'Create Invoice']";
	public String InvoiceNumber = "//label[text()='Number']/following::input[1]";
	public String Amount = "(//*[text()='Amount'])//following::input[@class='x25']";
	
}
