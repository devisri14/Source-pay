package test.java.com.lol.utils;

import org.openqa.selenium.By;

import test.java.com.lol.tests.TestExecutor;

public class Applications extends TestExecutor {
	
	public void blackline()
	{
		driver.get("https://landolakes.us1.blackline.com"); common.sleep(6000);
		driver.manage().window().maximize();
		//driver.quit();
	}
	
	public void ag2ag()
	{
		driver.get("https://www.ag2ag.com/ag2ag/index.asp"); common.sleep(6000);
		driver.manage().window().maximize();
		//driver.quit();
	}
	
	
	public void OTM()
	{
		driver.get("http://ahpoul201/GC3/glog.webserver.servlet.umt.Login"); common.sleep(6000);
		driver.manage().window().maximize();
		//driver.quit();
	}
	
	public  void fbs() throws InterruptedException
	{
		driver.get("https://www.ag2ag.com/businesslink/security/login.asp");Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("kannaa01");Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Jan.201601");Thread.sleep(2000);
		driver.findElement(By.id("BLLLoginSubmitBtn")).click();Thread.sleep(20000);
		//driver.close();

	}

	public  void mpol() throws InterruptedException
	{
		driver.get("http://mpis.landolakes.com");Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='USER']")).sendKeys("kannaa01");Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='PASSWORD']")).sendKeys("Jan.201601");Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Login']/div[3]/button")).click();Thread.sleep(8000);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div/div[2]/h4/span/a")).click();Thread.sleep(5000);
		//driver.close();
	}

	

}
