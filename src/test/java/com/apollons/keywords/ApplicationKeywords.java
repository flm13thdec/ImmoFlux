package com.apollons.keywords;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class ApplicationKeywords extends ValidationKeywords {

	public void mouseHover(String locatorKey) {
		
		new Actions(driver).moveToElement(getElement(locatorKey)).build().perform();
		
	}

	public void switchToHomeWindow() {
		
		driver.switchTo().window(homeWindowId);
		
	}
	
	public void switchToFrame() {
		
		driver.switchTo().frame(0);
		
	}
	
	
	public void switchToAnotherWindow() {
		
		homeWindowId=driver.getWindowHandle();
		
		Set<String> allWindowIds=driver.getWindowHandles();
		
		for(String windowId:allWindowIds)
		{
			if(!windowId.equalsIgnoreCase(homeWindowId))
			{
			driver.switchTo().window(windowId);
			break;
			}
						
		}
		
	}

	public void openDescriptionWindow()
	{
		((JavascriptExecutor) driver).executeScript("window.open()");
		
		switchToAnotherWindow();
		
		driver.navigate().to(System.getProperty("user.dir")+"\\desc.html");
		
	}
	
}
