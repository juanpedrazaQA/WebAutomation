package com.travelocity.testCases;


import org.testng.annotations.Test;
import com.travelocity.pageObjects.FlightsHotelResultPage;
import com.travelocity.pageObjects.FlightsResultPage;
import com.travelocity.pageObjects.HomePage;

public class TC_Exercise_002 extends Base{

	
	HomePage objHome;
	FlightsResultPage objFlights;
	FlightsHotelResultPage objFlightsHotel;
	
		@Test 
		public void goToHomePage() {
		
		objHome = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(baseURL);
		objHome.searchFlightsPlusHotel();
		tearDown();
	}
					
}
