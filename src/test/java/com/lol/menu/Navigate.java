package test.java.com.lol.menu;

import org.openqa.selenium.WebDriver;

import test.java.com.lol.tests.TestExecutor;


public class Navigate extends TestExecutor {
	
	//private String 
	public Develop Develop;
	WebDriver driver = null;
	
	public Navigate(WebDriver driver){
		this.driver = driver;
		Develop = new Develop(driver);
		
	}
}
