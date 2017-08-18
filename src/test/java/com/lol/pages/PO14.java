package test.java.com.lol.pages;

import org.openqa.selenium.By;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO14 extends TestExecutor{

	public String RequsitionNumber = "//label[text()='Requisition']//following::input[1][@type='text']";
	public String Anytime = ".//option[text()='Any time']";
	public String ItemNumber = "(//select[@class='x2h'])[2]";
	public String Search ="//button[text()='Search']";
	public String Receive = "//button[text()='Receive']";
	public String AddNote = "//a[@title='Create Note']";
	public String Note = "//label[text()='Note']//following::TextArea";
	public String ReceiptNumber = "//span[contains(@class,'x1hg')]";
	public String ShowReceiptQuantity = "//button[text()='Show Receipt Quantity']";
	
	
	
}
