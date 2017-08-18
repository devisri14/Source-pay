package test.java.com.lol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.tests.TestExecutor;
import test.java.com.lol.utils.babyfunction;

public class PO1 extends TestExecutor{

	public String SearchCatalog = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:0:AP1:s4:it1::content']";
	public String ExpandSearchCatalog = "//a[@title='Expand Search Catalog']";
	public String Search = "//td[@class='xya']/input";
	public String SearchGo = "(.//*[@title='Search'])[3]";
	public String EditIcon = ".//*[contains(@id,'edit::icon')]";
	public String QtyTxtBx = "(.//*[@type='text'])[2]";
	public String AddToRequisition = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:srAT:_ATp:srtbl:0:commandButton4']";
	public String AddToRequisitionIC = ".//button[text()='Add to Requisition']";
	public String Add_To_Requisition = "(//button[text()='Add to Requisition'])[1]";
	public String Add_To_Requisition2 = "(//button[text()='Add to Requisition'])[2]";
	public String ReturnToShopping = "//span[text()='Return to Shopping']";
	public String InternalCatalog = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:0:AP1:commandLink5']";
	public String AddToCompare1 = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:srAT:_ATp:srtbl:0:cb1']/a/span";
	public String AddTocompare2 = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:srAT:_ATp:srtbl:1:cb1']/a/span";
	public String Compare = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:cb2']";
	public String CmpAddToRequisition = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:2:AP1:AT3:_ATp:table3:0:commandButton1j_id_1']";
	public String Done = "//button[@accesskey='o']";
	public String ClrCompare = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:cb3']";
	public String EditAndSubmit =".//button[text()='Edit and Submit']";
	public String Duplicate = "//*[@alt='Duplicate']";
	public String RowClick = "(.//*[@class='xpf'])[1]";
	public String Quantity = "(.//input[@class='x25'])[1]";
	public String Quantity2 = "(.//input[@class='x25'])[2]";
	public String Delete = "(.//img[contains(@id,'delete::icon')])[1]";
	public String Requestor = "(//input[@class='x2c'])[1]";
	public String MagnifierSearch = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:2:AP1:DelivB:0:requesterNameId::lovIconId']"; 
	public String Urgent = "(//select[@class='x2h'])[1]";
	public String NeedToDate = ".//input[contains(@id,'inputDate1::content')]";
	public String DeliverToLocation = ".//*[contains(@id,'deliverToLocationId::content')]";
	public String ChargeAccount ="(.//input[@class='x25' and @type='text'])[2]";
	public String BillingRowClick1 = "(.//*[text()='Distribution']//following::td[@class='xdx'])[2]";
	public String Percentage = ".//input[contains(@id,'Percent::content')]";
	public String Split = "//img[@alt='Split']";
	public String BillingRowClick = "(.//*[text()='Distribution']//following::td[@class='xdx'])[1]";
	public String NoteForCustomer = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:DelivB:0:inputText3::content']";
	public String AddAttachment = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:DelivB:0:a1db:clLAdds::icon']";
	public String TypeDrpDwn = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:DelivB:0:a1db:popApplicationsTable:_ATp:popAttachmentTable:0:popDatatypeCodeChoiceListIDNew::content']";
	public String Category = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:DelivB:0:a1db:popApplicationsTable:_ATp:popAttachmentTable:0:socPopCategory::content']";
	public String AttachFilename = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:Creat1:1:AP1:DelivB:0:a1db:popApplicationsTable:_ATp:popAttachmentTable:0:itPopFileText::content']";
	public String ManageApprovals = "//a[@class='x1bo']//span[@class='xkk' and text()= 'Manage Approvals']";
	public String Submit = ".//button[@accesskey='m']";
	public String ReqNo = "//*[contains(text(),'was submitted')]";
	public String SaveBtn = "//span[@class='xkk' and text()='Save']";
	
	
	public static void navigation() throws InterruptedException{
		babyfunction.ObjectXpathavailable(navigation.Navigator, "Navigation", "");
		babyfunction.clickbyxpath(navigation.Navigator, "Click on Navigator", "NIL");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.Procurement, "Procurement", "");
		babyfunction.clickbyxpath(navigation.Procurement, "Clicked on procurement", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(navigation.PurchaseRequisite, "Purchase Requisite", "");
		babyfunction.clickbyxpath(navigation.PurchaseRequisite, "Clicked on purchase requisition", "");
		Thread.sleep(1000);
	}
	
