package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO12 extends TestExecutor{
	
	public String CancelDocument = ".//*[@class='x1af' and text()= 'Cancel Document']";
	public String Actions = "(.//a[@class= 'xfn' and text()= 'Actions'])[2]";
	public String Reason = ".//textarea[@class= 'x25']";
	public String OkBtn ="(//button[contains(@class,'xno ') and text()='OK'])[1]";
	public String PurchaseCancelStatus = "//*[contains(text(), 'The change order 1 for Purchase Order')]";
	public String OKButton = "(//button[@_afrpdo='cancel'])[2]";
	

}
