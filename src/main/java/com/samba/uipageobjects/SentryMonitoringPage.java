/*
 * This is the page class for add expenses page.
 * All the methods defined here can be re-used to find the web element and perform actions.
 */

package com.samba.uipageobjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class SentryMonitoringPage {
	public static WebElement element = null;

	public static WebElement getDefaultEntry(WebDriver driver) {
		element = driver.findElement(By.name("riskTable_length"));
		Select select = new Select(element);
		//select.selectByVisibleText(str1);
		WebElement dropdownSelectedvalue = select.getFirstSelectedOption();
		return dropdownSelectedvalue;
	}
	
	
	public static  List<WebElement> getDropdownEntries(WebDriver driver) {
		List<String> actualPageDropdownvalues = new ArrayList<String>();
		List<WebElement> dropdownvalues =null;
		
		try{
			
			Select selectValues = new Select(driver.findElement(By.name("riskTable_length")));
			dropdownvalues = selectValues.getOptions();
			int size = dropdownvalues.size();
			
		}
		catch (Exception e) {
			}
		return dropdownvalues;	
	}

	public static void tableValuesLink(WebDriver driver, String str) {
		element = driver.findElement(By.linkText(str));
		element.click();
		
	}
	
	
}






