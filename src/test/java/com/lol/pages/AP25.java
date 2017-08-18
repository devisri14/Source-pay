package test.java.com.lol.pages;

import com.relevantcodes.extentreports.model.Test;

import test.java.com.lol.tests.TestExecutor;

public class AP25 extends TestExecutor{
	
	public String BU = "(//*[@class='xng'])[2]";
	public String Supplier = "(//input[@class='x2c'])[3]";
	public String AddRow = "//img[@title='Add Row']";
	public String Amount = "//select[@title= 'Item']//following::input[1]";
	public String TermDate = "(//a[@title='Select Date'])[1]//following::input[1]";
	public String Distribution = "//a[text()='Distribution']";
	public String DistributionCombination = "//select[@title= 'Item']//following::input[3]";
	public String Details = "(//img[@title='Details'])[2]";
	public String LegacySubLedger = "//input[@class='xng' and contains(@id,'LOL_LEGACY_SUBLEDGER')]";
	public String Requester = "(//a[@title='Select Date'])[1]//following::input[3]";
	
}
