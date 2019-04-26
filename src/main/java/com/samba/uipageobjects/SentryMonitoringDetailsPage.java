/*
 * This is the page class forSentryMonitoringDetailsPage.
 * All the methods defined here can be re-used to find the web element in Sentry Monitoring Details Page  and perform actions.
 * 
 */


package com.samba.uipageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SentryMonitoringDetailsPage {
	public static WebElement element = null;
	
	public static String getPageDetails(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')]"));
		return element.getText();
	}
	
	
}
