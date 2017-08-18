package test.java.com.lol.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO2 extends TestExecutor{

	
	public String NonCatalogRequest = "//a[contains(text(),'Noncatalog Reques')]";
	public String ItemType = "//label[text()='Item Type']/following::select[1]";
	public String Goods = "//option[contains(text(),'Goods')]";
	public String Services = "//option[contains(text(),'Services')]";
	public String Description = "//label[text()='Description']/following::textarea";	
	public String CategoryName = "//label[text()='Category Name']/following::input[1]";
	public String InternalCatQuantity = ".//*[contains(@id,'quantity')]//input";
	public String RowQuantity = "//*[contains(@name,'quantityField')]";
	public String Quantity = "//label[text()='Quantity']/following::input[contains(@id,'quantity')]";
	public String UOM = "//label[text()='UOM']/following::input[1]";
	public String Price = "//label[text()='Price']/following::input[contains(@name,'currUnitPriceItemRN')]";
	public String Amount = "//label[text()='Amount']/following::input[contains(@name,'currencyAmount')]";
	public String Supplier = "//a[@title='Search: Supplier']/preceding::input[1]";
	public String AddBtn = "//a[text()='View']/following::a[2]";
	public String Type = "(//div[text()='Type']/following::select)[1]"; 
	public String TypeText = "//option[contains(text(),'Text')]";
	public String Category = "(//div[text()='Category']/following::select)[2]";
	public String ToBuyer = "//option[contains(text(),'To Buyer')]";
	public String FileNameTextArea = "//div[text()='Type']/following::textarea";
	public String Title = "//div[text()='Title']/following::input[4]";
	public String AttachmentDescription = "//div[text()='Title']/following::input[5]";
	public String AddToRequisition = "//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:commandButton1']/a/span";
	public String EditAndSubmitBtn = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:cb1']";
	public String EditTable = "//table/tbody/tr/td[2]/div/table/tbody/tr/td[2]";
	public String ChargeAmount = "//table/tbody/tr/td[1]/span/input";
	public String LegacySubLedger = ".//span[text()='LEGACY SUBLEDGER']/following::input[5]";
	public String LegacySubledger = ".//span[text()='LEGACY SUBLEDGER']/following::input[4]";
	public String AllocadiaID = ".//span[text()='ALLOCADIA ID (Marketing Only)']/following::input[6]";
	public String AllocadiaId = ".//span[text()='ALLOCADIA ID (Marketing Only)']/following::input[5]";
	public String EditReqSave = "//button[@accesskey='m']/preceding::span[contains(text(),'Save')]";
	public String EditReqSubmit = "//button[@accesskey='m']";
	public String RequisiteNumber = "//div[text()='Confirmation']/following::div[2]";
	public String ConfPopupOKBtn = "//button[@accesskey='K']";
	public String AddApprover = "//img[contains(@src,'add')]";
	public String User = "//input[contains(@id,'addAssigneeUserName')]";
	public String RowClick = "//td[@class='xpf']";
	public String Row1 = "(//*[@class='xpf'])[1]";
	public String Row2 = "(//*[@class='xpf'])[2]";
	public String Row3 = "(//*[@class='xpf'])[3]";
	public String Row4 = "(//*[@class='xpf'])[4]";
	public String Suggestion = ".//li[@class='AFAutoSuggestItem']";
	public String EmergencyPO = "//input[@type='checkbox']";  
	public String Actions = "//*[text()='Actions']";
	public String EditAction  = "(//*[text()='Actions'])[1]";
	public String WithdrawAndEdit = "//*[text()='Withdraw and Edit']";
	public String Yes = "//button[@accesskey = 'Y']";
	
	public void NonCatalogRequestHeader(String Description, String Category, String Supplier, String Quantity, String UOM, String Price){
		try {
			
			babyfunction.ObjectXpathavailable(PO2.Description, "Description", "");
			babyfunction.clickbyxpath(PO2.Description, "Click on Description", "NIL");
			driver.findElement(By.xpath(PO2.Description)).clear();
			babyfunction.inputbyxpath(PO2.Description, "Entering Description", Description);
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO2.CategoryName, "CategoryName", "");
			babyfunction.clickbyxpath(PO2.CategoryName, "Click on CategoryName", "NIL");
			driver.findElement(By.xpath(PO2.CategoryName)).clear();
			babyfunction.inputbyxpath(PO2.CategoryName, "Entering CategoryName", Category);
			babyfunction.clickbyxpath(PO2.Suggestion, " Selected "+Category, "");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO2.Supplier, "Supplier", "");
			babyfunction.clickbyxpath(PO2.Supplier, "Click on Supplier", "NIL");
			driver.findElement(By.xpath(PO2.Supplier)).clear();
			babyfunction.inputbyxpath(PO2.Supplier, "Entering Supplier", Supplier);
			babyfunction.clickbyxpath(PO2.Suggestion, " Selected "+Supplier, "");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO2.Quantity, "Quantity", "");
			babyfunction.clickbyxpath(PO2.Quantity, "Click on Quantity", "NIL");
			driver.findElement(By.xpath(PO2.Quantity)).clear();
			babyfunction.inputbyxpath(PO2.Quantity, "Entering Quantity", Quantity);
			Thread.sleep(2000);

			babyfunction.ObjectXpathavailable(PO2.UOM, "UOM", "");
			babyfunction.clickbyxpath(PO2.UOM, "Click on UOM", "NIL");
			driver.findElement(By.xpath(PO2.UOM)).clear();
			babyfunction.inputbyxpath(PO2.UOM, "Entering UOM", UOM);
			babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted "+UOM, "");
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO2.Price, "Price", "");
			babyfunction.clickbyxpath(PO2.Price, "Click on Price", "NIL");
			driver.findElement(By.xpath(PO2.Price)).clear();
			babyfunction.inputbyxpath(PO2.Price, "Entering Price", Price);
			Thread.sleep(2000);
			
			babyfunction.ObjectXpathavailable(PO2.AddToRequisition, "AddToRequisition", "");
			babyfunction.clickbyxpath(PO2.AddToRequisition, "Click on AddToRequisition", "NIL");
			Thread.sleep(2000);
			}catch (InterruptedException e) {
			e.printStackTrace();
			}
				
	}

	public void ClearRequisition(){
		
		java.util.List<WebElement> Reqline = driver.findElements(By.xpath("//img[@alt='Delete']"));
		System.out.println("Existing Line = "+Reqline.size());
		for(int i =1; i<=Reqline.size();i++){
		if(Reqline.size()!=0){
		babyfunction.ObjectXpathavailable("(//img[@alt='Delete'])["+i+"]", "Existing Requisition Line", "");
		babyfunction.clickbyxpath("(//img[@alt='Delete'])["+i+"]", "", "");
		}
		i--;
		}
	}




}
