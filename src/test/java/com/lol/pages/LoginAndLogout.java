package test.java.com.lol.pages;

import test.java.com.lol.tests.TestExecutor;

public class LoginAndLogout extends TestExecutor {
	
	public String Username =".//*[@id='userid']";
	public String Password="//input[@type='password']";
	public String SignIn=".//*[@type='submit']";
	public String SignOut=".//*[text()='Sign Out']";
	public String ConfirmSignout=".//*[@id='Confirm']";
	
	
	

}
