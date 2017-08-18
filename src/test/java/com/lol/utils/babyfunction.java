package test.java.com.lol.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test.java.com.lol.tests.TestExecutor;

public class babyfunction extends TestExecutor {
	public String screenshot="D:\\Users\\abinaya-k\\workspace\\LOL_Winfield_Automation\\ScreenShotLib";
	public static void WindowHandle(){
		java.util.Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();

        //patName will provide you parent window
        String patName = itr.next();

        //chldName will provide you child window
        String chldName = itr.next();

        //Switch to child window
        driver.switchTo().window(chldName);
        String pagetitle = driver.getTitle();
       
	}
	
	public static String MonthIncrement(String Format, int monthsToIncrement){
		DateFormat dateFormat = new SimpleDateFormat(Format);
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH, monthsToIncrement);
	    System.out.println("Date after increment: " + cal.getTime());
	    String formatted = dateFormat.format(cal.getTime());
	    System.out.println(formatted);
	    return formatted;
	    
	}
	
	public static String DateDecrement(String Format, int DateToDecrement){
		DateFormat dateFormat = new SimpleDateFormat(Format);
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, DateToDecrement);
	    System.out.println("Date after decrement: " + cal.getTime());
	    String formatted = dateFormat.format(cal.getTime());
	    System.out.println(formatted);
	    return formatted;
	    
	}
	
	public static String DateIncrement(String Format, int DateToIncrement){
		DateFormat dateFormat = new SimpleDateFormat(Format);
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, DateToIncrement);
	    System.out.println("Date after Increment: " + cal.getTime());
	    String formatted = dateFormat.format(cal.getTime());
	    System.out.println(formatted);
	    return formatted;
	    
	}
	
	// Get Random Number //////////////////
		public static String GetRandomNumber() {
			// Create a date object
			Date d1 = new Date();
			// Create formatting object

			SimpleDateFormat formatting = new SimpleDateFormat("hhmmss");
			// Create unique numbers

			System.out.println("Unique Number is  " + formatting.format(d1));
			return formatting.format(d1);

		}
	
	
	
	
	//////// Drop Down Select/////////////////////

	public static void DropSelectbyID(String objects, String description, String testData) {
		try {
			String runtimeText = "";
			int count = driver.findElements(By.id(objects)).size();
			if (count == 1) {
				new Select(driver.findElement(By.id(objects))).selectByVisibleText(testData);
				//Report.pass("Dro down selected successfully " + testData, objects, testData);
			} else {
				//Report.fail(description + " Object not available", objects, testData);
			}

		} catch (Exception e) {
			//Report.fail("Error: " + e, "Nil", "Nil");
		}
	}
	
	
	public static String SplitString(String string){
		try {
		/*String[] splited = string.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
		System.out.println("Splitted string "+splited[1]);*/
			
			String[] splited = string.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
			System.out.println("Splitted string "+splited[1]);
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
		return string;
	}

	///////////////////////////////////////// Click by using
	///////////////////////////////////////// ID///////////////////////
	public static void clickbyid(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.id(objects)).size();
			if (count == 1) {
				driver.findElement(By.id(objects)).click();
				logger.log(LogStatus.PASS, description + " is Clicked");
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Click by using
	///////////////////////////////////////// name///////////////////////
	public static void clickbyname(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.name(objects)).size();
			if (count == 1) {
				driver.findElement(By.name(objects)).click();
				logger.log(LogStatus.PASS, description + " is Clicked");
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Click by using
	///////////////////////////////////////// xpath///////////////////////
	public static void clickbyxpath(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.xpath(objects)).size();
			if (count == 1) {
				Thread.sleep(500);
				driver.findElement(By.xpath(objects)).click();
				Thread.sleep(1000);
				logger.log(LogStatus.PASS, description + " is Clicked");
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Click by using
	///////////////////////////////////////// LinkText///////////////////////
	public static void clickbylinktext(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.linkText(objects)).size();
			if (count == 1) {
				driver.findElement(By.linkText(objects)).click();
				logger.log(LogStatus.PASS, description + " is Clicked");
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Input by using
	///////////////////////////////////////// ID///////////////////////
	public static void inputbyid(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.id(objects)).size();
			if (count == 1) {
				driver.findElement(By.id(objects)).sendKeys(testData);
				logger.log(LogStatus.PASS, description);
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Input by using
	///////////////////////////////////////// name///////////////////////
	public static void inputbyname(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.name(objects)).size();
			if (count == 1) {
				driver.findElement(By.name(objects)).sendKeys(testData);
				logger.log(LogStatus.PASS, description);
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Drop Down Selection Through
	///////////////////////////////////////// Xpath(No test
	///////////////////////////////////////// data)///////////////////////

	public static void DropboxSelectXpath(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.xpath(objects)).size();
			if (count == 1) {

				String dropText = driver.findElement(By.xpath(objects)).getText();
				String[] drop = objects.split("/option");
				new Select(driver.findElement(By.xpath(drop[0]))).selectByVisibleText(dropText);
				logger.log(LogStatus.PASS, description, dropText);
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}

	///////////////////////////////////////// Input by using
	///////////////////////////////////////// xpath///////////////////////
	public static void inputbyxpath(String objects, String description, String testData) {
		try {
			int count = driver.findElements(By.xpath(objects)).size();
			if (count == 1) {
				Thread.sleep(500);
				driver.findElement(By.xpath(objects)).sendKeys(testData);
				Thread.sleep(1000);
				logger.log(LogStatus.PASS, description+" is entered");
			} else {
				logger.log(LogStatus.FAIL, description + " Object not available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}
	
////////Object available validation/////////////////////

public static boolean ObjectXpathavailable(String objects, String description, String testData) {
	try {
		int count = driver.findElements(By.xpath(objects)).size();
		if (count == 1) {
			Thread.sleep(500);
			System.out.println(description +" object available");
			logger.log(LogStatus.PASS, description + "  Object available");
		} else {
			System.out.println(description +" object not available");
			logger.log(LogStatus.FAIL, description + "  Object not available");
		}

	} catch (Exception e) {
		logger.log(LogStatus.FAIL,"Error: " + e);
	}
	return false;
}
public static void jsScrollWindowDown() {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,500)", "");
}
public static void jsScrollToElement(String xPath) throws InterruptedException
{
	WebElement element = driver.findElement(By.xpath(xPath));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(500); 
}

//To Capture Screen Shot
	public String CaptureScreenShot(WebDriver driver, String fileName) {
		// EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
		TakesScreenshot efwd = ((TakesScreenshot) driver);
		File src = efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./ScreenShotLib/" + fileName));
			// FileUtils.copyFile(src, new
			// File("./ScreenShotLib/"+System.currentTimeMillis()+fileName));
		} catch (Exception e) {

		}
		return screenshot+fileName+".jpg";
	}

	


	public static void VerifyPageTitle(String objects, String description, String testData) {
		try {
			String actul_title;
			WebElement Exp_div = driver.findElement(By.xpath(objects));
			actul_title = Exp_div.getText();
			if (actul_title.trim().equals(testData)) {
				logger.log(LogStatus.PASS, description + " title available");
			} else {
				logger.log(LogStatus.FAIL, description + " title available");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"Error: " + e);
		}
	}
	
	
	
	public static void excel(String TestData) {

		try {
			
			File src=new File("C:\\DeviSri\\Test.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheetAt(0);

			
			sh1.getRow(0).createCell(0).setCellValue("Requisition Number");
			sh1.getRow(0).createCell(1).setCellValue("Receipt Number");
			sh1.getRow(0).createCell(2).setCellValue("Invoice Number");
			sh1.getRow(1).createCell(0).setCellValue(TestData);


			// here we need to specify where you want to save file

			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			fout.close();

			} catch (Exception e) {

			System.out.println(e.getMessage());

			}

		}
	
}
	
