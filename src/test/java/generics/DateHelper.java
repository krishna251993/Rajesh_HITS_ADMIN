package generics;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobiotics.HITSAdmin.commonpages.BasePage;

public class DateHelper extends BasePage{
	
	 public  void selectDate (String xp1, String xp2, int dateVal)
		{
			boolean br=false;
			for(int i=1; i<=5; i++)
			{
				for(int j=1; j<=7; j++)
				{
					
					WebElement calDate = driver.findElement(By.xpath(xp1+i+xp2+j+"]"));
					waitTillElementIsVisible(calDate);
					if(!((calDate.getAttribute("class")).equals("off")))
					{
						int calDateNum = Integer.parseInt(calDate.getText());
						if(calDateNum==dateVal)
						{
							calDate.click();
							br=true;
							break;
							
						}
					}
					
				}
				if(br) {
					break;
				}
					
			}
		}


	 public void selectMonth(WebElement previousMonth, WebElement nextMonth, String currentMonth, int mm)
		{
			ArrayList<String> monthList = new ArrayList<String>();
			monthList.add("");
			monthList.add("January");
			monthList.add("February");
			monthList.add("March");
			monthList.add("April");
			monthList.add("May");
			monthList.add("June");
			monthList.add("July");
			monthList.add("Auguast");
			monthList.add("September");
			monthList.add("October");
			monthList.add("November");
			monthList.add("December");
		
			int index = monthList.indexOf(currentMonth);
			int difference = mm-index;
		
			while(difference!=0)
			{
				if(difference<0)
				{
					previousMonth.click();
					difference++;
				}
				else if(difference>0)
				{
					nextMonth.click();
					difference--;
				}
			}
		
		
		}
	 
	 
	 public void selectYear(WebElement previousClick, WebElement nextClick, int currentYear, int selectYear)
		{
			int difference = selectYear - currentYear;
			
				while(difference<0)
				{
					previousClick.click();
					difference++;
				}
				
				while(difference>0)
				{
					nextClick.click();
					difference--;
				}
			
			
			
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
