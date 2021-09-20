package com.travelocity.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class FlightsHotelResultPage extends BasePage{
	
	By leavingFromFH = By.xpath("//button[@aria-label=\"Leaving from Las Vegas, NV, United States of America (LAS-All Airports)\"]"); 
	By goingToFH = By.xpath("//button[@aria-label=\"Going to Los Angeles (and vicinity), California, United States of America\"]");
	By travelers = By.xpath("//button[contains(text(), \"1 room, 1 traveler\")]");
	By departing = By.xpath("//button[@aria-label=\"Departing April 1, 2021\"]");
	By returning = By.xpath("//button[@aria-label=\"Returning April 13, 2021\"]");
	By sortBy = By.id("sort");
	By Pricelist = By.xpath("//span[@data-stid=\"content-hotel-lead-price\"]");
	By threeStars = By.xpath("//span[contains(text(), \"3 out of 5\")]");
	By popularAmenities = By.xpath("//h3[contains(text(), \"Popular amenities\")]");
	By cleaningPractices = By.xpath("//h3[contains(text(), \"Cleaning and safety practices\")]");
	By sortPrice = By.xpath("//span[contains(text(), \"Sort by price\")]");
	By changeFlightFH = By.xpath("//span[contains(text(), \"Change flight\")]");
	By titleFlexible = By.xpath("//span[contains(text(), 'Stay flexible with no change fees')]");
	By thirdElementSelected = By.xpath("//button[@data-offer-index=\"2\" and @data-test-id=\"select-button\"]");
	By thirdElementSecondSelected = By.xpath("//button[@data-offer-index=\"2\" and @data-test-id=\"select-button-1\"]");	
	
	By datesInfoFH = By.xpath("//div[@class=\"dates-info\"]");
	By ticketTravelerInfoFH = By.xpath("//div[@class=\"ticket-traveler-info\"]");
	By tripTotal = By.id("tripTotal");
	By tripSavings = By.id("val_amtSavings");
	By hotelFeesTotal = By.xpath("//span[@id=\"hotelFeesTotal\"]");
	By buttonNextFinal = By.xpath("//*[@id=\"FlightUDPBookNowButton1\"]/button");
	
	By dateInfoFH = By.xpath("//div[@class=\"date-info\"]");
	By ticketFinalTravelerInfoFG = By.xpath("//div[@class=\"product-description\"]");
	By finalTripTotal = By.xpath("//span[@data-price-update=\"finalTripTotal\"]");
	By finalTripSavings = By.xpath("//dd[@data-price-update=\"tripSavings\"]");
	By finalHotelFeesTotal = By.xpath("//span[@data-price-update=\"totalIncludedHotelChargedFees\"]");
	
	By finalFirstName = By.id("firstname[0]");
	By finalLastName = By.id("lastname[0]");
	By finalSelectCountry = By.xpath("//select[@name=\"tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].phoneCountryCode\"]");
	By finalphoneNumber = By.xpath("//input[@name=\"tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].phoneNumber\"]");
	By finalSelectMonth = By.xpath("//select[@name=\"tripPreferencesRequests[0].airTripPreferencesRequest.travelerPreferences[0].dateOfBirth.month\"]");
	
	
	@FindBy(xpath= "//span[@data-stid=\"content-hotel-lead-price\"]")
	private List<WebElement> listPriceContainer;
	@FindBy(xpath = "//a[@data-stid=\"open-hotel-information\"]")
	private List<WebElement> listHotels;
	@FindBy(xpath = "//button[@data-stid=\"submit-hotel-reserve\"]")
	private List<WebElement> listRooms;
	@FindBy(xpath = "//button[starts-with(@data-test-id,'select-')]")
	private List<WebElement> listFlights;
	@FindBy(xpath = "//button[starts-with(@data-test-id, 'select-button-1')]")
	private List<WebElement> listSelectFare;
	@FindBy(xpath = "//button[@class=\"btn-secondary btn-sub-action  gt-add-btn\"]")
	private List<WebElement> listBtnCar;
	
	
	
	
	public FlightsHotelResultPage(WebDriver driver){
		super(driver);
	}
	
	
	public String selectDropDownList_SortBy() {
		
        Select selectList = new Select(findElement(sortBy));
        selectList.selectByVisibleText("Price");
        return getTextE(selectList.getFirstSelectedOption());
    }
		
	public List<Integer> FormatNumber(List<WebElement> numberList) {
        ArrayList<Integer> listNumbers = new ArrayList<>();
        for (WebElement duration : numberList) {
            String occurrences = duration.getText();           
            int number = Integer.parseInt(occurrences.substring(1));           
            listNumbers.add(number);
            
        }
        
        return listNumbers;
	}
	
	public boolean validateOrderListIntegers(List<Integer> listIntegers) {
        for (int i = 1; i < listIntegers.size(); i++) {
            if (listIntegers.get(i - 1).compareTo(listIntegers.get(i)) > 0)
                return false;
        }
        return true;
    }
	
	public boolean verifyListIsSorted() {	
        return validateOrderListIntegers(FormatNumber(listPriceContainer));
    }
	
	
	public void ChangedriverChildWindow(String parentWindow, Set<String> allwindows ) {
		for (String childWindow : allwindows) {
		    if(!childWindow.equals(parentWindow))
		      {
		        driver.switchTo().window(childWindow);
		        Reporter.log("Child Window has been Displayed");      
		      }
		   }
	}
	
	
	
	
}
