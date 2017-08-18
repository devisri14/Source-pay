package test.java.com.lol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction; 

public class PO10 extends TestExecutor{
	
	public String CrateOrder = "//a[text()='Create Order']";
	public String Suppliers = "//label[text()='Supplier']/following::input[1]";
	public String Buyer = "//label[text()='Buyer']/following::input";
	public String DeliverToLocation = "//label[text()='Default Ship-to Location']/following::input[1]";
	public String LocationSuggestion = ".//*[@id='pt1:USra:0:RAp1:0:dynam1:0:DefShipToLoc::_afrautosuggestpopup']/li[1]";
	public String CreateSupplier = "//button[text()='Create']";
	public String NotesAndAttachement ="//a[text()='Notes and Attachments']";
	public String NotesForSupplier = ".//label[text()='Note to Supplier']/following::textarea[1]";
	public String NotesForReceiver = ".//label[text()='Note to Receiver']/following::textarea[1]";
	public String AddRow = "//img[@alt='Add Row']";
	public String Lines = "//div/a[text()='Lines']";
	public String Description = ".//input[@class='x25' and contains(@name, 'Description')]";
	public String Category = ".//*[@class='x2c' and contains(@name,'Category')]";
	public String UOM = "//label[text()='UOM']/preceding::input[1]";
	public String Quantity = "//label[text()='Quantity']/preceding::input[1]";
	public String Price = "(//label[text()='Price']/preceding::input[1])[1]";
	public String Requestor = "(//label[text()='Requester']/preceding::input[1])[1]";
	public String NeedToDate = "//div[text()='Need-by Date']/following::input[11]";
	public String Distributions = "//div/a[text()='Distributions']";
	public String Location = "//div[text()='Price']/following::input[9]";
	public String OkBtn = "//button[@id='d1::msgDlg::cancel']";
	public String POChargeAmount = "//span[text()='PO Charge Account']//following::input[5]";
	public String OrderNumber = "//h1[@class='xm1']";
	
	
	
	public static void addingRow() throws InterruptedException{
		babyfunction.ObjectXpathavailable(PO10.Lines, "Lines", "");
		babyfunction.clickbyxpath(PO10.Lines, "Click on Line Tab", "");
		Thread.sleep(2000);
		
		babyfunction.clickbyxpath(PO10.AddRow, "click on Add icon", "Nil");
		Thread.sleep(8000);

		// Enter Line Descriptions
		babyfunction.ObjectXpathavailable(PO10.Description, "Description", "");
		babyfunction.clickbyxpath(PO10.Description, "clicking on Description", "");
		babyfunction.inputbyxpath(PO10.Description,"Enter the Line Description",getData("PO10_Line1_Description").trim());
		Thread.sleep(2000);

		// Enter the Line Category Name
		babyfunction.ObjectXpathavailable(PO10.Category, "Category", "");
		babyfunction.clickbyxpath(PO10.Category, "clicking on Description", "");
		babyfunction.inputbyxpath(PO10.Category,
				"Enter the Line Descriptionsdescription", getData("PO10_Line1_Category").trim());
		babyfunction.clickbyxpath(PO2.Suggestion, " Selected Category", "");
		Thread.sleep(2000);
		
		// Enter the values for UOM
		babyfunction.ObjectXpathavailable(PO10.UOM, "UOM", "");
		babyfunction.clickbyxpath(PO10.UOM, "clicking on UOM", "");
		driver.findElement(By.xpath(PO10.UOM)).clear();
		Thread.sleep(2000);
		babyfunction.inputbyxpath(PO10.UOM, "Select the UOM Type",getData("PO10_Line1_UOM").trim());
		babyfunction.clickbyxpath(PO2.Suggestion, " Selected UOM", "");
		Thread.sleep(2000);

		// Enter QTY
		babyfunction.ObjectXpathavailable(PO10.Quantity, "Quantity", "");
		babyfunction.clickbyxpath(PO10.Quantity, "Clicking on Quantity", "");
		babyfunction.inputbyxpath(PO10.Quantity, "Enter the Qty",getData("PO10_Line1_Quantity").trim());
		Thread.sleep(2000);

		// Enter the Price
		babyfunction.ObjectXpathavailable(PO10.Price, "Price", "");
		babyfunction.clickbyxpath(PO10.Price, "clicking on Description", "");
		babyfunction.inputbyxpath(PO10.Price, "Enter the Price", getData("PO10_Line1_Price").trim());
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO10.Location, "Location", "");
		babyfunction.clickbyxpath(PO10.Location, "Click on Location", "");
		babyfunction.inputbyxpath(PO10.Location, "Enter the Location", getData("PO10_Line1_Location").trim());
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO10.Requestor, "Requestor", "");
		babyfunction.clickbyxpath(PO10.Requestor, "Requestor", "");
		babyfunction.inputbyxpath(PO10.Requestor, "Enter the Requestor", "Gurumoorthy, Devisri");
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[text()='Need-by Date']/following::input[11]")));
		
		babyfunction.ObjectXpathavailable(PO10.NeedToDate, "NeedToDate", "");
		babyfunction.clickbyxpath(PO10.NeedToDate, "", "");
		babyfunction.inputbyxpath(PO10.NeedToDate, "Enter The Need of Date",
			babyfunction.DateIncrement("MM/dd/yy", 10));
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO10.Distributions, "Distributions", "");
		babyfunction.clickbyxpath(PO10.Distributions, "Click on Distribution Tab", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO10.POChargeAmount, "POChargeAccountistributions", "");
		babyfunction.clickbyxpath(PO10.POChargeAmount, "Click on POChargeAccount Tab", "");
		babyfunction.inputbyxpath(PO10.POChargeAmount, "Entering POChargeAccount", getData("PO10_Line1_ChargeAccount").trim());
		Thread.sleep(2000);
	}

}
