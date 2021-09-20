package com.travelocity.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.travelocity.pageObjects.CruisesPage;
import com.travelocity.pageObjects.HomePage;

public class TC_Exercise_005 extends Base{

	HomePage objHome;
	CruisesPage objcruisesPage;	
		
	
	@Test
	public void goToHotelsPage() {
		
		objHome = new HomePage(driver);
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		objHome.realizar_click_btn_Cruises();
		objHome.selectDropDownList_Europe();
		objHome.selectDatesCruises();
		driver.getCurrentUrl();
		objcruisesPage = new CruisesPage(driver);
		Assert.assertTrue(objcruisesPage.verify_results_Europe(), "Europe was not found in the results");
		objcruisesPage.verify_elements_beClickable();
		Assert.assertTrue(objcruisesPage.verify_presence_cruises(), "Cruise ships are not present");
		Assert.assertTrue(objcruisesPage.verify_presence_message_cruises(), "Messages not found");
		Assert.assertTrue(objcruisesPage.verify_presence_discount(), "No discount found");
		Assert.assertFalse(objcruisesPage.verify_presence_noDiscount(), "No non-discounted cruise found");
		objcruisesPage.click_better_discount_cruise();
		tearDown();
	}	
}
