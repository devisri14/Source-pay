package test.java.com.lol.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



import test.java.com.lol.menu.Navigate;
import test.java.com.lol.pages.AP01;
import test.java.com.lol.pages.AP05;
import test.java.com.lol.pages.AP12;
import test.java.com.lol.pages.Navigation;
import test.java.com.lol.pages.PO1;
import test.java.com.lol.pages.PO10;
import test.java.com.lol.pages.PO11;
import test.java.com.lol.pages.PO12;
import test.java.com.lol.pages.PO13;
import test.java.com.lol.pages.PO14;
import test.java.com.lol.pages.PO15;
import test.java.com.lol.pages.PO17;
import test.java.com.lol.pages.PO2;
import test.java.com.lol.pages.PO25;
import test.java.com.lol.pages.PO32;
import test.java.com.lol.pages.PO33;
import test.java.com.lol.pages.PO34;
import test.java.com.lol.pages.PO35;
import test.java.com.lol.pages.PO4;
import test.java.com.lol.pages.PO6;
import test.java.com.lol.pages.PO7;
import test.java.com.lol.pages.PO9;
import test.java.com.lol.utils.Common;
import test.java.com.lol.utils.DataUtils;

public class TestExecutor {

		
	public static WebDriver driver = null;
	public static String userDir = System.getProperty("user.dir");
	public static DesiredCapabilities cap = null;
	public static Navigate Navigate;
	public static Common common;
	public static ExtentTest logger;
	public static DataUtils dataUtils;
	public static Properties prop = new Properties();
	public static JavascriptExecutor jscript = null;
	public static Navigation navigation = new Navigation();
	public static PO2 PO2 = new PO2();
	public static PO9 PO9 = new PO9();
	public static PO11 PO11 = new PO11();
	public static PO12 PO12 = new PO12();
	public static PO35 PO35 = new PO35();
	public static AP05 AP05 = new AP05();
	public static PO1 PO1 = new PO1();
	public static PO6 PO6 = new PO6();
	public static PO7 PO7 = new PO7();
	public static PO10 PO10 = new PO10();
	public static PO4 PO4 = new PO4();
	public static PO15 PO15 = new PO15();
	public static AP12 AP12 = new AP12();
	public static test.java.com.lol.pages.AP25 AP25 = new test.java.com.lol.pages.AP25();
	public static PO14 PO14 = new PO14();
	public static PO17 PO17 = new PO17();
	public static PO13 PO13 = new PO13();
	public static PO25 PO25 = new PO25();
	public static PO32 PO32 = new PO32();
	public static PO33 PO33 = new PO33();
	public static PO34 PO34 = new PO34();
	public static AP01 ap01 = new AP01();
	public static test.java.com.lol.pages.AP30 AP30 = new test.java.com.lol.pages.AP30();
	
	public static LoginAndLogout Login = new LoginAndLogout();
	
	public Map<String, String> map = new HashMap<String, String>();
//	public WebDriverWait wait = new WebDriverWait(driver, 10);
	public DataFormatter formatter = new DataFormatter();
	public FileInputStream File;
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	

	static ExtentReports report;
	FileInputStream fis = null;
	 String className = this.getClass().getName();
	
	@BeforeClass(enabled = true)
	public static ExtentReports launch() {
		String destFile = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		destFile = userDir + "\\test-output\\extentreports\\ecom";
		String destDir = dateFormat.format(new Date()) + ".html";
		report = new ExtentReports(destFile + "\\" + "C18998_Execution" + "_" + destDir, true);
		report.loadConfig(new File(userDir + "\\src\\test\\java\\com\\usfoods\\ecom\\config\\reports.xml"));
		return report;
	}
	
	@BeforeSuite(enabled = false)
	public void Start() {
	}

	@BeforeMethod(enabled = true)
	public void startTest(Method method) throws IOException {
		initialize();
		//System.setProperty("webdriver.gecko.driver","D:\\Selenium jar files\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		// pass the sheet name corresponding to the test case
		
	}
	
	public static void loadPropertiesFile() throws IOException
	{
		FileInputStream fn = null;
		fn = new FileInputStream(userDir
				+ "\\src\\test\\java\\com\\lol\\config\\config.properties");		
		prop.load(fn);		
	}
	@Parameters("browser")
	public static void initialize() throws IOException {
		

		if (driver == null) {

			// Initialize CONFIG property file
			loadPropertiesFile();		
			
			if (prop.getProperty("browser", "Firefox").equals("Firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				File pathBinary = new File(
						"C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//				"C:\Program Files (x86)\Mozilla Firefox\firefox.exe"
				FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				driver = new FirefoxDriver(firefoxBinary, firefoxProfile, cap);
				// driver= new FirefoxDriver(cap);
				cap.setPlatform(Platform.ANY);
			} else if (prop.getProperty("browser", "Firefox").equals("iexplore")) {
				System.out.println(prop.getProperty("browser"));
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\ProfileDisk\\k256026\\Downloads\\IEDriverServer.exe");
				cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(cap);
				cap.setPlatform(Platform.ANY);

			} else if (prop.getProperty("browser", "Firefox").equals("chrome")) {
				System.out.println(prop.getProperty("browser"));
				System.setProperty("webdriver.chrome.driver", "U:\\permanent\\Information_System\\SQA\\Selenium\\AutomationScripts\\JDE - Winfield\\Abinaya-Scripts\\sabarish folder JDE winfeild file\\LOL_Winfield_Automation\\Exe driver\\chromedriver.exe");
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				driver = new ChromeDriver(cap);
				cap.setPlatform(Platform.ANY);
			}
			// driver = new RemoteWebDriver(
			// new URL(System.getProperty("hub")), cap);
		}
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		Navigate = new Navigate(driver);
		common = new Common();
		dataUtils = new DataUtils();
		
		// webTable = new Table(driver);
		jscript = (JavascriptExecutor) driver;
	}

	public static String getData(String columnName)
	{
		return dataUtils.getMapValue(columnName);
	}
}
