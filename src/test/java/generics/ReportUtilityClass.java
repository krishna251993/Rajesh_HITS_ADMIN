package generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class ReportUtilityClass extends BasePage{
	
	
	public void searchByTextFilter(WebElement txtFldElement, WebElement goBtn, String value)
	{
		txtFldElement.sendKeys(value);
		waitTillElementIsClickable(goBtn);
		goBtn.click();
	}
	
	public void downloadReport(WebElement downloadBtn)
	{
		downloadBtn.click();
		try
		{
			Runtime run = Runtime.getRuntime();
			run.exec(System.getProperty("user.dir")+"\\exeFiles\\saveReport.exe");
		}
		catch (Exception e) {
			
		}
	}
	
	public boolean verifyDataDisplaying(List<WebElement> elementList, String xp1, String xp2)
	{
		for(int i=1; i<elementList.size(); i++)
		{
			List<WebElement> elementDisplaying = driver.findElements(By.xpath(xp1+i+xp2));
			String action1 = elementDisplaying.get(0).getText();
			String action2 = elementDisplaying.get(1).getText();
			if(elementDisplaying.size()<2)
			{
				return false;
			}
			else if(!(action1.equalsIgnoreCase("Approve") && action2.equalsIgnoreCase("Reject")))
			{
				return false;
			}
		}
		return true;
	}

}
