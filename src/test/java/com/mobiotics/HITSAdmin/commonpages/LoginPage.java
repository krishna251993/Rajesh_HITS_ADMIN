package com.mobiotics.HITSAdmin.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.HITSAdmin.constants.BaseTest;


public class LoginPage extends BaseTest{
	
	public LoginPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	                               
	@FindBy(name = "adminid")
	private WebElement adminUserName;
	
	@FindBy(name = "password")
	private WebElement adminPassword;
	
	@FindBy(name = "passphrase")
	private WebElement adminPassphrase;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	public void login(String username, String password, String passphrase)
	{
		adminUserName.sendKeys(username);
		adminPassword.sendKeys(password);
		adminPassphrase.sendKeys(passphrase);
		loginBtn.click();
	}
	
	
	

}
