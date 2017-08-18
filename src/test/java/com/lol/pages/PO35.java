package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class PO35 extends TestExecutor{

	public String SearchField = ".//*[@type='text']";
	public String SaveAndClose= "//*[@accesskey='S']";
	public String ShoppingList = "(//table[contains(@class,'af_menu_scroll-content')])[4]/tbody/tr";
	public String AddToMyShoppingList = "//span[text()='Add to My Shopping List']";
	public String ReturnToShopping = "//span[contains(text(),'Return to Shopping')]";
	public String ShopList1 = "((//table[contains(@class,'af_menu_scroll-content')])[4]/tbody/tr)[1]";
	public String CreateNew = "((//table[contains(@class,'af_menu_scroll-content')])[4]/tbody/tr)";
	public String ShoppingListName = "//*[text()='My Shopping List']//following::input[@class='x25' and @type='text']";
	public String Shopping_List = "//*[text()='Shopping Lists']";
	
}
