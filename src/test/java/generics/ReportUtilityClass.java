package generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class ReportUtilityClass extends BasePage{
	
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
	
	public int countNoOfRecords(List<WebElement> elementList, WebElement nextLink, WebElement previousLink) throws InterruptedException {
		int count = elementList.size();
		try {
			while (nextLink.isEnabled()) {
				nextLink.click();
				Thread.sleep(4000);
				waitForVisibiltyOfListOfElements(elementList);
				count = count + elementList.size();

			}
		} catch (Exception e) {
			return count;
		}
		
		while(previousLink.isEnabled())
		{
			previousLink.click();
			Thread.sleep(5000);
			waitForVisibiltyOfListOfElements(elementList);
		}
		
		return count;
	}
	
	public int verifyFirstString(List<WebElement> elementList, String matcherString, WebElement nextBtLink) throws InterruptedException
	{
		int count = 0;
		for(int i=0; i<elementList.size(); i++)
		{
			
			count++;
			
			String actualStringTxt = elementList.get(i).getText();
			String actualStringTxtArr[] = actualStringTxt.split(" ");
			if(!((actualStringTxtArr[0].toLowerCase()).contains(matcherString.toLowerCase())))
			{
				return count;
				
			}
			
			
			if(i==elementList.size()-1 && nextBtLink.isEnabled())
			{
				nextBtLink.click();
				Thread.sleep(5000);
				i = -1;
			}
		}
		return count;
	}
	

}
