package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class AP30 extends TestExecutor{
	
	public String ManageInvoice = "//a[text()='Manage Invoices']";
	public String InvoiceNumber = "(//label[text()='Invoice Number']//following::input[5])[1]";
	public String InvoiceQuery = "//select[contains(@name,'operator1')]";
	public String QueryEquals = "(//select[contains(@name,'operator1')]//following::option[@title= 'Equals'])[1]";
	public String Search = "(//button[text() = 'Search'])[2]";
	public String Lines = "//*[text()='Lines']";
	public String Status = "//tr[contains(@id,'plam8')]/td[2]";
	public String Done = "//button[@accesskey='o']";
}
