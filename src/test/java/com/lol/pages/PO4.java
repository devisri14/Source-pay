package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO4 extends TestExecutor{

	public String PunchOutCatalog ="//a[text()='Punch Out']";
	public String Supplier ="//a[text()='Airgas ']";
	public String Dashboard = "//a[text()='Dashboard']";
	public String AccountDashboard = "//h1[text()='Account Dashboard']";
	public String Product = "//a[text()='Products']";
	public String Category = "//h2[text()='Category']";
	public String SafetyProduts = "//a[text()='Safety Products']";
	public String Clothing = "//a[text()='Clothing']";
	public String ChemicalClothing = "//a[text()='Chemical Clothing']";
	public String Search = "//input[@placeholder='Search Products or Manufacturers...']";
	public String Quantity = "(.//*[@name='qty'])[1]";
	public String AddToCart = "(//span[text()='Add To Cart'])[1]";
	public String GoToCart = "//a[@title='Go To Cart']";
	public String Checkout = "(.//button[contains(@class,'js-button-checkout')])[1]";
	public String Delete = "(//img[@alt='Delete'])[2]";
	public String Fastenal = "//a[text()='Fastenal']";
	public String Fastenal_Input = ".//*[@id='term']";
	public String Fastenal_Quantity = ".//*[@id='quantity']";
	public String Fastenal_Add = "//button[contains(@class,'submit')]";
	public String Fastenal_Search = ".//*[@class='btn-search']";
	public String Fastenal_Search1 = ".//*[@class='sprite-icon icon-search']";
	public String Fastenal_MyCart = ".//*[@id='myCart-list-item']/a/span";
	public String Fastenal_CheckOut = "(//input[@value='Check Out'])[1]";
	public String Fastenal_Complete_CheckOut = "//input[@value='Complete Checkout']";
	public String EditAndSubmit = "//button[text()='Edit and Submit']";
	}
