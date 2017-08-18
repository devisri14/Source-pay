package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO16 extends TestExecutor {
	
	public static String UserName = ".//a[contains(@class,'xg9 xga')]";
	public static String SetupAnMaintainance = "//a[text()='Setup and Maintenance...']";
	public static String ManageImplementation = "//a[text()='Manage Implementation Projects']";
	public static String ProcurementExpand  = "(//*[text()='Procurement']//preceding::a[@title= 'Expand'])[2]";
	public static String CommonProcurementExpand = "(.//*[@title='Expand'])[3]";
	public static String Project = "//a[contains(text(),'Configure SIT CP')]";
	public static String ManageCatalogTask = "//*[contains(@href,'ManageCatalog')]";
	public static String CategoryHierarchy = "//a[text()='Category Hierarchy']";
	public static String CreateCategory = "//td[text()='Create Category']";
	public static String CategoryName  = "(//input[@class='x25'])[2]";
	public static String Description = "(//input[@class='x25'])[4]";
	public static String Commodity = "//input[contains(@name,'COMMODITY')]";
	public static String ExpandAdditionalInfo = "//a[@title='Expand Additional Information']";
	public static String TaxExemptionState = "//input[contains(@name,'TAX_EXEMPT_STATES__FLEX')]";
	
	public static void AdministrationSetup() throws InterruptedException{
		
		babyfunction.ObjectXpathavailable(PO16.UserName, "UserName","");
		babyfunction.clickbyxpath(PO16.UserName, "Click on UserName", "NIL");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO16.SetupAnMaintainance, "SetupAnMaintainance","");
		babyfunction.clickbyxpath(PO16.SetupAnMaintainance, "Click on SetupAnMaintainance", "NIL");
		Thread.sleep(2000);
		
		
	}

}
