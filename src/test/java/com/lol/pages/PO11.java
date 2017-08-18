package test.java.com.lol.pages;

import org.openqa.selenium.By;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO11 extends TestExecutor {

	public String ManageOrders = "//a[text()='Manage Orders']";
	public String Search = "//button[text()='Search']";
	
	public String SearchTable = "(//*[@summary='Headers: Search Results']//tr[1]/td[1])[1]";
	public String ViewDetails = "//button[text()='View Details']";
	public String Actions = "(.//a[@class= 'xfn' and text()= 'Actions'])[2]";
	public String Edit = "(//td[contains(text(),'Edit')])[2]";
	public String AlertYes = "//button[@_afrpdo='yes']";
	public String Quantity = "//label[text()='Quantity']/preceding::input[1]";
	public String Requester = "(//label[text()='Requester']/preceding::input[1])[1]";
	public String Order = "(//input[@class='x25'])[2]";
	public String Status = "(.//td[@class= 'xdx'])[8]";
	public String OrderNo = "//a[@class='xge' and contains(@title,'Purchase Order')]";
	public String Withdraw = ".//*[@class='x1af' and text()='Withdraw']";
	public String EditOrder = "(//td[@class='x1af' and text()= 'Edit'])[2]";
	public String PriceLine1 = "(//label[text()='Price'])[1]//preceding::input[1]";
	public String Price = ".//input[contains(@id,'AmountAsPrice')]";
	public String QuantityLine3 = "(//label[text()='Quantity'])[1]//preceding::input[1]";
	public String PriceLine3 = "(//label[text()='Price'])[1]//preceding::input[1]";
	public String EditOrder1 = "//td[text()='Edit Order']";
	public String save = ".//*[text()='Save']";
	public String RowClick = "(.//*[contains(@class,'xpf')])[1]";
	public String DeleteBtn  = "(//td[text()='Delete'])[2]";
	public String YesBtn = "//button[text()='Yes']";
	public String Duplicate = ".//*[@alt= 'Duplicate']";
	public String OkBtn = "(//button[@_afrpdo='ok'])[1]";
	public String confirmationOK= "//button[@_afrpdo='cancel' and text() = 'OK']";
	public String WithDrawReason = "//*[text()='Withdraw Document']//following::textarea";
	public String Done = "//button[@accesskey='o']";
	public String Description = ".//textarea[@class='x25']";
	public String Yes = "//button[@_afrpdo='yes']";
	public String PopUPok = "(//button[@_afrpdo='cancel'])[1]";
	
	public static void ManageAndSearchOrder(String OrderNumber) throws InterruptedException{
		babyfunction.ObjectXpathavailable(PO11.ManageOrders, "ManageOrder", "");
		babyfunction.clickbyxpath(PO11.ManageOrders, "Click on the Manage Order","Nil");
		Thread.sleep(5000);
		
		babyfunction.ObjectXpathavailable(PO11.Order, "Order", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath(PO11.Order)).clear();
		driver.findElement(By.xpath(PO11.Order)).click();
		driver.findElement(By.xpath(PO11.Order)).sendKeys(OrderNumber);
		
		babyfunction.ObjectXpathavailable(PO11.Search, "Search", "");
		babyfunction.clickbyxpath(PO11.Search, "Click on the Search Button", "");
		Thread.sleep(3000);

		babyfunction.ObjectXpathavailable(PO11.SearchTable, "SearchTable","");
	}
	
	public static void deleteLine() throws InterruptedException{
		
		
		//Delete New Rows						
		babyfunction.ObjectXpathavailable(PO11.RowClick, "RowClick","");
		babyfunction.clickbyxpath(PO11.RowClick, "Click on the row ", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO11.DeleteBtn, "DeleteBtn","");
		babyfunction.clickbyxpath(PO11.DeleteBtn, "Click on the Delete ", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO11.YesBtn, "Yes","");
		babyfunction.clickbyxpath(PO11.YesBtn, "Click on the Yes  ", "");
		Thread.sleep(2000);
	}
	public static void DuplicateLine() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(PO11.RowClick, "RowClick","");
		babyfunction.clickbyxpath(PO11.RowClick, "Click on the row ", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO11.Duplicate, "Duplicate","");
		babyfunction.clickbyxpath(PO11.Duplicate, "Click on the Duplicate ", "");
		Thread.sleep(2000);
		
	}
}
