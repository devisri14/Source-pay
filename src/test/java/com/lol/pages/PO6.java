package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO6 extends TestExecutor{

	public String ManageRequisition = ".//*[@class='xg0' and text()='Manage Requisitions']";
	public String RequsitionNum = "(.//*[@class='x25'])[1]";
	public String Search = ".//*[contains(@class,'xnm ') and text()='Search']";
	public String Rowclick = "//*[contains(@class,'xdw')]";
	public String OkBtn = "//button[@accesskey='Y']";
	public String Shop = "//span[@class='xkk' and text()='Shop']";
	public String ActionEdit = ".//*[@class='x1af' and contains(text() , 'Edit')]";
	public String CancelRequisition = "//td[@class='x1af' and text()='Cancel Requisition']";
	public String Quantity = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:0:AP1:edAT:_ATp:edtbl:0:quantityField::content']";
	public String Delete = "(.//*[@title='Delete'])[1]";
}


