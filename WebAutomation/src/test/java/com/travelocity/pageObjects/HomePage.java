package com.travelocity.pageObjects;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage  {

	
	
	/*** Locators Exercise 1 ***/
	
	By buttonFlightOnly = By.xpath("//a[@aria-controls=\"wizard-flight-pwa\"]");
	By dropdownList_Adults = By.xpath("//a[@data-testid=\"travelers-field\"]");
	By btnRoundtrip = By.xpath("//a[@aria-controls=\"wizard-flight-tab-roundtrip\"]");
	By btnInputOrigin = By.xpath("//button[@data-stid=\"location-field-leg1-origin-menu-trigger\"]");
	By inputInputOrigin = By.xpath("//input[@id=\"location-field-leg1-origin\"]");
	By btnInputDestination = By.xpath("//button[@data-stid=\"location-field-leg1-destination-menu-trigger\"]");
	By inputDestination = By.xpath("//input[@id=\"location-field-leg1-destination\"]");
	By dataPickerDeparting = By.id("d1-btn");
	By btnNextDeparting = By.xpath("//div[@class=\"uitk-flex uitk-flex-justify-content-space-between uitk-date-picker-menu-pagination-container\"]/button[2]");
	By MayDia1 = By.xpath("//button[@data-day=\"1\"]");
	By MayDia14 = By.xpath("//button[@data-day=\"14\"]");
	By btnDoneCalendar = By.xpath("//button[@data-stid=\"apply-date-picker\"]");
	By btnFirstSearch = By.xpath("//button[@data-testid=\"submit-button\"]");
	
	
	By buttonFlightPlusHotel = By.id("tab-package");
	By dropdownList_AdultsFH = By.id("FH-NumAdult1");
	By inputOriginFH = By.id("FH-origin");
	By inputDestinationFH = By.id("FH-destination");
	By dataPickerDepartingFH = By.id("FH-fromDate");
	By btnNextDepartingFH = By.xpath("//button[@class=\"datepicker-paging datepicker-next btn-paging btn-secondary next\"]");
	By dataPickerReturningFH = By.id("FH-toDate");
	By aprilDay1 = By.xpath("//*[@id=\"FH-fromDate-label\"]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/button[1]");
	By aprilDay13 = By.xpath("//*[@id=\"FH-toDate-label\"]/div/div/div[2]/table/tbody/tr[3]/td[3]/button");
	By searchFH = By.id("FH-searchButtonExt1");
	
	/*** Locators Exercise 3 ***/
	By HotelsOnly = By.xpath("//button[@data-stid=\"location-field-destination-menu-trigger\"]");
	By buttonDestinationHotelOnly = By.xpath("//button[@data-stid=\"location-field-destination-menu-trigger\"]");
	By inputDestinationHotelOnly = By.xpath("//*[@id=\"location-field-destination\"]");
	By firstOptionDestination = By.xpath("//li[@data-index=\"0\"]//following::button");
	By searchHotelOnly = By.xpath("//button[@data-testid=\"submit-button\"]");
	By discountTitle = By.xpath("//h3[contains(text(), 'You could save 10% or more right now')]");
	By discountSignUp = By.xpath("//a[contains(text(), 'Sign up')]");
	
	// locators Exercise 4
	
	By btnFlights = By.xpath("//a[@aria-controls='wizard-flight-pwa']");
	By btnLeavingFrom = By.xpath("//button[@data-stid='location-field-leg1-origin-menu-trigger']");
	By inputLeavingFrom = By.xpath("//input[@data-stid='location-field-leg1-origin-menu-input']");
	By btnGoingTo = By.xpath("//button[@data-stid='location-field-leg1-destination-menu-trigger']");
	By inputGoingTo = By.xpath("//input[@data-stid='location-field-leg1-destination-menu-input']");
	By checkAddPlaceToStay = By.xpath("//*[@id='add-hotel-checkbox']");
	By btnCalendars = By.xpath("//button[@data-stid='open-date-picker']");
	By day16March = By.xpath("//button[@data-day='16']");
	By day31March = By.xpath("//button[@data-day='31']");
	By btnDoneCalendars = By.xpath("//button[@data-stid='apply-date-picker']");
	By day10March = By.xpath("//button[@data-day='10']");
	By day15March = By.xpath("//button[@data-day='15']");
	By btnSearch = By.xpath("//button[@data-testid=\"submit-button\"]");
	By adviseErrorTitle = By.xpath("//h3[@class='uitk-error-summary-heading']");
	By adviseErrorCalendarOne = By.xpath("//div[@id='d1-error']");
	By adviseErrorCalendarTwo = By.xpath("//div[@id='d2-error']");
	
	
	
	//locators Exercise 5
	By cruisesButton = By.xpath("//a[@aria-controls=\"wizard-cruise-pwa\"]");
	By selectGoingto = By.xpath("//select[@id=\"cruise-destination\"]");
	By JulyDay1 = By.xpath("//button[@data-day=\"1\"]");
	By JulyDay31 = By.xpath("//button[@data-day=\"31\"]");
	
	//locators Exercise 2
	By JulyDay13 = By.xpath("//button[@data-day=\"13\"]");
	
	/*** Constructor ***/
	public HomePage(WebDriver driver) {
		 super(driver);
	}
	
	/*** Métodos ***/
	
	/*** Métodos Ejercicio 1***/
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
		
	 public void realizar_click_btn_flights() {
		 click(buttonFlightOnly);
	 }
	 
	 public void realizar_click_btn_roundtrip() {
		 click(btnRoundtrip);
	 }
	 
	 public void realizar_ingreso_datos_leavingFrom() {
		 click(btnInputOrigin);
		 click(inputInputOrigin);
		 type("Las Vegas (LAS - All Airports)" + Keys.ENTER, inputInputOrigin);
	 }
	 
	 public void realizar_ingreso_datos_goingTo() {
		 click(btnInputDestination);
		 click(inputDestination);
		 type("Los Angeles (LAX - Los Angeles Intl.)" + Keys.ENTER, inputDestination);
	 }
	 
	 public void realizar_seleccion_dates() {
		 click(dataPickerDeparting);
		 click(btnNextDeparting);
		 click(btnNextDeparting);
		 click(MayDia1);
		 click(MayDia14);
		 click(btnDoneCalendar);
		 
	 }
	 
	 public void realizar_click_btn_search() {
		 click(btnFirstSearch);
	 }
	 
	 public boolean verificar_1_traveler() {
		 String text = findElement(dropdownList_Adults).getText();
		 boolean resultado = false;
		 if (text.equals("1 traveler")) {
			 resultado = true;
		 }
		 
		 return resultado;
	 }
	 /*** Fin Métodos Ejercicio 1***/
	 
	 /*** Metodos Ejercicio 2  ***/
	 
		public void searchFlightsPlusHotel() {
			click(btnFlights);
			 click(btnLeavingFrom);
			 type("LAS" + Keys.ENTER, inputLeavingFrom);
			 click(btnGoingTo);
			 type("LAX" + Keys.ENTER, inputGoingTo);
			 findElement(checkAddPlaceToStay).click();
			 List<WebElement> listCalendars = findElements(btnCalendars);
			 listCalendars.get(0).click();
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(JulyDay1);
			 click(JulyDay13);
			 click(btnDoneCalendars);
			 listCalendars.get(2).click();
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(btnNextDeparting);
			 click(JulyDay1);
			 click(JulyDay13);
			 click(btnDoneCalendars);
			 click(btnSearch); 	
			
		}
		
		/*** Fin Metodos Ejercicio 2  ***/
	 
	 /*** Métodos Ejercicio 3***/
	 
	 public void realizar_click_btn_Hotels() {
		 click(HotelsOnly);
	 }
	 
	 public void realizar_ingreso_GoingTo() {
		 click(inputDestinationHotelOnly);
		 type("Montevideo, Uruguay" + Keys.ENTER, inputDestinationHotelOnly);
	 }
	 
	 public void realizar_click_btn_SearchHotels() {
		 click(searchHotelOnly);
	 }
	 
	 public boolean verificar_existencia_title_discount() {
		 return findElementPresence(discountTitle);
	 }
	 
	 public boolean verificar_existencia_SignUp_free() {
		 return findElementPresence(discountSignUp);
	 }
	 
	 /*** Fin Metodos Ejercicio 3***/
	 
	 /*** Metodos Ejercicio 4 ***/
	 
	 public void searchFlightHotelExercise4() {
		 click(btnFlights);
		 click(btnLeavingFrom);
		 type("Montevideo (MVD - Carrasco Intl.)" + Keys.ENTER, inputLeavingFrom);
		 click(btnGoingTo);
		 type("Rome (ROM - All Airports)" + Keys.ENTER, inputGoingTo);
		 findElement(checkAddPlaceToStay).click();
		 List<WebElement> listCalendars = findElements(btnCalendars);
		 listCalendars.get(0).click();
		 click(day16March);	
		 click(day31March);	
		 click(btnDoneCalendars);
		 listCalendars.get(2).click();
		 click(day10March);	
		 click(day15March);
		 click(btnDoneCalendars);
		 click(btnSearch); 	 
	 }
	 
	 public boolean verificar_Error_Title_existence() {
		 return findElementPresence(adviseErrorTitle);
	 }
	 
	 public boolean verificar_Error_Calendar_One_existence() {
		 return findElementPresence(adviseErrorCalendarOne);
	 }
	 
	 public boolean verificar_Error_Calendar_Two_existence() {
		 return findElementPresence(adviseErrorCalendarTwo);
	 }
	 
	 /*** Fin Metodos Ejercicio 4***/
	 
	 /*** Metodos Ejercicio 5  ***/
	 
	 
	 public void realizar_click_btn_Cruises() {
		 click(cruisesButton);
	 }
	 
	 public String selectDropDownList_Europe() {
	        Select selectList = new Select(findElement(selectGoingto));
	        selectList.selectByVisibleText("Europe");
	        return getTextE(selectList.getFirstSelectedOption());	        
	    }
	 
	 public void selectDatesCruises() {
		 click(dataPickerDeparting);
		 click(btnNextDeparting);
		 click(btnNextDeparting);
		 click(btnNextDeparting);
		 click(btnNextDeparting);
		 click(JulyDay1);
		 click(JulyDay31);
		 click(btnDoneCalendar);
		 click(btnFirstSearch);
	 }
	 
	 /*** Fin Metodos Ejercicio 5  ***/
	 
	
	
		
				
}
		
