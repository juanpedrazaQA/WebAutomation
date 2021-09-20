package com.travelocity.testCases;

import com.travelocity.pageObjects.FlightsResultPage;
import com.travelocity.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Exercise_001 extends Base{

	
	
	HomePage objHome;
	FlightsResultPage objFlights;
	
	@Test
	public void goToHomePage() {
		
		objHome = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		objHome.realizar_click_btn_flights();
		objHome.realizar_click_btn_roundtrip();
		objHome.realizar_ingreso_datos_leavingFrom();
		objHome.realizar_ingreso_datos_goingTo();
		Assert.assertTrue(objHome.verificar_1_traveler(), "Cantidad de viajeros distinta de 1");
		objHome.realizar_seleccion_dates();
		objHome.realizar_click_btn_search();
		objFlights = new FlightsResultPage(driver);
		Assert.assertTrue(objFlights.verificar_valores_box_SortBy(), "Los valores del Box son incorrectos");
		Assert.assertTrue(objFlights.verificar_button_select_present(), "El button Select no esta presente en todos los vuelos");
		Assert.assertTrue(objFlights.verificar_span_Fees(), "Baggage Fees no esta presente en todos los vuelos ");
		Assert.assertTrue(objFlights.verificar_span_durationFlights(), "Duration Flight no esta presente en todos los vuelos ");
		objFlights.selectDropDownList_SortBy();
		Assert.assertTrue(objFlights.verifyListIsSorted());
		objFlights.select_first_result();		
		objFlights.select_third_result();
		Assert.assertTrue(objFlights.verificar_existencia_trip_Details(),"No se encontraron los elementos en Trip Details");
		driver.getCurrentUrl();
		objFlights = new FlightsResultPage(driver);	
		Assert.assertTrue(objFlights.verificar_existencia_input_FirstName(), "FirstName input not found");
		Assert.assertTrue(objFlights.verificar_existencia_input_middleName(), "MiddleName input not found");
		Assert.assertTrue(objFlights.verificar_existencia_input_lastName(), "LastName input not found");
		Assert.assertTrue(objFlights.verificar_existencia_input_phone(), "PhoneNumber input not found");
		Assert.assertTrue(objFlights.verificar_existencia_input_creditCard(), "CreditCard input not found");
		tearDown();
		 
	}
	
	

}
