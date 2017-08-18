package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO9 extends TestExecutor{

	public String RequsitionBU = "(//label[text()='Requisitioning BU']/following::select)[1]";
    public String LOLUSA = "//option[@title='Land OLakes USA']";
    public String Requisition = "(//label[text()='Requisition']/following::input[@class='x25'])[1]";
	public String SearchBtn = "//button[text()='Search']";
	public String Buyer = "//label[text()='Buyer']//following::input[@class='xng']";
	public String RequsitionLine = "(//*[@summary='Search Results: Requisition Lines']//tr[1]/td[1])[1])";
	public String Actions = "//a[text()='Actions']";
	public String Return = "//td[text()='Return']";
	public String Reason = "//label[text()='Reason']//following::textarea";
	public String OKBtn = "//button[@accesskey='m']";
	public String PopupOkBtn = "(//div[text()='The selected requisition lines were returned.']//following::button[text()='OK'])[1]";
	public String AddToDocumentBuilder = "//*[contains(@class,'x7j') and text()='Add to Document Builder']";
	public String DocumentType = "//label[text()='Type']//following::select";
	public String SourceAgreement = "//label[text()='Source Agreement']//following::input[1]";
	public String DocumentOKBtn = "//button[@accesskey='K']";
	public String OkButton = "(//button[@_afrpdo='ok'])[1]";
	public String Ok = "//button[contains(@id,':msgDlg::cancel')]";
	public String DocumentEdit = "//button[text()='Edit']";
	public String DocumentBuilderTable = "//table[@summary='Document Builder Lines']/tbody/tr/td[1]";
	public String DocumentCreate = "//button[text()='Create']";
	public String DocumentPopUpOK = "//button[@id='d1::msgDlg::cancel']"; 
	public String RowLineSize = "//table[contains(@class,'x18w')]/tbody/tr";
	public String Delete = ".//*[contains(@id,'delete::icon')]";
	public String Create = "//button[text()='Create']";
	public String PurchaseOrderNumber = "//*[contains(text(),'The document (Purchase Order)')]";
	
}