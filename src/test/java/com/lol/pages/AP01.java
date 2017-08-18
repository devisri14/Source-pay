package test.java.com.lol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class AP01 extends TestExecutor {
	
	public String create_invoices = "//a[text()='Create Invoice']";
	public String manage_invoice="//a[text()='Manage Invoices']";
	public String invoiceNUm="(//input[@class='x25'])[2]";
	public String invoiceSearch="(//button[text()='Search'])[2]";
	public String invoice_Team_number="//a[text()='1-Team1-18']";
	public String invoiceUnpaid="(//span[text()='Paid']/../following::span)[1]";
	public String invoiceActn="//a[text()='Actions']";
	public String invoiceCancel="//td[text()='Cancel Invoice']";
	public String invoicesaaveANdcloase="//span[text()='ave and Close']";
	public String SupplierSite = "(//span[@class='x1f6'])[3]";
	public String SupplierSiteDrp = "//tr[@class='xdw']/td[1]";
	public String OK= "(//button[@_afrpdo ='cancel'])[1]";
	public String MatchLineAdd = "//img[contains(@id,'create::icon')]";
	public String AddAmount = "//*[@title='Item']//following::input[1]";
	public String Type = "//select[@title='Item']";
	public String Freight = "//option[text()='Freight']";
	
	public String identifying_po="(//input[@class='x2c'])[2]";
	public String invoice_number="(//input[@class='x25'])[3]";
	public String InvoiceNumber = "(//input[@class='x25'])[2]";
	public String invoice_amount="(//input[@class='x25'])[4]";
	public String payment_terms="pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:r2:0:so3::content";
	public String match_invoice="pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:so3::content";
	public String match_invoice1="//select[@class='x2h' and @title = 'Standard']";
	public String correction_type="pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:r10:1:at1:_ATp:ta1:0:so1::content";
	public String corret_quantity = "(//input[@class='x25'])[5]";
	public String CorrectMemo = "//option[@title='Credit memo']";
	
	public String Quantity = "(//*[text()='Quantity']//following::input[3])[2]";
	public String Quantity1 = "(//*[text()='Quantity']//following::input[3])[3]";
	public String CorrectedQuantity = "//*[text()='Quantity']//following::input[5]";
	
	public String quantity = "(//input[@class='xyt' and @type='checkbox'])[2]//following::input";
	public String quantity1 = "(//input[@class='xyt' and @type='checkbox'])[3]//following::input";
	public String quantity2 = "(//input[@class='xyt' and @type='checkbox'])[4]//following::input";
	
	public String Amount = "(//*[text()='Quantity']//following::input[4])[4]";
	
	public String Actions = "//*[text()= 'Actions']";
	public String Action1 = "(//*[text()= 'Actions'])[1]";
	public String Edit = "//*[text()= 'Edit']";
	
	public String overview_title="//h1[text()='Overview']";

	public String OverBillWaringMsg = "//span[contains(text(),'Completing')]";

	public String invoice_lines_dropdown_go="//img[@title='Go']";
	public String invoice_match_box="(//input[@class='xyt' and @type='checkbox'])[1]";
	
	public String invoice_select_match_checkbox="(//input[@class='xyt' and @type='checkbox'])[2]";
	public String invoice_select_match_checkbox1="(//input[@class='xyt' and @type='checkbox'])[3]";
	public String invoice_select_match_checkbox2 = "(//input[@class='xyt' and @type='checkbox'])[4]";
	
	public String invoice_enter_quantity="(//input[@class='xyt' and @type='checkbox'])[2]/../../../../following::input[1]";
	public String invoice_enter_unitPrice="(//input[@class='xyt' and @type='checkbox'])[2]/../../../../following::input[2]";
	public String invoice_enter_amount="(//input[@class='xyt' and @type='checkbox'])[2]/../../../../following::input[3]";
	
	public String invoice_ok="//span[text()='K']";
	public String invoice_page="//a[text()='Invoices']";
	public String invoice_aaction_page="//a[text()='Invoice Actions']"; 
	public String invoice_action_page="(//a[@class='xfn'])[1]";
	public String invoice_validate="//td[text()='Validate']";
	public String invoice_hold="(//span[@class='x1a']/a)[3]";
	public String inovice_name="pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:r6:1:at1:_ATp:ta1:0:so2::content";
	public String invoice_name1="pt1:USma:0:MAnt1:0:pm1:r1:1:ap1:r6:1:at1:_ATp:ta1:1:so2::content";
	public String SystemHolds = ".//*[text()='System Holds']//following::a[1]";
	public String ImageHold = "//select[@title='LOL Image Hold']";
	public String ImageHoldReason = "(//*[text()='Name']//following::select[@class='x2h'])[2]";
	public String ImageRelesed = "(//*[text()='LOL Image Released'])[1]";
	public String SaveAndClose = "//button[text()='ave and Close']";
	public String Warning = "//div[@class='x1dz']";
	public String warning_Ok = "(//button[@type='button' and text() = 'OK'])[1]";
	
	
	public String invoice_approvel="//td[text()='Approval']";
	public String invoice_initial_approvel="//td[text()='Initiate Approval']";
	
	
	public String invoice_IMage1="(//a[@title='Details'])[2]/img";
	public String invoice_image2="(//a[@title='Details'])[3]/img";
	public String invoiceOkey="//button[text()='OK']";
	public String InvoiceSaveAndClose = "//a[@accesskey='S']";
	
	
	


	}