	public static void searchCatolog(String Catalog) throws InterruptedException{
		babyfunction.ObjectXpathavailable(PO1.SearchCatalog, "Search Catalog", "");
		babyfunction.clickbyxpath(PO1.SearchCatalog, "Clicked on searchCatalog", "");
		Thread.sleep(2000);
		
		babyfunction.inputbyxpath(PO1.SearchCatalog, "Entering Search Criteria "+Catalog, Catalog);
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO1.SearchGo, "Search Icon", "");
		babyfunction.clickbyxpath(PO1.SearchGo, "Clicked on search button", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO1.QtyTxtBx, "Quantity text box for item 1", "");
		babyfunction.clickbyxpath(PO1.QtyTxtBx, "Clicked on quantity field", "");
		driver.findElement(By.xpath(PO1.QtyTxtBx)).clear();
		babyfunction.inputbyxpath(PO1.QtyTxtBx, "Updating item quantity", "1");
		Thread.sleep(2000);

		babyfunction.ObjectXpathavailable(PO1.AddToRequisition, "Add To Requisition", "");
		babyfunction.clickbyxpath(PO1.AddToRequisition, "Clicked on Add to requisition button", "");
		Thread.sleep(2000);
		
		babyfunction.ObjectXpathavailable(PO1.ReturnToShopping, "Return to Shopping button", "");
		babyfunction.clickbyxpath(PO1.ReturnToShopping, "Clicked on Return to Shopping", "");
		Thread.sleep(2000);
		
	}
	
	public static void chargeAmount() throws InterruptedException{ 
		
	babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
	babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
	driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
	Thread.sleep(1000);
	babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line1_ChargeAccount").trim());
	
	
	
	babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
	babyfunction.clickbyxpath(PO2.LegacySubLedger, "clicking on LegacySubLedger", "");
	Thread.sleep(2000);
	driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
	Thread.sleep(1000);

	babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ", getData("PO2_Line1_Subledger").trim());
	Thread.sleep(1000);
	
	babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
	babyfunction.clickbyxpath(PO2.AllocadiaID, "Clicking on AllocadiaID", "");
	driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
	Thread.sleep(1000);
	babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID is 100", "100");
	Thread.sleep(1000);
	
	}
	public static void EditAndSubmit() throws InterruptedException{
		// Edit and Submit Requisition
		babyfunction.ObjectXpathavailable(PO1.EditAndSubmit, "Edit and submit button", "");
		babyfunction.clickbyxpath(PO1.EditAndSubmit, "Clicking on Edit and submit button", "");
		Thread.sleep(2000);
	}
	
	public static void DuplicateLine() throws InterruptedException{
		
					// Edit Requisition Header
					babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
					babyfunction.clickbyxpath(PO1.RowClick, "Selecting the row", "");
					Thread.sleep(2000);

					babyfunction.ObjectXpathavailable(PO1.Duplicate, "Duplicate", "");
					babyfunction.clickbyxpath(PO1.Duplicate, "Clicking on Duplicate button", "");
					Thread.sleep(3000);


	}
	
	public static void DeleteLine() throws InterruptedException{
		// Delete Line from requisition
					babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
					babyfunction.clickbyxpath(PO1.RowClick, "Selecting the row", "");
					Thread.sleep(3000);

					babyfunction.ObjectXpathavailable(PO1.Delete, "Delete ", "");
					babyfunction.clickbyxpath(PO1.Delete, "Clicking on delete button", "");
					Thread.sleep(3000);
	}
	
	public static void EditLineDeliveryInfo() throws InterruptedException{
		// Edit Line Delivery Information if different than default
					babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
					babyfunction.clickbyxpath(PO1.RowClick, "Selecting the row", "");
					Thread.sleep(2000);

					babyfunction.ObjectXpathavailable(PO1.Requestor, "Requestor", "");
					String RequestorName = driver.findElement(By.xpath(PO1.Requestor)).getText();
					if (RequestorName != "") {
						logger.log(LogStatus.PASS, "Requestor name is " + RequestorName);
					} else {
						babyfunction.ObjectXpathavailable(PO1.Requestor, "Requestor", "");
						babyfunction.clickbyxpath(PO1.Requestor, "Clicking on Requestor Name", "");
						Thread.sleep(1000);
						babyfunction.inputbyxpath(PO1.Requestor, "Requestor name is Gurumoorthy, Devisri", "Gurumoorthy, Devisri");
						Thread.sleep(2000);
					}

					babyfunction.ObjectXpathavailable(PO1.Urgent, "Urgent flag", "");
					WebElement element = driver.findElement(By.xpath(PO1.Urgent));
					org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
					select.selectByVisibleText("Yes");
					logger.log(LogStatus.PASS, "Selected Urgent Flag");
					babyfunction.ObjectXpathavailable(PO1.Requestor, "Requestor", "");
					Thread.sleep(1000);

					babyfunction.ObjectXpathavailable(PO1.NeedToDate, "Need to Date ", "");
					babyfunction.clickbyxpath(PO1.NeedToDate, "Clicking on Need to Date", "");
					driver.findElement(By.xpath(PO1.NeedToDate)).clear();
					babyfunction.inputbyxpath(PO1.NeedToDate, "Changing the Need to Date", "09/09/2017");
					Thread.sleep(2000);

					babyfunction.ObjectXpathavailable(PO1.DeliverToLocation, "DeliverToLocation", "");
					babyfunction.clickbyxpath(PO1.DeliverToLocation, "Clicking on deliver to location", "");
					Thread.sleep(2000);
					driver.findElement(By.xpath(PO1.DeliverToLocation)).clear();
					Thread.sleep(2000);
					babyfunction.inputbyxpath(PO1.DeliverToLocation, "Entering deliver to location", getData("PO2_Line1_Location"));
					babyfunction.clickbyxpath(PO2.Suggestion, "Seleceted Location", "");
					Thread.sleep(2000);
	}
	
	public static void EditLineBillingInfo() throws InterruptedException{
		// Edit Line Billing information
		Thread.sleep(1000);
					babyfunction.ObjectXpathavailable(PO1.BillingRowClick, "Row Click", "");
					driver.findElement(By.xpath(PO1.BillingRowClick)).click();
					//babyfunction.clickbyxpath(PO1.BillingRowClick, "Selecting the row", "");
					Thread.sleep(2000);


					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line1_ChargeAccount").trim());
					
					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
					babyfunction.clickbyid(PO1.Percentage, "Clicking on Description", "");
					driver.findElement(By.xpath(PO1.Percentage)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO1.Percentage, "Entering Percentage", getData("Percentage").trim());
					
					
					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
					babyfunction.clickbyxpath(PO2.LegacySubLedger, "clicking on LegacySubLedger", "");
					Thread.sleep(2000);
					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
					Thread.sleep(1000);

					babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ", getData("PO2_Line1_Subledger").trim());
					Thread.sleep(1000);
					
					babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
					babyfunction.clickbyxpath(PO2.AllocadiaID, "Clicking on AllocadiaID", "");
					driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID is 100", "100");
					Thread.sleep(1000);

					// Split Billing information
					babyfunction.ObjectXpathavailable(PO1.BillingRowClick, "Row Click", "");
					babyfunction.clickbyxpath(PO1.BillingRowClick, "Selecting the row", "");
					Thread.sleep(2000);


					babyfunction.ObjectXpathavailable(PO1.Split, "Split icon", "");
					babyfunction.clickbyxpath(PO1.Split, "Clicking on split icon", "");
					Thread.sleep(2000);
					
					babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAccount ", "");
					babyfunction.clickbyxpath(PO1.ChargeAccount, "Clicked on ChargeAccount", "");
					driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO1.ChargeAccount, "Entering Charge amount ",getData("PO2_Line1_ChargeAccount").trim());
					
					babyfunction.ObjectXpathavailable(PO1.Percentage, "Percentage ", "");
					babyfunction.clickbyid(PO1.Percentage, "Clicking on Description", "");
					driver.findElement(By.xpath(PO1.Percentage)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO1.Percentage, "Entering Percentage", getData("Percentage").trim());
					
					
					babyfunction.ObjectXpathavailable(PO2.LegacySubLedger, "LegacySubLedger ", "");
					babyfunction.clickbyxpath(PO2.LegacySubLedger, "clicking on LegacySubLedger", "");
					Thread.sleep(2000);
					driver.findElement(By.xpath(PO2.LegacySubLedger)).clear();
					Thread.sleep(1000);

					babyfunction.inputbyxpath(PO2.LegacySubLedger, "LegacySubLedger ", getData("PO2_Line1_Subledger").trim());
					Thread.sleep(1000);
					
					babyfunction.ObjectXpathavailable(PO2.AllocadiaID, "AllocadiaID ", "");
					babyfunction.clickbyxpath(PO2.AllocadiaID, "Clicking on AllocadiaID", "");
					driver.findElement(By.xpath(PO2.AllocadiaID)).clear();
					Thread.sleep(1000);
					babyfunction.inputbyxpath(PO2.AllocadiaID, "AllocadiaID is 100", "100");
					Thread.sleep(1000);
	}
	
	public static void NotesAndAttachements() throws InterruptedException{
		
		 //Notes and Attachments - Line
		  
		  babyfunction.ObjectXpathavailable(PO1.RowClick, "Row Click", "");
		  babyfunction.clickbyxpath(PO1.RowClick, "Selecting the row", "");
		  Thread.sleep(2000);
		  
		  babyfunction.ObjectXpathavailable(PO1.NoteForCustomer,"Note For Customer", "");
		  babyfunction.clickbyid(PO1.NoteForCustomer, "Clicking on note", "");
		  Thread.sleep(1000);
		  babyfunction.inputbyxpath(PO1.NoteForCustomer, "Note For Customer", "This is the notes for suppliers");
		  Thread.sleep(2000);
		  
		  babyfunction.ObjectXpathavailable(PO1.AddAttachment, "AddAttachment", "");
		  babyfunction.clickbyxpath(PO1.AddAttachment,"Clicking on AddAttachment icon", ""); 
		  Thread.sleep(2000);
		  
		  babyfunction.ObjectXpathavailable(PO1.TypeDrpDwn,"Type DropDown ", "");
		  babyfunction.clickbyxpath(PO1.TypeDrpDwn,"Clicking on TypeDrpDwn icon", ""); 
		  Thread.sleep(2000);
		  
		  WebElement Type = driver.findElement(By.xpath(PO1.TypeDrpDwn));
		  org.openqa.selenium.support.ui.Select TypeDrp = new org.openqa.selenium.support.ui.Select(Type);
		  TypeDrp.selectByVisibleText("Text");
		  logger.log(LogStatus.PASS, "Selected value from type dropdown");
		  
		  babyfunction.ObjectXpathavailable(PO1.Category, "Type Category ", ""); 
		  babyfunction.clickbyxpath(PO1.Category,"Clicking on Category icon", ""); 
		  Thread.sleep(2000);
		  
		  WebElement Category = driver.findElement(By.xpath(PO1.Category));
		  org.openqa.selenium.support.ui.Select Categor = new org.openqa.selenium.support.ui.Select(Category);
		  Categor.selectByVisibleText("To Buyer");
		  logger.log(LogStatus.PASS, "Selected value from category dropdown");
		  		  
		  babyfunction.ObjectXpathavailable(PO1.AttachFilename,"AttachFilename ", "");
		  babyfunction.clickbyxpath(PO1.AttachFilename, "Clicking on Attachement filename", "");
		  Thread.sleep(1000);
		  babyfunction.inputbyxpath(PO1.AttachFilename, "Entering attachment Filename", "U:\\permanent\\Information_System\\SQA\\Selenium\\AutomationScripts\\Source2Pay_Project\\NotesSource2pay.txt");
		  Thread.sleep(2000);
		  
		  babyfunction.ObjectXpathavailable(PO2.Title, "Title ", "");
		  babyfunction.clickbyxpath(PO2.Title, "Clicking on title", "");
		  babyfunction.inputbyxpath(PO2.Title," Entering title", "New Test"); 
		  Thread.sleep(2000);

		  // type the descriptions
		  babyfunction.ObjectXpathavailable(PO2.AttachmentDescription,"Attachment Description ", ""); 
		  babyfunction.clickbyxpath(PO2.AttachmentDescription, "Clicking on Attachment description", "");
		  babyfunction.inputbyxpath("Entering description", "Entering description", "Sample test");
		  Thread.sleep(2000);
		  
		  //Clicking ok
		  babyfunction.ObjectXpathavailable(PO9.DocumentOKBtn, "Ok Button",""); 
		  babyfunction.clickbyxpath(PO9.DocumentOKBtn, "Clicking on ok button", "");
		  Thread.sleep(3000);
		 
	}
	
	public static void ChargeAmountVerification() throws InterruptedException{
		java.util.List<WebElement> rows = driver
				.findElements(By.xpath("(//table[contains(@class,'x18w ')])[1]/tbody/tr"));
		System.out.println("No of rows in the table =" + rows.size());
		
		for (int i = 1; i <= rows.size() - 1; i++) {

			driver.findElement(By.xpath("(.//*[@class='xdw'])[" + i + "]")).click();
			Thread.sleep(1000);
			PO1.EditLineDeliveryInfo();
			PO1.chargeAmount();
			
			String ChargeAccount = driver.findElement(By.xpath(PO1.ChargeAccount)).getText();
			if(ChargeAccount!= null){
				System.out.println("Charge Account is " +ChargeAccount);
				
			}else{
				babyfunction.ObjectXpathavailable(PO1.ChargeAccount, "ChargeAmount ", "");
				driver.findElement(By.xpath(PO1.ChargeAccount)).click();
				driver.findElement(By.xpath(PO1.ChargeAccount)).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath(PO1.ChargeAccount)).sendKeys("200.02.2000.179200000.000");
				Thread.sleep(2000);
			}
			
			
			
			
		}
	}
	
	public static void AddApprover() throws InterruptedException{
		// Add Approver to requisition

					babyfunction.ObjectXpathavailable(PO1.ManageApprovals, "Manage Approvals ", "");
					babyfunction.clickbyxpath(PO1.ManageApprovals, "Clicking on ManageApprovals button", "");
					Thread.sleep(4000);

					babyfunction.ObjectXpathavailable(PO1.Submit, "Submit", "");
					babyfunction.clickbyxpath(PO1.Submit, "Clicking on Submit button", "");
					Thread.sleep(3000);

					

					
	}
	}
