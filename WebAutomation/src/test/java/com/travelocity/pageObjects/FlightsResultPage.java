package com.travelocity.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class FlightsResultPage extends BasePage {


	By listingSort = By.xpath("//select[@data-test-id=\"sortDropdown\"]");
	By elementlistsort = By.xpath("//li[@data-test-id=\"offer-listing\"]");
	By btnSelect = By.xpath("//button[starts-with(@data-test-id,'select-')]");
	By secondSelectPage1 = By.xpath("//button[@data-offer-index=\"2\"]");
	By secondSelectPage2 = By.xpath("//button[@data-test-id=\"select-link\"]");
	By thirdSelectPage2 = By.xpath("//ul[@data-test-id=\"listings\"]//following::button[3]");
	By baggageFess = By.xpath("//div[@data-test-id=\"details-confidence-messaging\"]");
	By durationFlight = By.xpath("//span[@class=\"duration-emphasis\"]");
	By elementListSortPage1 = By.xpath("//button[@data-test-id=\"select-button\"]");
	By btnSelectThisFare = By.xpath("//button[@data-test-id=\"select-button-1\"]");
	By btnSelectThisFareThird = By.xpath("//ul[@class=\"segmented-list results-list price-sort\"]//following::button[9]");
	By elementListSortPage2 = By.xpath("//button[@data-test-id=\"select-link\"]");
	By btnCancelPopUpPage1 = By.xpath("//a[@data-test-id=\"forcedChoiceNoThanks\"]");
	By tripTotalPricePage2 = By.xpath("//table[@data-test-id=\"trip-total\"]//following::span[1]");
	By tripTotalPricePage1 = By.xpath("//div[@class=\"tripTotals\"]//following::span[2]");
	By btnShowDetails = By.xpath("//button[contains(text(), \"Show \")]");
	By priceGuarantee = By.xpath("/html/body/main/div/div[2]/section[1]/div/div[2]/div/div[2]");
	By btnConfirmarPage1 = By.id("bookButton");
	By btnConfirmarPage2 = By.xpath("//button[@data-test-id=\"goto-checkout-button\"]");
	
	By listaInformacionVuelos = By.xpath("//div[@class='flightSummary-timeDuration cf']");
	By middleNameCheckout = By.xpath("//input[@data-tealeaf-name=\"middleName\"]");
	By firstNameCheckout = By.xpath("//input[@id='firstname[0]']");
	By lastNameCheckout = By.xpath("//input[@id=\"lastname[0]\"]");
	By phoneNumberCheckout = By.xpath("//input[@id=\"phone-number[0]\"]");
	By nameOnCardCheckout = By.xpath("//input[@data-tealeaf-name=\"cardHolderName_1\"]");
	By creditCardNumberCheckout = By.xpath("//input[@id=\"creditCardInput\"]");
	
	String parentWindow = driver.getWindowHandle();
	
	
		
		@FindBy(xpath = "elementlistsort")
		private List<WebElement> listFlights;
		@FindBy(xpath = "durationFlight")
		private List<WebElement> listDurationFlights;
		@FindBy (xpath = "btnSelectThisFare")
		private List<WebElement> listSelectFare;
		@FindBy(id = "flightModuleList")
	    private List<WebElement> listHotelsContainer;
		@FindBy(xpath = "//*[contains(@data-test-id, 'duration')]")
	    private List<WebElement> listDurationsContainer;
		@FindBy(xpath = "//button[starts-with(@data-test-id,'select-')]")
		private List<WebElement> ListaHoteles;
		@FindBy(xpath = "//div[@class='flightSummary-timeDuration cf']")
		private List<WebElement> ListaInformacion;
		
		
		public FlightsResultPage(WebDriver driver){
			super(driver);
		}
		
		
		public boolean verifyFlightDurationPresence() {
	        for (WebElement hotel : listHotelsContainer)
	            if (!hotel.findElement(By.xpath("//*[contains(@data-test-id, 'duration')]")).isDisplayed()) return false;
	        return true;
	    }
		
		public boolean verifySelectButtonPresence() {
	        for (WebElement hotel : listHotelsContainer)
	            if (!hotel.findElement(By.xpath("//button[starts-with(@data-test-id,'select-')]")).isDisplayed()) return false;
	        return true;
	    }
		public boolean verifyFlightFeesAndDetailsPresence() {
	        for (WebElement hotel : listHotelsContainer)
	        	if (!hotel.findElement(By.xpath("//*[p[text()='No change fees'] or span[@class=\"uitk-badge-text\"]]")).isDisplayed()) return false;
	        return true;
	    }
			
		public boolean validateOrderListIntegers(List<Integer> listIntegers) {
	        for (int i = 1; i < listIntegers.size(); i++) {
	            if (listIntegers.get(i - 1).compareTo(listIntegers.get(i)) > 0)
	                return false;
	        }
	        return true;
	    }
		
		 public List<Integer> hoursFormatToTotalMinutes(List<WebElement> durationList) {
		        ArrayList<Integer> listMinutes = new ArrayList<>();
		        for (WebElement duration : durationList) {
		            String[] occurrences = duration.getText().split(" ");	                     
		            if(occurrences[0].contains("h")) {
		            	int hours = Integer.parseInt(occurrences[0].substring(0, occurrences[0].indexOf('h')));
		            	int minutes = Integer.parseInt(occurrences[1].substring(0, occurrences[1].indexOf('m')));
			            int totalMinutes = ((hours * 60) + minutes);
			            listMinutes.add(totalMinutes);
		            }else {
		            	int minutes = Integer.parseInt(occurrences[0].substring(0, occurrences[0].indexOf('m')));
			            int totalMinutes = (minutes);
			            listMinutes.add(totalMinutes);
		            }
		            
		        }
		        return listMinutes;
		    }
		
		public boolean verifyListIsSorted() {
			waitUntilElementClickable(elementlistsort);
			
	        return validateOrderListIntegers(hoursFormatToTotalMinutes(listDurationsContainer));
	    }
		
		public boolean areValuesInTheDropdown(WebElement element, List<String> expectedOptions) {
	        waitElementVisibility(element);
	        for (WebElement option : new Select(element).getOptions())
	            if (!expectedOptions.contains(option.getText())) return false;
	        return true;
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
		
		public boolean verificar_valores_box_SortBy() {
			
			waitUntilElementClickable(listingSort);
			return  areValuesInTheDropdown(driver.findElement(By.xpath("//select[@data-test-id=\"sortDropdown\"]")), Arrays.asList("Price (Lowest)", "Price (Highest)",
	                "Duration (Shortest)", "Duration (Longest)", "Departure (Earliest)",
	                "Departure (Latest)", "Arrival (Earliest)", "Arrival (Latest)"));
		}
		
		public boolean verificar_button_select_present() {
	        for (WebElement hotel : listFlights)
	            if (!hotel.findElement(btnSelect).isDisplayed()) return false;
	        return true;
	    }
		
		public boolean verificar_span_Fees() {
	        for (WebElement hotel : listFlights)
	            if (!hotel.findElement(baggageFess).isDisplayed()) return false;
	        return true;
	    }
		
		public boolean verificar_span_durationFlights() {
	        for (WebElement hotel : listFlights)
	            if (!hotel.findElement(durationFlight).isDisplayed()) return false;
	        return true;
	    }
		
		public String selectDropDownList_SortBy() {
	        Select selectList = new Select(findElement(listingSort));
	        selectList.selectByVisibleText("Duration (Shortest)");
	        return getTextE(selectList.getFirstSelectedOption());	        
	    }
		
		public void select_first_result() {
		
			waitUntilElementClickable(elementlistsort);
			if(isDisplayedOnPage(elementListSortPage1)) 
			{
				click(elementListSortPage1);
				click(btnSelectThisFare);
			}
			else {
				click(elementListSortPage2);
				click(elementListSortPage1);		
			}
			
		}
		
		public void click_popUp_NoThanks() {
			if(isDisplayedOnPage(btnCancelPopUpPage1)) 
			{
				click(btnCancelPopUpPage1);				
			}
		}
		
		public void select_third_result() {
			waitUntilElementClickable(elementlistsort);
			if(isDisplayedOnPage(elementListSortPage2)) 
			{
				click(thirdSelectPage2);
				WebElement drop3 = driver.findElement(By.xpath("//button[@data-test-id=\"select-button\"]"));
				clickWebElement(drop3);
				click_popUp_NoThanks();
			}
			else {
				
				click(secondSelectPage1);
				click(btnSelectThisFareThird);
				isDisplayedOnPage3(btnCancelPopUpPage1);
				click_popUp_NoThanks();
				
			}
		}
			
		public boolean verificar_existencia_trip_Details() {
			Set<String> allwindows= driver.getWindowHandles();
			ChangedriverChildWindow(parentWindow, allwindows);
			waitUntilElementClickable(btnShowDetails);			
			if(isDisplayedOnPage(tripTotalPricePage2)) 
			{
				click(btnConfirmarPage2);
				return true;
			}
			else
			{
				WebElement TripPrice = driver.findElement(By.xpath("/html/body/main/div/div[2]/section[1]/div/div[2]/div/div[1]/span[2]"));
				WebElement infoDuration = driver.findElement(By.xpath("//div[@class=\"flightSummary-timeDuration cf\"]"));
				WebElement priceGuarantee = driver.findElement(By.xpath("/html/body/main/div/div[2]/section[1]/div/div[2]/div/div[2]"));
				List<WebElement> infoList = new ArrayList<>();
				infoList.add(TripPrice);
				infoList.add(infoDuration);
				infoList.add(priceGuarantee);
				for (WebElement item : infoList)
			            if (!item.isDisplayed()) return false;
					click(btnConfirmarPage1);
			        return true;
			}
		}
		
		public boolean verificar_exitencia_priceGuarantee() {
			if(isDisplayedOnPage(priceGuarantee)) return true; 
			return false;
		}
		
		public boolean verificar_existencia_input_FirstName() {
			waitUntilElementClickable(firstNameCheckout);
			if(isDisplayedOnPage(firstNameCheckout)) return true;  
			return false;	
		}
		
		public boolean verificar_existencia_input_middleName() {
			if(isDisplayedOnPage(middleNameCheckout)) return true;  
			return false;	
		}
		
		public boolean verificar_existencia_input_lastName() {
			if(isDisplayedOnPage(lastNameCheckout)) return true;  
			return false;	
		}
		
		public boolean verificar_existencia_input_phone() {
			if(isDisplayedOnPage(phoneNumberCheckout)) return true;  
			return false;	
		}
		
		public boolean verificar_existencia_input_creditCard() {
			if(isDisplayedOnPage(creditCardNumberCheckout)) return true;  
			return false;	
		}	
		
}
