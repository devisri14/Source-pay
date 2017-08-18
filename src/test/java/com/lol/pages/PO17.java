package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO17 extends TestExecutor{

	public String CreateSuppliers = "//a[text()='Create Supplier']";
	public String SupplierName = "(//label[text()='Supplier']//following::input)[1]";
	public String BusinessRelationShip = ".//*[@id='pt1:USra:0:RAp1:0:dynam1:0:soc2::content']/option[2]";
	public String TaxOrganizationType = ".//*[@id='pt1:USra:0:RAp1:0:dynam1:0:soc1::content']/option[3]";
	public String TaxCountry =".//*[contains(@id,'countryNameId::content')]";
	public String CreateBtn = "//button[contains(text(),'Create')]";
	public String IncomeTax = "//a[text()='Income Tax']";
	public String TaxPayerCountry = ".//input[@class='xng' and contains(@name,'territoryShortNameId')]";
	public String India = "//li[text()='India IN']";
	public String FederalReportable = "//input[@type='checkbox' and contains(@name,'FdrlReportableFlagId')]";
	public String FederalIncomeTaxType = "(//label[text()='Federal Income Tax Type']//following::input)[1]";
	public String Addresses = "//a[text()='Addresses']";
	public String Create = "//td[text()='Create']";
	public String AddressName = "(//label[text()='Address Name']//following::input)[1]";
	public String AddressLine1 = "(.//*[@class='x25'])[3]";
	public String State = "(.//*[@class='x25'])[7]";
	public String PostalCode = "(.//*[@class='x25'])[8]";
	public String Phone = "(.//*[@class='x25'])[11]";
	public String AddressPurpose = "(//legend[text()='* Address Purpose']//following::input)[1]";
	public String SaveAndClose = "//button[@accesskey='S']";
	public String Edit  = "//td[text()='Edit']";
	}
