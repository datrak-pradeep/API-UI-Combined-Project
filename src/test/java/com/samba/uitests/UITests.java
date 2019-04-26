/*
 * TestClass for test nasa ui page and validations for below.
1. Drop down should display 4 options, i.e. 10, 25, 50 and 75
2. 25 entries should be selected by default
3. Clicking on any of the entries in this table should open a page similar
to https://cneos.jpl.nasa.gov/sentry/details.html#?des=29075, 
validate the des value in query paramter to this opened page
 Author -pdatrak
 */

package com.samba.uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.samba.uipageobjects.SentryMonitoringDetailsPage;
import com.samba.uipageobjects.SentryMonitoringPage;

public class UITests {
	public static WebElement element = null;
	String baseUrl;
	private static WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		baseUrl = "https://cneos.jpl.nasa.gov/sentry/";

		String os = System.getProperty("os.name").toLowerCase().trim();
		
		System.out.println("Tests are running on --> " + os);
		
		if (os.contains("mac os x")) 
		{
			
			System.setProperty("webdriver.chrome.driver", "/Users/pdatrak/Downloads/chromedriver");
		} 
		else 
		{
			System.setProperty("webdriver.chrome.driver", "/Users/pdatrak/Downloads/chromedriver.exe");
		}
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		
	}

	@Test
	public void validate_show_entires() 
	{
		String expectedDropdownvalues[] = { "10", "25", "50", "100" };

		List<WebElement> actualDropDownvalues = SentryMonitoringPage.getDropdownEntries(this.driver);

		for (int i = 0; i < actualDropDownvalues.size(); i++) 
		{
			Assert.assertEquals(expectedDropdownvalues[i], actualDropDownvalues.get(i).getText());

			System.out.println("Actual Drop down values from page -->" + actualDropDownvalues.get(i).getText());

		}
		
	}

	@Test
	public void validate_Default_DropDown_entry() 
	{
		
		String expected_DefaultDropdown_value = "25";
		
		String actual_DefaultDropdown_value = SentryMonitoringPage.getDefaultEntry(this.driver).getText();
		
		System.out.println("Default Actual selected value -->" + actual_DefaultDropdown_value);
		
		Assert.assertEquals(expected_DefaultDropdown_value, actual_DefaultDropdown_value);
	}

	@Test
	public void validate_link_page() {

		String linkText = "29075 (1950 DA)";

		SentryMonitoringPage.tableValuesLink(this.driver, linkText);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("current URL -->" + currentUrl);

		String getPageDetails = SentryMonitoringDetailsPage.getPageDetails(driver);

		String[] desValueFromPage = getPageDetails.split("--");

		System.out.println("text after split-->" + desValueFromPage[0]);

		boolean urlWithCorrectPage = currentUrl.contains((desValueFromPage[0]).trim());

		Assert.assertTrue(urlWithCorrectPage, "Validating the URL with page values");
		

	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
