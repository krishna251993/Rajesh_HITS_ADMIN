package com.mobiotics.HITSAdmin.commonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.HITSAdmin.operatore_LCO.OperatorsLCOPage;
import com.mobiotics.HITSAdmin.operators_MSO.OperatorsMSOPage;

public class HomePage extends NavigationMenu{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Operators ']")
	public WebElement operatorMenu;
	
	@FindBy(xpath = "//a[text()='Bulk ']")
	public WebElement bulkMenu;
	
	@FindBy(xpath = "//a[text()='Report ']")
	public WebElement reportMenu;
	
	@FindBy(xpath = "//a[text()='Message ']")
	public WebElement messageMenu;
	
	@FindBy(xpath = "//a[text()='DueDate']")
	public WebElement dueDateMenu;
	
	@FindBy(xpath = "//a[text()='Subuser ']")
	public WebElement subuserMenu;
	
	@FindBy(xpath = "//a[text()='Banks ']")
	public WebElement banksMenu;
	
	@FindBy(xpath = "//a[text()='Maintenance']")
	public WebElement maintenanceMenu;
	
	//---------------Navigate to the Operators > LCO page--------
	public OperatorsLCOPage navigateToOperatorsLCO()
	{
		waitTillElementIsClickable(operatorMenu);
		operatorMenu.click();
		waitTillElementIsClickable(operatorsLCO);
		operatorsLCO.click();
		return new OperatorsLCOPage();
	}
	
	public OperatorsMSOPage navigateToOperatorsMSOPage()
	{
		waitTillElementIsClickable(operatorMenu);
		operatorMenu.click();
		waitTillElementIsClickable(operatorsMSO);
		operatorsMSO.click();
		return new OperatorsMSOPage();
	}
	
	
	
	
	
	
}
